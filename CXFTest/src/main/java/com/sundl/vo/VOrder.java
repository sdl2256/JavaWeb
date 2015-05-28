package com.sundl.vo;

import java.util.HashSet;
import java.util.Set;

public class VOrder {
    private String orderid;
    private Float amount = 0f;
    private Set<VOrderItem> items = new HashSet<VOrderItem>();


    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Set<VOrderItem> getOrderItem() {
        return items;
    }

    public void setOrderItem(Set<VOrderItem> items) {
        this.items = items;
        this.amount = 0f;
        for (VOrderItem item : items) {
            amount += item.getSellPrice();
        }
    }

    public void addOrderItem(VOrderItem orderItem) {
        orderItem.setOrder(this);
        this.items.add(orderItem);
        amount += orderItem.getSellPrice();
    }

}
