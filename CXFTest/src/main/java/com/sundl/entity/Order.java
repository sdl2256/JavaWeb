package com.sundl.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {
    private String orderid;
    private Float amount = 0f;
    private Set<OrderItem> items = new HashSet<OrderItem>();


    @Id
    @Column(length = 36)
    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    @Column(nullable = false)
    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @OneToMany(cascade = {CascadeType.ALL}
            , fetch = FetchType.LAZY, mappedBy = "order")
    public Set<OrderItem> getOrderItem() {
        return items;
    }

    public void setOrderItem(Set<OrderItem> items) {
        this.items = items;
        this.amount = 0f;
        for (OrderItem item : items) {
            amount += item.getSellPrice();
        }
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItem.setOrder(this);
        this.items.add(orderItem);
        amount += orderItem.getSellPrice();
    }

}
