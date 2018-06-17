package com.sainsbury.grocery.data;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

public class DataRetrieverTest {

    @Test
    public void test() throws ClientProtocolException, IOException {
        DataRetriever.downloadPageHtml(false, "sainsburyGrocery.html");
    }

}
