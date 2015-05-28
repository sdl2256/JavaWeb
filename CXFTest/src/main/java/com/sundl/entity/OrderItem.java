package com.sundl.entity;

import com.sundl.vo.VOrder;
import com.sundl.vo.VOrderItem;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class OrderItem {
    private Integer id;
    private String productName;
    private Float sellPrice = 0f;
    private Order order;

    @Id
    @GeneratedValue
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(length = 40, nullable = false)
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Column(nullable = false)
    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.REFRESH}
            , fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "order_id")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        this.order = (Order) parent;
    }

}
