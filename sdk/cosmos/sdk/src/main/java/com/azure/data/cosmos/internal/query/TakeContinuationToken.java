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

package com.azure.data.cosmos.internal.query;

import com.azure.data.cosmos.BridgeInternal;
import com.azure.data.cosmos.JsonSerializable;
import com.azure.data.cosmos.internal.Utils.ValueHolder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * While this class is public, but it is not part of our published public APIs.
 * This is meant to be internally used only by our sdk.
 */
public final class TakeContinuationToken extends JsonSerializable {
    private static final String LimitPropertyName = "limit";
    private static final String SourceTokenPropetryName = "sourceToken";
    private static final Logger logger = LoggerFactory.getLogger(TakeContinuationToken.class);

    public TakeContinuationToken(int takeCount, String sourceToken) {
        if (takeCount < 0) {
            throw new IllegalArgumentException("takeCount must be a non negative number.");
        }

        // sourceToken is allowed to be null.
        this.setTakeCount(takeCount);
        this.setSourceToken(sourceToken);
    }

    private TakeContinuationToken(String serializedTakeContinuationToken) {
        super(serializedTakeContinuationToken);
    }

    public static boolean tryParse(String serializedTakeContinuationToken,
            ValueHolder<TakeContinuationToken> outTakeContinuationToken) {
        boolean parsed;
        try {
            TakeContinuationToken takeContinuationToken = new TakeContinuationToken(serializedTakeContinuationToken);
            takeContinuationToken.getSourceToken();
            takeContinuationToken.getTakeCount();
            outTakeContinuationToken.v = takeContinuationToken;
            parsed = true;
        } catch (Exception ex) {
            logger.debug(
                    "Received exception {} when trying to parse: {}", 
                    ex.getMessage(), 
                    serializedTakeContinuationToken);
            parsed = false;
            outTakeContinuationToken.v = null;
        }

        return parsed;
    }

    public int getTakeCount() {
        return super.getInt(LimitPropertyName);
    }

    public String getSourceToken() {
        return super.getString(SourceTokenPropetryName);
    }

    private void setTakeCount(int takeCount) {
        BridgeInternal.setProperty(this, LimitPropertyName, takeCount);
    }

    private void setSourceToken(String sourceToken) {
        BridgeInternal.setProperty(this, SourceTokenPropetryName, sourceToken);
    }
}
