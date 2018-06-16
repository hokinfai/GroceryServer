package com.sainsbury.grocery.data;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.sainsbury.grocery.httpclient.HttpResponseBody;
import com.sainsbury.grocery.httpclient.HttpResponseStatus;
import com.sainsbury.grocery.httpclient.RequestFactory;
import com.sainsbury.grocery.service.FileController;

public class DataRetriever {

    public static final String URL_HOST = "https://jsainsburyplc.github.io";
    public static final String URL_PATH = "/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/berries-cherries-currants6039.html";
    public static void downloadPageHtml() throws IOException {
        HttpUriRequest request = RequestFactory.createGet(URL_HOST + URL_PATH);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
        FileController.savePageAsResources(HttpResponseBody.toString(response), "sainsburyGrocery.html");
    }

}
