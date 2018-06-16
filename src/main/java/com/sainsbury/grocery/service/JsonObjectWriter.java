package com.sainsbury.grocery.service;

import com.google.gson.Gson;

public class JsonObjectWriter {
    private final static Gson gson = new Gson();

    public static void writeAsJson(Object groceryProducts) {
        String json = gson.toJson(groceryProducts);
        System.out.println(json);
    }
}
