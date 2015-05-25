package com.sundl.demo;

import javax.xml.ws.Endpoint;

/**
 * Created by SDL on 2015/5/25.
 */
public class WebServiceApp {
    public static void main(String[] args) {
        System.out.println("web service start.");
        HelloWorldImpl imp = new HelloWorldImpl();
        String address = "http://localhost:8080/helloWorld";
        Endpoint.publish(address, imp);
        System.out.println("web service started.");
    }
}
