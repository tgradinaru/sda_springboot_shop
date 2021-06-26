package com.sda.traiangradinaru.webshop.service.dto;

import java.util.List;

//Order Data Transfer Object
public class OrderDTO {
    private Long customerId;
    private List<Long> productIds;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductIds() {
        return productIds;
    }

    public void setProductIds(List<Long> productIds) {
        this.productIds = productIds;
    }
}
