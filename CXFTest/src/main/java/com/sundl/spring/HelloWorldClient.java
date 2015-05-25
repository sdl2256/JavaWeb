package com.sundl.spring;

import com.sundl.demo.HelloWorld;
import com.sundl.entity.User;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by SDL on 2015/5/25.
 */
public class HelloWorldClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        HelloWorld client = (HelloWorld)context.getBean("client");
        User user1 = new User();
        user1.setId(123);
        user1.setUsername("test");
        User user2 = new User();
        user2.setId(3333);
        user2.setUsername("test1");
        List<User> userList= new ArrayList<User>();
        userList.add(user1);
        userList.add(user2);
        String[] res = client.sayHiToUserList(userList);
        System.out.println(res[0]);
        System.out.println(res[1]);

    }
}
