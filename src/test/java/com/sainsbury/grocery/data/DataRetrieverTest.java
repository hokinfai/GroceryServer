package com.sainsbury.grocery.data;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.junit.AfterClass;
import org.junit.Test;

import com.sainsbury.grocery.service.FileController;

public class DataRetrieverTest {
    private static final String FILE_NAME = "sainsburyGroceryTest.html";

    @Test
    public void assertFileIsDownloaded() throws ClientProtocolException, IOException {
        DataRetriever.downloadPageHtml(false, FILE_NAME);
        assertThat(FileController.isFileExist("./src/main/resources/" + FILE_NAME), is(true));
        assertThat(FileController.isFileExist("./target/classes/" + FILE_NAME), is(true));
    }

    @AfterClass
    public static void tearDown() throws IOException {
        FileController.deleteFileFromResources(FILE_NAME);
        FileController.deleteFileFromTarget(FILE_NAME);
    }

}
