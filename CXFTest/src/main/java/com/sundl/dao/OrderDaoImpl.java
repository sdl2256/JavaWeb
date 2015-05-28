package com.sundl.dao;

import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by SDL on 2015/5/25.
 */
@Repository("orderDao")
public class OrderDaoImpl<T extends Order> extends BaseDaoImpl<T> implements IOrderDao<T> {

    public List<T> getItemByOrderId(String orderId) {
        List resultList = this.createQuery("from OrderItem oitem where oitem.order.id = ?1 ").setParameter(1, orderId).getResultList();

        return resultList;
    }
}
