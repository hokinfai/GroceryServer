package com.sainsbury.grocery.product;

import java.util.List;

public class GroceryProducts {
    private List<Product> results;
    private AdditionalFields total;

    public GroceryProducts(List<Product> result, AdditionalFields total) {
        this.results = result;
        this.total = total;
    }

    public List<Product> getResults() {
        return results;
    }

    public void setResults(List<Product> results) {
        this.results = results;
    }

    public AdditionalFields getTotal() {
        return total;
    }

    public void setTotal(AdditionalFields total) {
        this.total = total;
    }
}
