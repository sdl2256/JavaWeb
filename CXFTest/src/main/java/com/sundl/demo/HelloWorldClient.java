package com.sundl.demo;

import com.sundl.entity.User;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * Created by SDL on 2015/5/25.
 */
public class HelloWorldClient {

    public static void main(String[] args) {
        JaxWsProxyFactoryBean svr = new JaxWsProxyFactoryBean();
        svr.setServiceClass(HelloWorld.class);

        svr.setAddress("http://localhost:8080/helloWorld");

        HelloWorld hw = (HelloWorld) svr.create();

        User user = new User();

        user.setId(22222);
        user.setUsername("James");

        System.out.println(hw.sayHiToUser(user));
    }
}
