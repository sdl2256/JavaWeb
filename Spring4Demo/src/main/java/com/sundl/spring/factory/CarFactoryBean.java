package com.sundl.spring.factory;

import org.springframework.beans.factory.FactoryBean;

/**
 * Created by Sun on 2015/5/10.
 */
public class CarFactoryBean implements FactoryBean<Car> {

    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Car getObject() throws Exception {
        return new Car("BMW",500000);
    }

    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
