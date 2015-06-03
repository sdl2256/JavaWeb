package com.sundl.postgres.testng;

import com.sundl.postgres.dao.IUserDao;
import com.sundl.postgres.dao.UserDao;
import com.sundl.postgres.entity.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.List;
import java.util.UUID;

/**
 * Created by SDL on 2015/6/3.
 */
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestNg extends AbstractTestNGSpringContextTests {

    public static Logger logger = Logger.getLogger(TestNg.class);
    @Autowired
    private IUserDao userDao;

    @Test(invocationCount = 1000)
    public void testSave() throws Exception {

        String s = UUID.randomUUID().toString();
        double random = Math.random();
        int v = (int) (random * 100);
        User user = new User(s, s, v);
        userDao.persist(user);
    }

    @Test
    public void testGetUser() throws Exception {
        long totalCount = userDao.getTotalCount(User.class);
        System.out.println(totalCount);

    }

    @Test
    public void testQueryByPage() throws Exception {
        List<User> list = userDao.list(User.class, 100, 5);

        for (User user : list) {
            logger.info(user);
        }

    }
}
