package com.sundl.demo;

import com.sundl.dao.IOrderDao;
import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by SDL on 2015/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestEntity {

    @Autowired
    private IOrderDao orderDao;

    @Test
    @Transactional
    public void testSave() throws Exception {
        Order order = new Order();
        order.setAmount(34f);
        //全球码为36位
        String uuid = UUID.randomUUID().toString();
        order.setOrderid(uuid);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProductName("足球");
        orderItem1.setSellPrice(90f);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProductName("篮球");
        orderItem2.setSellPrice(120f);
        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);

        orderDao.persist(order);


    }
}
