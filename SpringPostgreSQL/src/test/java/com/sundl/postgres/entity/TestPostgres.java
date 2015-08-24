package com.sundl.postgres.entity;

import com.sundl.postgres.dao.IUserDao;
import com.sundl.postgres.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.util.Map;
import java.util.UUID;
import com.sun.xml.internal.ws.spi.ProviderImpl;
/**
 * Created by SDL on 2015/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestPostgres {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private IUserDao userDao;

    @Test
    public void testConnection() throws Exception {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testSave() throws Exception {

        String s = UUID.randomUUID().toString();
        double random = Math.random();
        int v = (int) (random * 100);
        User user = new User(s, s, v);
        userDao.persist(user);

    }
}
