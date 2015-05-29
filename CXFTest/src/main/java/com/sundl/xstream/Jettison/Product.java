package com.sundl.xstream.Jettison;

/**
 * Created by SDL on 2015/5/29.
 */
public class Product {
    String id;
    String name;
    double price;

    public Product(String name, String id, double price) {
        this.name = name;
        this.id = id;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
