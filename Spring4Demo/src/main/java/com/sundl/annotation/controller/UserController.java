package com.sundl.annotation.controller;

import com.sundl.annotation.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by Sun on 2015/5/10.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public void execute() {
        System.out.println("UserController exe");
        userService.add();
    }
}
