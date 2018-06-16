package com.sainsbury.grocery.data;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sainsbury.grocery.httpclient.HttpResponseBody;
import com.sainsbury.grocery.httpclient.HttpResponseStatus;
import com.sainsbury.grocery.httpclient.RequestFactory;

public class DataRetriever {

    private static final String host = "https://www.sainsburys.co.uk";
    private static final String path = "/shop/gb/groceries/fruit-veg/berries-cherries-currants";

    public void downloadPageHtml() throws IOException {
        HttpUriRequest request = RequestFactory.createGet(host + path);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
        savePageAsResources(HttpResponseBody.toString(response));
    }

    private void savePageAsResources(String htmlString) throws IOException {
        Files.write(Paths.get("./src/main/resources/sainsburyGrocery.html"), htmlString.getBytes());
    }
}
