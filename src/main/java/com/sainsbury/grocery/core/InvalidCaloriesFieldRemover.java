package com.sainsbury.grocery.core;

public class InvalidCaloriesFieldRemover {
    public static String removeInvalidCaloriesField(String jsonString) {
        return jsonString.replaceAll("\"kcal_per_100g\":-1,", "");
    }
}
