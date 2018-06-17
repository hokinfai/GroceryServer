package com.sainsbury.grocery.service;

import java.io.IOException;

import com.google.gson.Gson;

public class JsonObjectWriter {
    private final static Gson gson = new Gson();

    public static String writeAsJson(Object groceryProducts) throws IOException {
        return gson.toJson(groceryProducts);
    }
}
