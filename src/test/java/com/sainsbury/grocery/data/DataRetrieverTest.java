package com.sainsbury.grocery.data;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.Test;

import com.sainsbury.grocery.service.FileController;

public class DataRetrieverTest {

    @Test
    public void test() throws ClientProtocolException, IOException {
        String fileName = "sainsburyGrocery.html";
        DataRetriever.downloadPageHtml(false, fileName);
        assertThat(FileController.isFileExist("./src/main/resources/" + fileName), is(true));
    }

}
