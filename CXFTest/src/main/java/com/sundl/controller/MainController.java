package com.sundl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SDL on 2015/5/25.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping("/getorder")
    public String getOrder(){
        return "order";
    }
}
