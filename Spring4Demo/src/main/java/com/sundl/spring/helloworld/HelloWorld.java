package com.sundl.spring.helloworld;

/**
 * Created by Sun on 2015/5/9.
 */
public class HelloWorld {
    private String name;

    public HelloWorld() {
        System.out.println("construct...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        System.out.println("set name= " + name);
    }

    public void hello() {
        System.out.println("Hello " + name);
    }
}
