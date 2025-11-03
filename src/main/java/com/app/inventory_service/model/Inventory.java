package com.app.inventory_service.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="inventory2")
public class Inventory {

//    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Long productId;


    private Integer quantity;

    @OneToOne
    @JoinColumn(name = "availability_id", referencedColumnName = "availability_id")
    private Availability availability;

    public Inventory() {
    }

    public Inventory(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}

