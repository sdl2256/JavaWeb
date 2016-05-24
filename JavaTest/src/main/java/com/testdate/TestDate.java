package com.testdate;

import java.util.Date;

/**
 * Created by SDL on 2016/1/29.
 */
public class TestDate {

    public static void main(String[] args) {
        Date date = new Date(1453281780000L);
        System.out.println(date);
        Date date1 = new Date(1453305600000L);
        System.out.println(date1);
        Date date2 = new Date(1453219200000L);
        System.out.println(date2);

        System.out.println(new java.sql.Date(1453281780000L));
        System.out.println(new java.sql.Date(1453132800000L));
    }
}
