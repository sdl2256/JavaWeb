package com.sundl.spring.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sun on 2015/5/10.
 */
public class InstanceCarFactory {
    private Map<String, Car> cars = null;

    public InstanceCarFactory() {
        cars = new HashMap<String, Car>();
        cars.put("aodi", new Car("aodi", 30000));
        cars.put("ford", new Car("ford", 40000));
    }

    public Car getCar(String name) {
        return cars.get(name);
    }
}
