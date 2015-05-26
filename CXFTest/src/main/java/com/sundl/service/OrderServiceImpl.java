package com.sundl.service;

import com.sundl.dao.IOrderDao;
import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by SDL on 2015/5/26.
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    private IOrderDao orderDao;

    public List<Order> getOrder() {
        return orderDao.listAll(Order.class);
    }

    public List<OrderItem> getItem() {
        return orderDao.listAll(OrderItem.class);
    }

    public Order getOrderById(String id) {
        return (Order) orderDao.find(Order.class, id);
    }

    public OrderItem getItemById(Integer id) {
        return (OrderItem) orderDao.find(OrderItem.class, id);
    }
}
