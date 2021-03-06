/*
 * Copyright 2018-2019 Expedia Group, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.expedia.adaptivealerting.anomdetect.util;

import lombok.Generated;
import lombok.val;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

import java.io.IOException;
import java.util.Map;

/**
 * Simple wrapper around Apache's fluent HTTP client, intended to support mockability.
 */
@Generated // https://reflectoring.io/100-percent-test-coverage/
public class HttpClientWrapper {

    /**
     * Makes an HTTP GET call with headers to the given URI and returns the result.
     *
     * @param uri URI
     * @return Call result
     * @throws IOException if there's a problem making the call
     */
    public Content get(String uri, Map<String, String> headers) throws IOException {
        if (headers.isEmpty()) {
            return get(uri);
        }
        val getRequest = Request.Get(uri);
        return buildRequestWithHeaders(getRequest, headers)
                .execute()
                .returnContent();
    }

    /**
     * Makes an HTTP GET call to the given URI and returns the result.
     *
     * @param uri URI
     * @return Call result
     * @throws IOException if there's a problem making the call
     */
    public Content get(String uri) throws IOException {
        return Request.Get(uri)
                .execute()
                .returnContent();
    }

    /**
     * Makes an HTTP POST call to the given URI with given body and returns the result.
     *
     * @param uri  the uri
     * @param body the body
     * @return Call result
     * @throws IOException the io exception
     */
    @Generated // https://reflectoring.io/100-percent-test-coverage/
    public Content post(String uri, String body) throws IOException {
        return Request.Post(uri)
                .bodyString(body, ContentType.APPLICATION_JSON)
                .execute()
                .returnContent();
    }

    private Request buildRequestWithHeaders(Request request, Map<String, String> headers) {
        for (val entry : headers.entrySet()) {
            val key = entry.getKey();
            val value = entry.getValue();
            request.addHeader(key, value);
        }
        return request;
    }
}
