package com.sundl;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by SDL on 2015/8/28.
 */
public class TestMapType {

    public static void main(String[] args) {

        double var = 0.10000002;

        String format = String.format("%1$E", new Object[]{Double.valueOf(var)});

        System.out.println(format);

        System.out.printf("50元的书打8.5折扣是：%f 元%n", 50*0.85);
    }
}
