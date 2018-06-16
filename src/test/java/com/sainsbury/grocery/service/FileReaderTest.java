package com.sainsbury.grocery.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

import com.sainsbury.grocery.service.FileController;

public class FileReaderTest {

    @Test
    public void assertFileIsConvertedToString() throws IOException {
        String htmlFile = FileController.readFileFrom("sainsburyGrocery.html");
        assertThat(htmlFile, containsString("sainsbury"));
    }

}
