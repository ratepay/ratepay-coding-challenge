package com.ratepay.challenge.bo;

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
    private List<Orders> orders;

    public Buyer() { }

    public Buyer(String name, List<Orders> orders) {
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

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}