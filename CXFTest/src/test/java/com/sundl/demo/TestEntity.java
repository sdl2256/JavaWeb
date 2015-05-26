package com.sundl.demo;

import com.sundl.dao.IOrderDao;
import com.sundl.entity.Order;
import com.sundl.entity.OrderItem;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import javax.transaction.Transactional;
import java.util.UUID;

/**
 * Created by SDL on 2015/5/25.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestEntity {

    private static final Logger logger = Logger.getLogger(TestEntity.class);
    @Autowired
    private IOrderDao orderDao;

    @Autowired
    private DataSource dataSource;


    @Test
    public void testConnection() throws Exception {
        Assert.assertNotNull(dataSource.getConnection());
        System.out.println(dataSource.getConnection());

    }

    @Test
    public void testSave() throws Exception {
        Order order = new Order();
        //全球码为36位
        String uuid = UUID.randomUUID().toString();
        order.setOrderid(uuid);

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setProductName("足球");
        orderItem1.setSellPrice(90f);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProductName("篮球");
        orderItem2.setSellPrice(120f);
        OrderItem orderItem3 = new OrderItem();
        orderItem3.setProductName("拍球");
        orderItem3.setSellPrice(150f);

        order.addOrderItem(orderItem1);
        order.addOrderItem(orderItem2);
        order.addOrderItem(orderItem3);

        orderDao.persist(order);


    }
}
