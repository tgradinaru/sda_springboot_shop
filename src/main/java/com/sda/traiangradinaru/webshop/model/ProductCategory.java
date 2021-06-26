package com.sda.traiangradinaru.webshop.model;

public enum ProductCategory {
    GROCERY("Grocery"),
    PET_FOOD("Pet food"),
    ELECTRONICS("Electronics"),
    BEVERAGES("Beverages");

    private final String displayValue;

    ProductCategory(String displayValue) {
        this.displayValue = displayValue;
    }

    public String getDisplayValue() {
        return displayValue;
    }

}
