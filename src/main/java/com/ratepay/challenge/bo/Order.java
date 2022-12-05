package com.ratepay.challenge.bo;


import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

import static java.time.OffsetDateTime.now;

@Entity(name = "orders")
@TypeDef(name = "json", typeClass = JsonType.class)
@Data
@NoArgsConstructor
public class Order {

    public Order(List<Product> products, BigDecimal totalAmount) {
        this.products = products;
        this.totalAmount = totalAmount;
        this.created = now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private OffsetDateTime created;

    @Type(type = "json")
    @Column(columnDefinition = "json")
    private List<Product> products = new ArrayList<>();

    private BigDecimal totalAmount;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    private Buyer buyer;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        return id != null && id.equals(((Order) o).getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
