package com.sainsbury.grocery.service;

import static com.google.common.base.Charsets.UTF_8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.common.io.Resources;

public class FileController {

    public static String readFileFrom(String filePath) throws IOException {
        return Resources.toString(Resources.getResource(filePath), UTF_8);
    }

    public static void savePageAsResources(String content, String fileName) throws IOException {
        Files.write(Paths.get("./src/main/resources/" + fileName), content.getBytes());
    }
}
