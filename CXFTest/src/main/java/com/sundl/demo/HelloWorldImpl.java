package com.sundl.demo;

import com.sundl.entity.User;

import javax.jws.WebService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SDL on 2015/5/25.
 */
@WebService(endpointInterface = "com.sundl.demo.HelloWorld", serviceName = "helloWorld")
public class HelloWorldImpl implements HelloWorld {

    Map<Integer, User> users = new LinkedHashMap<Integer, User>();

    public String sayHi(String text) {
        return "Hello " + text;
    }

    public String sayHiToUser(User user) {
        users.put(users.size() + 1, user);
        return "Hello " + user.getUsername();
    }

    public String[] sayHiToUserList(List<User> users) {
        String[] result = new String[users.size()];
        int i = 0;
        for (User u : users) {
            result[i] = u.getUsername();
            i++;
        }
        return result;
    }
}
