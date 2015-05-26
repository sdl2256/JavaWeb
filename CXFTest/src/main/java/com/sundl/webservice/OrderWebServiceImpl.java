package com.sundl.webservice;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import com.sundl.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by SDL on 2015/5/26.
 */
@WebService(endpointInterface = "com.sundl.webservice.OrderWebService")
public class OrderWebServiceImpl implements OrderWebService {

    @Autowired
    private OrderService orderService;

    public List<Order> getOrder() {
        return orderService.getOrder();
    }

    public List<OrderItem> getItem() {
        return orderService.getItem();
    }

    public Order getOrderById(String id) {
        return orderService.getOrderById(id);
    }

    public OrderItem getItemById(Integer id) {
        return orderService.getItemById(id);
    }
}
