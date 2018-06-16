package com.sainsbury.grocery.httpclient;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

public class HttpResponseBody {
    public static String toString(HttpResponse resp) {
        try {
            return EntityUtils.toString(resp.getEntity());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
