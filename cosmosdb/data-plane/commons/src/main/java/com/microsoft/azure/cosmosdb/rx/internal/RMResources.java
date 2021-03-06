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
package com.microsoft.azure.cosmosdb.rx.internal;

public class RMResources {

    public static final String UnknownResourceType = "Resource type %s is unknown";
    public static final String InvalidDocumentCollection = "The specified document collection is invalid.";
    public static final String StringArgumentNullOrEmpty = "String agument %s is null or empty";
    public static final String PartitionKeyAndParitionKeyRangeIdBothSpecified = "Both Partition Key and Partition Key range are Specified in %s";
    public static final String PartitionKeyRangeIdOrPartitionKeyMustBeSpecified = "One of the partition key range id or partition key must be specified";
    public static final String TooFewPartitionKeyComponents = "PartitionKey has fewer components than defined the collection resource.";
    public static final String TooManyPartitionKeyComponents = "PartitionKey has more components than defined the collection resource.";
    public static final String UnableToDeserializePartitionKeyValue = "Cannot deserialize PartitionKey value '%s";
    public static final String Gone = "The requested resource is no longer available at the server.";
    public static final String ExceptionMessageAddIpAddress = "%s, Local IP: %s";
    public static final String ExceptionMessage = "Message: %s";
    public static final String ServiceUnavailable = "Service is currently unavailable, please retry after a while. If this problem persists please contact support.";
    public static final String InternalServerError = "Unknown server error occurred when processing this request.";
    public static final String InvalidBackendResponse = "The backend response was not in the correct format.";
    public static final String PartitionKeyRangeNotFound = "PartitionKeyRange with id %s in collection %s doesn't exist";
    public static final String InvalidTarget = "Target for the request is invalid";
    public static final String InvalidPartitionKey = "Partition key %s is invalid.";
    public static final String PartitionKeyMismatch = "Partition key provided either doesn't correspond to definition in the collection or doesn't match partition key field values specified in the document.";
    public static final String MissingPartitionKeyValue = "PartitionKey value must be supplied for this operation.";
    public static final String InvalidConflictResolutionMode = "Invalid mode '%s' for setting '%s'. MODE expected is '%s'.";
    public static final String InvalidRegionsInSessionToken = "Compared session tokens '%s' and '%s' has unexpected regions.";
    public static final String InvalidSessionToken = "The session token provided '%s' is invalid.";
    public static final String ResourceTokenNotFound = "Resource token not found.";
    public static final String Unauthorized = "Unable to authenticate the request. The request requires valid user authentication.";
    public static final String Forbidden = "Unable to proceed with the request. Please check the authorization claims to ensure the required permissions to process the request.";
    public static final String NotFound = "Entity with the specified id does not exist in the system.";
    public static final String BadRequest = "One of the input values is invalid.";
    public static final String MethodNotAllowed = "The requested verb is not supported.";
    public static final String EntityAlreadyExists = "Entity with the specified id already exists in the system.";
    public static final String PreconditionFailed = "Operation cannot be performed because one of the specified precondition is not met.";
    public static final String RequestEntityTooLarge = "The size of the response exceeded the maximum allowed size, limit the  response size by specifying smaller value for '%s' header.";
    public static final String Locked = "";
    public static final String RetryWith = "Retry the request.";
    public static final String TooManyRequests = "The request rate is too large. Please retry after sometime.";
    public static final String UnexpectedResourceType = "ResourceType %s is unexpected.";
    public static final String InvalidHeaderValue = "Value '%s' specified for the header '%s' is invalid.";
    public static final String RequestTimeout = "Request timed out.";
    public static final String GlobalStrongWriteBarrierNotMet = "Global Strong write barrier has not been met for the request.";
    public static final String InvalidRequestHeaderValue = "Invalid value for request header %s: %s";
    public static final String InvalidResourceAddress = "Invalid address for resource %s: %s";
    public static final String ReadQuorumNotMet = "Read Quorum size of %d is not met for the request.";
    public static final String ReadSessionNotAvailable = "The read session is not available for the input session token.";
    public static final String InvalidUrl = "InvalidUrl";
    public static final String InvalidResourceUrlQuery = "The value %s specified  for query %s is invalid.";
    public static final String PartitionKeyRangeIdAbsentInContext = "PartitionKeyRangeId is absent in the context.";
}
