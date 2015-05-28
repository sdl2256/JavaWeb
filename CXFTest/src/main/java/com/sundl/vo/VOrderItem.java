package com.sundl.vo;

import javax.xml.bind.Unmarshaller;

public class VOrderItem {
    private Integer id;
    private String productName;
    private Float sellPrice = 0f;
    private VOrder order;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Float getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Float sellPrice) {
        this.sellPrice = sellPrice;
    }

    public VOrder getOrder() {
        return order;
    }

    public void setOrder(VOrder order) {
        this.order = order;
    }

    public void afterUnmarshal(Unmarshaller u, Object parent) {
        this.order = (VOrder) parent;
    }
}
