package com.sainsbury.grocery.contract;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;

import com.sainsbury.grocery.httpclient.HttpResponseStatus;
import com.sainsbury.grocery.httpclient.RequestFactory;

public class SainsburyGrocerySiteContractTest {
    private static final String groceryUrl = "https://www.sainsburys.co.uk/shop/gb/groceries/fruit-veg/berries-cherries-currants";

    @Test
    public void assertPageOK() throws ClientProtocolException, IOException {
        HttpUriRequest request = RequestFactory.createGet(groceryUrl);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
    }

}
