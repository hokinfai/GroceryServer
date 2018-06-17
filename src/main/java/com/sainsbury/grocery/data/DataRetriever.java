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

    public static void downloadPageHtml(boolean isPageUpdated, String fileName) throws IOException {
        if (!FileController.isFileExist("./target/classess/sainsburyGrocery.html") || isPageUpdated) {
            downloadPageHtml(URL_HOST + URL_PATH, fileName);
        }
    }

    public static void downloadPageHtml(String path, String fileName) throws IOException {
        HttpUriRequest request = RequestFactory.createGet(path);
        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(request);
        HttpResponseStatus.assertOk(response);
        FileController.savePageAsResources(HttpResponseBody.toString(response), fileName);
    }

}
