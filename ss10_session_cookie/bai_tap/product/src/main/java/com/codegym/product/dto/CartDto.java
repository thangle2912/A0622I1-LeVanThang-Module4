package com.codegym.product.dto;

import java.util.HashMap;
import java.util.Map;

public class CartDto {
    private Map<ProductDto, Integer> productMap = new HashMap<>();

    public CartDto() {
    }

    public CartDto(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public Map<ProductDto, Integer> getProductMap() {
        return productMap;
    }

    public void setProductMap(Map<ProductDto, Integer> productMap) {
        this.productMap = productMap;
    }

    public void addProduct(ProductDto productDto) {
        if (productMap.containsKey(productDto)) {
            int currentValue = productMap.get(productDto);
            productMap.replace(productDto, currentValue + 1);
        } else {
            productMap.put(productDto, 1);
        }
    }

    public void removeProductCart(ProductDto productDto) {
        productMap.remove(productDto);
    }

    public void increaseProduct(ProductDto productDto) {
        Integer currentValue = productMap.get(productDto);
        productDto.setPrice(productDto.getPrice() + productDto.getPrice());
        productMap.replace(productDto, currentValue + 1);
    }

    public void decrementProduct(ProductDto productDto) {
        Integer currentValue = productMap.get(productDto);
        if (currentValue == 1) {
            removeProductCart(productDto);
        } else {
            productMap.replace(productDto, currentValue - 1);
        }
    }

    public Float countTotalPayment() {
        float payment = 0;
        for (Map.Entry<ProductDto, Integer> entry : productMap.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
