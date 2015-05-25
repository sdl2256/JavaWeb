package com.sundl.dao;

import com.sundl.entity.Order;
import org.springframework.stereotype.Repository;

/**
 * Created by SDL on 2015/5/25.
 */
@Repository("orderDao")
public class OrderDaoImpl<T extends Order> extends BaseDaoImpl<T> implements IOrderDao<T> {
}
