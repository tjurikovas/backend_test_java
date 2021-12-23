package com.geekbrains.backend.test.miniMarket;

public class ProductResponse {

    private Product product;
    private String error;

    public boolean ok() {
        return product != null;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "ProductResponse{" +
                "product=" + product +
                ", error='" + error + '\'' +
                '}';
    }
}
