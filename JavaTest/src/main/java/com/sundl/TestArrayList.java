package com.sundl;

import java.util.ArrayList;

/**
 * Created by SDL on 2015/7/28.
 */
public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(0,"item--3");
        arrayList.add(0,"item--2");
        arrayList.add(0,"item--1");
        arrayList.add(0,"item--0");

        System.out.println(arrayList);
    }
}
