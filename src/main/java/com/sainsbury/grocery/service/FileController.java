package com.sainsbury.grocery.service;

import static com.google.common.base.Charsets.UTF_8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.common.io.Resources;
import com.google.gson.Gson;

public class FileController {
    private final static Gson gson = new Gson();

    public static String readFileFrom(String filePath) throws IOException {
        return Resources.toString(Resources.getResource(filePath), UTF_8);
    }

    public static void savePageAsResources(String content, String fileName) throws IOException {
        Files.write(Paths.get("./src/main/resources/" + fileName), content.getBytes());
        Files.write(Paths.get("./target/classes/" + fileName), content.getBytes());
    }

    public static boolean isFileExist(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public static String writeAsJson(Object groceryProducts) throws IOException {
        return gson.toJson(groceryProducts);
    }
}
