package com.pupspc.onlinefooddelivery.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String customerName;
    private String address;
    private String phone;
    private double totalPrice;
    private String status;
    private String deliveryPersonnel;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "orderItem")
    @JsonIgnoreProperties("orderItem")
    private List<OrderCartItem> orderCartItems;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDeliveryPersonnel() {
        return deliveryPersonnel;
    }

    public void setDeliveryPersonnel(String deliveryPersonnel) {
        this.deliveryPersonnel = deliveryPersonnel;
    }

    public List<OrderCartItem> getOrderCartItems() {
        return orderCartItems;
    }

    public void setOrderCartItems(List<OrderCartItem> orderCartItems) {
        this.orderCartItems = orderCartItems;
    }
}