package com.sda.traiangradinaru.webshop.widget;

import com.sda.traiangradinaru.webshop.model.ProductCategory;

public class CategoryWidget {
    private String name;
    private ProductCategory category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }
}
