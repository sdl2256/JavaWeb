package com.sundl.service;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SDL on 2015/5/26.
 */
public interface OrderService {

    List<Order> getOrder();

    List<OrderItem> getItem();

    Order getOrderById(String id);

    OrderItem getItemById(Integer id);


}
