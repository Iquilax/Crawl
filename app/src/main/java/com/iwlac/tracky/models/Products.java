package com.iwlac.tracky.models;

import java.util.HashMap;
import java.util.List;

/**
 * Created by buupv on 3/25/17.
 */

public class Products {
    HashMap<String,TrackedProduct> products = new HashMap<String,TrackedProduct>();

    public Products() {

    }

    public Products(HashMap<String, TrackedProduct> products) {
        this.products = products;
    }

    public HashMap<String, TrackedProduct> getProducts() {
        return products;
    }

    public void setProducts(HashMap<String, TrackedProduct> products) {
        this.products = products;
    }
}
