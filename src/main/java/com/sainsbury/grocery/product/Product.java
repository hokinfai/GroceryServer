package com.sainsbury.grocery.product;

public class Product {
    private String title;
    private String kcal_per_100g;
    private Double unit_price;
    private String description;

    public Product(String title, String kcal, Double unit_price, String description) {
        this.title = title;
        this.kcal_per_100g = kcal;
        this.unit_price = unit_price;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getKcal_per_100g() {
        return kcal_per_100g;
    }

    public void setKcal_per_100g(String kcal_per_100g) {
        this.kcal_per_100g = kcal_per_100g;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
