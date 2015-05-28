package com.sundl.spring.annotation.controller;

import com.sundl.spring.annotation.UserService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Sun on 2015/5/10.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping
    public void execute() {
        System.out.println("UserController exe");
        userService.add();
    }
}
