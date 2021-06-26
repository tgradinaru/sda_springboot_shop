package com.sda.traiangradinaru.webshop.model;

import jdk.net.SocketFlow;

public enum OrderStatus {
    NEW("New"),
    CONFIRMED("Confirmed"),
    DELIVERED("Delivered"),
    PENDING("Pending");

    private final String displayValue;

    private OrderStatus(String displayValue){
        this.displayValue = displayValue;
    }
    public String getDisplayValue(){
        return displayValue;
    }
}
