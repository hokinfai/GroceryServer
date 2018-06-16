package com.sainsbury.grocery.httpclient;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

public class HttpResponseStatus {
    public static int getStatusCode(HttpResponse response) {
        return response.getStatusLine().getStatusCode();
    }

    public static void assertOk(HttpResponse response) {
        assertThat(getStatusCode(response), is(HttpStatus.SC_OK));
    }

}
