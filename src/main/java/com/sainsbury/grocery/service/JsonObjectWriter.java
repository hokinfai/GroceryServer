package com.sainsbury.grocery.service;

import java.util.List;

import com.google.gson.Gson;
import com.sainsbury.grocery.product.Product;

public class JsonObjectWriter {
    private final static Gson gson = new Gson();

    public static void writeAsJson(List<Product> products) {
        String json = gson.toJson(products);
        System.out.println(json);
    }
}
