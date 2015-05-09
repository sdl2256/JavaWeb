package com.sundl.cycle;

/**
 * Created by Sun on 2015/5/10.
 */
public class Cat {
    private String name;

    public Cat() {
        System.out.println("cat construct...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("cat setName...");
        this.name = name;
    }

    public void init() {
        System.out.println("cat init...");

    }

    public void destroy(){
        System.out.println("cat destroy...");

    }

}
