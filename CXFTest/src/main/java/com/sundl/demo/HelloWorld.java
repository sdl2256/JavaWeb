package com.sundl.demo;


import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;

import com.sundl.entity.*;
/**
 * Created by SDL on 2015/5/25.
 */
@WebService
public interface HelloWorld {
    String sayHi(@WebParam(name = "text") String text);

    String sayHiToUser(User user);

    String[] sayHiToUserList(List<User> users);
}
