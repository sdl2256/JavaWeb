package com.sundl.controller;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import com.sundl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by SDL on 2015/5/25.
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/getorder/{name}")
    public String getOrder(Map map, @PathVariable String name) {
        List<Order> orders = orderService.getOrder();

        map.put("list", orders);

        return "order";
    }

    @RequestMapping("/getitems/{orderid}")
    public String getOrderItem(Map map, @PathVariable String orderid) {
        List<OrderItem> items = orderService.getItemByOrderId(orderid);

        map.put("list", items);

        return "item";
    }


}
