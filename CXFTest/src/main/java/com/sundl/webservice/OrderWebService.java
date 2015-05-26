package com.sundl.webservice;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by SDL on 2015/5/26.
 */
@WebService
public interface OrderWebService {

    List<Order> getOrder();

    List<OrderItem> getItem();

    Order getOrderById(String id);

    OrderItem getItemById(Integer id);
}
