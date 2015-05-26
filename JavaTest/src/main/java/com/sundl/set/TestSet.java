package com.sundl.set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by SDL on 2015/5/26.
 */
public class TestSet {

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("Java");
        set.add("C++");
        set.add("C#");
        set.add("Ruby");
        set.add("android");
        set.add("ios");

        for (String str : set) {
            System.out.println(str);
        }
    }
}
