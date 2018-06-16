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

    public static final String URL_HOST = "https://www.sainsburys.co.uk";
    public static final String URL_PATH = "/shop/gb/groceries/fruit-veg/berries-cherries-currants";

    public static void downloadPageHtml() throws IOException {
        HttpUriRequest request = RequestFactory.createGet(URL_HOST + URL_PATH);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
        savePageAsResources(HttpResponseBody.toString(response));
    }

    private static void savePageAsResources(String htmlString) throws IOException {
        Files.write(Paths.get("./src/main/resources/sainsburyGrocery.html"), htmlString.getBytes());
    }
}
