package com.sainsbury.grocery.service;

import java.io.IOException;

import com.google.gson.Gson;

public class JsonObjectWriter {
    private final static Gson gson = new Gson();

    public static void writeAsJson(Object groceryProducts) throws IOException {
        String json = gson.toJson(groceryProducts);
        FileController.savePageAsResources(json, "result.json");
        System.out.println(json);
    }
}
