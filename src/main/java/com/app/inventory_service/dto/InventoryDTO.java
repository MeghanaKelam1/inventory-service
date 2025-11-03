package com.app.inventory_service.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class InventoryDTO {
    @NotNull(message = "Product Id must not be null")
    @Min(value = 1001, message = "product id must be greater than 1000")
    @Max(value = 9999, message = "Product ID must be less than 9999")
    private Long productId;
    @NotNull(message = "Product quantity must not be null")
    @Min(value = 0, message = "Quantity must be zero or positive")
    @Max(value = 10000, message = "Quantity must not exceed 10,000 units")
    private Integer quantity;

    public InventoryDTO() {}

    public InventoryDTO(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}