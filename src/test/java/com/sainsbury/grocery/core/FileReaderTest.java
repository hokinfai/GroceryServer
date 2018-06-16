package com.sainsbury.grocery.core;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.Test;

public class FileReaderTest {

    @Test
    public void assertFileIsConvertedToString() throws IOException {
        String htmlFile = FileReader.readFileFrom("sainsburyGrocery.html");
        assertThat(htmlFile, containsString("sainsbury"));
    }

}
