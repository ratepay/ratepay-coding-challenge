package com.ratepay.challenge.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "buyer")
public class Buyer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders;

    public Buyer() { }

    public Buyer(String name, List<Order> orders) {
        this.name = name;
        this.setOrders(orders);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}