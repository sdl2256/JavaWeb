package com.sundl.factory;

import com.sundl.helloworld.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sun on 2015/5/10.
 */
public class StaticCarFactory {

    private static Map<String, Car> cars = new HashMap<String, Car>();

    static {
        cars.put("aodi", new Car("aodi", 30000));
        cars.put("ford", new Car("ford", 40000));
    }

    public static Car getCar(String name) {
        return cars.get(name);

    }
}
