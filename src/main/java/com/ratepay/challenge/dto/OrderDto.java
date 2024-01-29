package com.ratepay.challenge.dto;

import java.util.ArrayList;
import java.util.List;

public class OrderDto {
    private List<ProductDto> products = new ArrayList<>();
    private String buyerId;

    public List<ProductDto> getProducts() {
        return products;
    }

    public void setProducts(List<ProductDto> products) {
        this.products = products;
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }
}