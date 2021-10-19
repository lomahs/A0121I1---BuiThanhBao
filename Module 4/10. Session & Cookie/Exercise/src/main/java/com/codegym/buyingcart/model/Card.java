package com.codegym.buyingcart.model;

import org.springframework.stereotype.Component;

import java.util.HashMap;


@Component
public class Card {

    private HashMap<Product, Integer> products = new HashMap<>();

    public Card() {
    }

    public Card(HashMap<Product, Integer> products) {
        this.products = products;
    }

    public HashMap<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Product, Integer> products) {
        this.products = products;
    }


}