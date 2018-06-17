package com.sainsbury.grocery.core;

import java.util.List;

import org.decimal4j.util.DoubleRounder;

import com.sainsbury.grocery.pojo.Product;

public class GrossCalculator {
    private List<Product> products;

    public GrossCalculator(List<Product> products) {
        this.products = products;
    }

    public double getGross() {
        return products.stream().mapToDouble(product -> product.getUnit_price()).sum();
    }

    public double getVat() {
        return DoubleRounder.round(getGross() * 0.20, 2);
    }
}
