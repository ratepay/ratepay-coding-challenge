package com.ratepay.challenge.bo;


import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "buyer")
@Data
@NoArgsConstructor
public class Buyer {

    public Buyer(String name, List<Order> orders) {
        this.name = name;
        orders.forEach(this::addOrder);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> orders = new ArrayList<>();

    public void addOrder(Order order) {
        orders.add(order);
        order.setBuyer(this);
    }

    public void removeOrder(Order order) {
        orders.remove(order);
        order.setBuyer(null);
    }
}
