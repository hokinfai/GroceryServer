package com.sainsbury.grocery.httpclient;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;

public class RequestFactory {
    public static HttpUriRequest createGet(String url) {
        HttpUriRequest request = new HttpGet(url);
        return request;
    }
}
