package com.sainsbury.grocery.product;

public class ProductGross {
    private Double gross;
    private Double vat;

    public ProductGross(Double gross, Double vat) {
        this.gross = gross;
        this.vat = vat;
    }

    public Double getGross() {
        return gross;
    }

    public void setGross(Double gross) {
        this.gross = gross;
    }

    public Double getVat() {
        return vat;
    }

    public void setVat(Double vat) {
        this.vat = vat;
    }
}
