package com.sainsbury.grocery.pojo;

import java.util.List;

public class GroceryProducts {
    private List<Product> results;
    private ProductGross total;

    public GroceryProducts(List<Product> result, ProductGross total) {
        this.results = result;
        this.total = total;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public ProductGross getTotal() {
        return total;
    }

    public void setTotal(ProductGross total) {
        this.total = total;
    }
}
