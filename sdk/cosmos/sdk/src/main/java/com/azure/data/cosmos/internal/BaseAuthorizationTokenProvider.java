/*
 * The MIT License (MIT)
 * Copyright (c) 2018 Microsoft Corporation
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.azure.data.cosmos.internal;

import com.azure.data.cosmos.internal.directconnectivity.HttpUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/**
 * This class is used internally by both client (for generating the auth header with master/system key) and by the GATEWAY when
 * verifying the auth header in the Azure Cosmos DB database service.
 */
public class BaseAuthorizationTokenProvider implements AuthorizationTokenProvider {

    private static final String AUTH_PREFIX = "type=master&ver=1.0&sig=";
    private final String masterKey;
    private final Mac macInstance;

    public BaseAuthorizationTokenProvider(String masterKey) {
        this.masterKey = masterKey;
        byte[] masterKeyDecodedBytes = Utils.Base64Decoder.decode(this.masterKey.getBytes());
        SecretKey signingKey = new SecretKeySpec(masterKeyDecodedBytes, "HMACSHA256");
        try {
            this.macInstance = Mac.getInstance("HMACSHA256");
            this.macInstance.init(signingKey);
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new IllegalStateException(e);
        }
    }

    private static String getResourceSegment(ResourceType resourceType) {
        switch (resourceType) {
        case Attachment:
            return Paths.ATTACHMENTS_PATH_SEGMENT;
        case Database:
            return Paths.DATABASES_PATH_SEGMENT;
        case Conflict:
            return Paths.CONFLICTS_PATH_SEGMENT;
        case Document:
            return Paths.DOCUMENTS_PATH_SEGMENT;
        case DocumentCollection:
            return Paths.COLLECTIONS_PATH_SEGMENT;
        case Offer:
            return Paths.OFFERS_PATH_SEGMENT;
        case Permission:
            return Paths.PERMISSIONS_PATH_SEGMENT;
        case StoredProcedure:
            return Paths.STORED_PROCEDURES_PATH_SEGMENT;
        case Trigger:
            return Paths.TRIGGERS_PATH_SEGMENT;
        case UserDefinedFunction:
            return Paths.USER_DEFINED_FUNCTIONS_PATH_SEGMENT;
        case User:
            return Paths.USERS_PATH_SEGMENT;
        case PartitionKeyRange:
            return Paths.PARTITION_KEY_RANGES_PATH_SEGMENT;
        case Media:
            return Paths.MEDIA_PATH_SEGMENT;
        case DatabaseAccount:
            return "";
        default:
            return null;
        }
    }

    /**
     * This API is a helper method to create auth header based on client request using masterkey.
     *
     * @param verb                 the verb.
     * @param resourceIdOrFullName the resource id or full name
     * @param resourceType         the resource type.
     * @param headers              the request headers.
     * @return the key authorization signature.
     */
    public String generateKeyAuthorizationSignature(String verb,
            String resourceIdOrFullName,
            ResourceType resourceType,
            Map<String, String> headers) {
        return this.generateKeyAuthorizationSignature(verb, resourceIdOrFullName,
                BaseAuthorizationTokenProvider.getResourceSegment(resourceType).toLowerCase(), headers);
    }

    /**
     * This API is a helper method to create auth header based on client request using masterkey.
     *
     * @param verb                 the verb
     * @param resourceIdOrFullName the resource id or full name
     * @param  resourceSegment     the resource segment
     * @param headers              the request headers
     * @return the key authorization signature
     */
    public String generateKeyAuthorizationSignature(String verb,
            String resourceIdOrFullName,
            String resourceSegment,
            Map<String, String> headers) {
        if (verb == null || verb.isEmpty()) {
            throw new IllegalArgumentException("verb");
        }

        if (resourceIdOrFullName == null) {
            resourceIdOrFullName = "";
        }

        if (resourceSegment == null) {
            throw new IllegalArgumentException("resourceSegment");
        }

        if (headers == null) {
            throw new IllegalArgumentException("headers");
        }

        if (this.masterKey == null || this.masterKey.isEmpty()) {
            throw new IllegalArgumentException("masterKey");
        }

        if(!PathsHelper.isNameBased(resourceIdOrFullName)) {
            resourceIdOrFullName = resourceIdOrFullName.toLowerCase(Locale.ROOT);
        }

        // Skipping lower casing of resourceId since it may now contain "ID" of the resource as part of the FullName
        StringBuilder body = new StringBuilder();
        body.append(verb.toLowerCase())
                .append('\n')
                .append(resourceSegment)
                .append('\n')
                .append(resourceIdOrFullName)
                .append('\n');

        if (headers.containsKey(HttpConstants.HttpHeaders.X_DATE)) {
            body.append(headers.get(HttpConstants.HttpHeaders.X_DATE).toLowerCase());
        }

        body.append('\n');

        if (headers.containsKey(HttpConstants.HttpHeaders.HTTP_DATE)) {
            body.append(headers.get(HttpConstants.HttpHeaders.HTTP_DATE).toLowerCase());
        }

        body.append('\n');

        Mac mac = null;
        try {
            mac = (Mac) this.macInstance.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }

        byte[] digest = mac.doFinal(body.toString().getBytes());

        String auth = Utils.encodeBase64String(digest);

        return AUTH_PREFIX + auth;
    }

    /**
     * This API is a helper method to create auth header based on client request using resourceTokens.
     *
     * @param resourceTokens the resource tokens.
     * @param path           the path.
     * @param resourceId     the resource id.
     * @return the authorization token.
     */
    public String getAuthorizationTokenUsingResourceTokens(Map<String, String> resourceTokens,
            String path,
            String resourceId) {
        if (resourceTokens == null) {
            throw new IllegalArgumentException("resourceTokens");
        }

        String resourceToken = null;
        if (resourceTokens.containsKey(resourceId) && resourceTokens.get(resourceId) != null) {
            resourceToken = resourceTokens.get(resourceId);
        } else if (StringUtils.isEmpty(path) || StringUtils.isEmpty(resourceId)) {
            if (resourceTokens.size() > 0) {
                resourceToken = resourceTokens.values().iterator().next();
            }
        } else {
            // Get the last resource id from the path and use that to find the corresponding token.
            String[] pathParts = StringUtils.split(path, "/");
            String[] resourceTypes = {"dbs", "colls", "docs", "sprocs", "udfs", "triggers", "users", "permissions",
                    "attachments", "media", "conflicts"};
            HashSet<String> resourceTypesSet = new HashSet<String>();
            Collections.addAll(resourceTypesSet, resourceTypes);

            for (int i = pathParts.length - 1; i >= 0; --i) {

                if (!resourceTypesSet.contains(pathParts[i]) && resourceTokens.containsKey(pathParts[i])) {
                    resourceToken = resourceTokens.get(pathParts[i]);
                }
            }
        }

        return resourceToken;
    }
    public String generateKeyAuthorizationSignature(String verb, URI uri, Map<String, String> headers) {
        if (StringUtils.isEmpty(verb)) {
            throw new IllegalArgumentException(String.format(RMResources.StringArgumentNullOrEmpty, "verb"));
        }

        if (uri == null) {
            throw new IllegalArgumentException("uri");
        }

        if (headers == null) {
            throw new IllegalArgumentException("headers");
        }
        PathInfo pathInfo = new PathInfo(false, StringUtils.EMPTY, StringUtils.EMPTY, false);
        getResourceTypeAndIdOrFullName(uri, pathInfo);
        return generateKeyAuthorizationSignatureNew(verb, pathInfo.resourceIdOrFullName, pathInfo.resourcePath,
                headers);
    }

    public String generateKeyAuthorizationSignatureNew(String verb, String resourceIdValue, String resourceType,
            Map<String, String> headers) {
        if (StringUtils.isEmpty(verb)) {
            throw new IllegalArgumentException(String.format(RMResources.StringArgumentNullOrEmpty, "verb"));
        }

        if (resourceType == null) {
            throw new IllegalArgumentException(String.format(RMResources.StringArgumentNullOrEmpty, "resourceType")); // can be empty
        }

        if (headers == null) {
            throw new IllegalArgumentException("headers");
        }
        // Order of the values included in the message payload is a protocol that
        // clients/BE need to follow exactly.
        // More headers can be added in the future.
        // If any of the value is optional, it should still have the placeholder value
        // of ""
        // OperationType -> ResourceType -> ResourceId/OwnerId -> XDate -> Date
        String verbInput = verb;
        String resourceIdInput = resourceIdValue;
        String resourceTypeInput = resourceType;

        String authResourceId = getAuthorizationResourceIdOrFullName(resourceTypeInput, resourceIdInput);
        String payLoad = generateMessagePayload(verbInput, authResourceId, resourceTypeInput, headers);
        Mac mac = null;
        try {
            mac = (Mac) this.macInstance.clone();
        } catch (CloneNotSupportedException e) {
            throw new IllegalStateException(e);
        }
        byte[] digest = mac.doFinal(payLoad.getBytes());
        String authorizationToken = Utils.encodeBase64String(digest);
        String authtoken = AUTH_PREFIX + authorizationToken;
        return HttpUtils.urlEncode(authtoken);
    }

    private String generateMessagePayload(String verb, String resourceId, String resourceType,
            Map<String, String> headers) {
        String xDate = headers.get(HttpConstants.HttpHeaders.X_DATE);
        String date = headers.get(HttpConstants.HttpHeaders.HTTP_DATE);
        // At-least one of date header should present
        // https://docs.microsoft.com/en-us/rest/api/documentdb/access-control-on-documentdb-resources
        if (StringUtils.isEmpty(xDate) && (StringUtils.isEmpty(date) || StringUtils.isWhitespace(date))) {
            headers.put(HttpConstants.HttpHeaders.X_DATE, Utils.nowAsRFC1123());
            xDate = Utils.nowAsRFC1123();
        }

        // for name based, it is case sensitive, we won't use the lower case
        if (!PathsHelper.isNameBased(resourceId)) {
            resourceId = resourceId.toLowerCase();
        }

        StringBuilder payload = new StringBuilder();
        payload.append(verb.toLowerCase())
                .append('\n')
                .append(resourceType.toLowerCase())
                .append('\n')
                .append(resourceId)
                .append('\n')
                .append(xDate.toLowerCase())
                .append('\n')
                .append(StringUtils.isEmpty(xDate) ? date.toLowerCase() : "")
                .append('\n');

        return payload.toString();
    }

    private String getAuthorizationResourceIdOrFullName(String resourceType, String resourceIdOrFullName) {
        if (StringUtils.isEmpty(resourceType) || StringUtils.isEmpty(resourceIdOrFullName)) {
            return resourceIdOrFullName;
        }
        if (PathsHelper.isNameBased(resourceIdOrFullName)) {
            // resource fullname is always end with name (not type segment like docs/colls).
            return resourceIdOrFullName;
        }

        if (resourceType.equalsIgnoreCase(Paths.OFFERS_PATH_SEGMENT)
                || resourceType.equalsIgnoreCase(Paths.PARTITIONS_PATH_SEGMENT)
                || resourceType.equalsIgnoreCase(Paths.TOPOLOGY_PATH_SEGMENT)
                || resourceType.equalsIgnoreCase(Paths.RID_RANGE_PATH_SEGMENT)) {
            return resourceIdOrFullName;
        }

        ResourceId parsedRId = ResourceId.parse(resourceIdOrFullName);
        if (resourceType.equalsIgnoreCase(Paths.DATABASES_PATH_SEGMENT)) {
            return parsedRId.getDatabaseId().toString();
        } else if (resourceType.equalsIgnoreCase(Paths.USERS_PATH_SEGMENT)) {
            return parsedRId.getUserId().toString();
        } else if (resourceType.equalsIgnoreCase(Paths.COLLECTIONS_PATH_SEGMENT)) {
            return parsedRId.getDocumentCollectionId().toString();
        } else if (resourceType.equalsIgnoreCase(Paths.DOCUMENTS_PATH_SEGMENT)) {
            return parsedRId.getDocumentId().toString();
        } else {
            // leaf node
            return resourceIdOrFullName;
        }
    }

    private void getResourceTypeAndIdOrFullName(URI uri, PathInfo pathInfo) {
        if (uri == null) {
            throw new IllegalArgumentException("uri");
        }

        pathInfo.resourcePath = StringUtils.EMPTY;
        pathInfo.resourceIdOrFullName = StringUtils.EMPTY;

        String[] segments = StringUtils.split(uri.toString(), Constants.Properties.PATH_SEPARATOR);
        if (segments == null || segments.length < 1) {
            throw new IllegalArgumentException(RMResources.InvalidUrl);
        }
        // Authorization code is fine with Uri not having resource id and path.
        // We will just return empty in that case
        String pathAndQuery = StringUtils.EMPTY ;
        if(StringUtils.isNotEmpty(uri.getPath())) {
            pathAndQuery+= uri.getPath();
        }
        if(StringUtils.isNotEmpty(uri.getQuery())) {
            pathAndQuery+="?";
            pathAndQuery+= uri.getQuery();
        }
        if (!PathsHelper.tryParsePathSegments(pathAndQuery, pathInfo, null)) {
            pathInfo.resourcePath = StringUtils.EMPTY;
            pathInfo.resourceIdOrFullName = StringUtils.EMPTY;
        }
    }
}
