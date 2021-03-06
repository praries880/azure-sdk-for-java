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

package com.azure.data.cosmos;

import com.azure.data.cosmos.internal.Conflict;
import com.azure.data.cosmos.internal.StoredProcedure;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.WordUtils;

public enum ConflictResolutionMode {
    /**
     * Last writer wins conflict resolution mode
     *
     * Setting the ConflictResolutionMode to "LAST_WRITER_WINS" indicates that conflict resolution should be done by inspecting a field in the conflicting documents
     * and picking the document which has the higher value in that path. See {@link ConflictResolutionPolicy#conflictResolutionPath()} for details on how to specify the path
     * to be checked for conflict resolution. Also note that Deletes win.
     */
    LAST_WRITER_WINS,

    /**
     * CUSTOM conflict resolution mode
     *
     * Setting the ConflictResolutionMode to "CUSTOM" indicates that conflict resolution is custom handled by a user.
     * The user could elect to register a user specified {@link StoredProcedure} for handling conflicting resources.
     * Should the user not register a user specified StoredProcedure, conflicts will default to being made available as {@link Conflict} resources,
     * which the user can inspect and manually resolve.
     * See {@link ConflictResolutionPolicy#conflictResolutionProcedure()} for details on how to specify the stored procedure
     * to run for conflict resolution.
     */
    CUSTOM,

    /**
     * INVALID or unknown mode.
     */
    INVALID;
    
    @Override
    public String toString() {
        return StringUtils.remove(WordUtils.capitalizeFully(this.name(), '_'), '_');     
    }
}

