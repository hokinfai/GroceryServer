package com.sainsbury.grocery.service;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.sainsbury.grocery.pojo.Product;

public class FileControllerTest {
    private static final String FILE_NAME = "FileSaverTest.html";

    @BeforeClass
    public static void setup() throws IOException {
        FileController.saveFileAsResources("This is a test file", FILE_NAME);
        FileController.saveFileAsTarget("This is a test file", FILE_NAME);
    }

    @AfterClass
    public static void tearDown() throws IOException {
        FileController.deleteFileFromResources(FILE_NAME);
        FileController.deleteFileFromTarget(FILE_NAME);
    }

    @Test
    public void assertFileIsConvertedToString() throws IOException {
        String htmlFile = FileController.readFileFrom(FILE_NAME);
        assertThat(htmlFile, containsString("This is a test file"));
    }

    @Test
    public void assertFileExists() throws IOException {
        boolean isFileExisted = FileController.isFileExist("./src/main/resources/" + FILE_NAME);
        assertThat(isFileExisted, is(true));
    }

    @Test
    public void assertObjectIsParsedToJson() throws IOException {
        Product product = new Product("testing product", 1, 2.0, "testing product description");
        String productJson = FileController.writeAsJson(product);
        assertThat(productJson,
                is("{\"title\":\"testing product\",\"kcal_per_100g\":1,\"unit_price\":2.0,\"description\":\"testing product description\"}"));
    }
}
