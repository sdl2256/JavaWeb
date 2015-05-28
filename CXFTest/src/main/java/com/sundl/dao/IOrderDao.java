package com.sundl.dao;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;

import java.util.List;

/**
 * Created by SDL on 2015/5/25.
 */
public interface IOrderDao<T extends Order> extends IBaseDao<T> {

    List<T> getItemByOrderId(String orderId);

}
