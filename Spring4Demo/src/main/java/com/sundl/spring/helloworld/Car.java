package com.sundl.spring.helloworld;

/**
 * Created by Sun on 2015/5/9.
 */
public class Car {

    private String brand;
    private String corp;
    private double price;
    private int maxSpeed;

    public Car() {
    }

    public Car(String brand, String corp) {
        this.brand = brand;
        this.corp = corp;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCorp() {
        return corp;
    }

    public void setCorp(String corp) {
        this.corp = corp;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", corp='" + corp + '\'' +
                ", price=" + price +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}
