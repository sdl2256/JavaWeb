package com.sundl.spring.tx;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Arrays;

/**
 * Created by Sun on 2015/5/10.
 */
public class TestSpringTx {

    private ApplicationContext applicationContext = null;

    private BookShopDao bookShopDao = null;

    private Cashier cashier = null;

    private BookShopService bookShopService = null;
    DataSource dataSource = null;

    {
        applicationContext = new ClassPathXmlApplicationContext("applicationContext_jdbc_tx.xml");
        dataSource = (DataSource) applicationContext.getBean("dataSource");
        bookShopDao = (BookShopDao) applicationContext.getBean("bookShopDao");
        bookShopService = applicationContext.getBean(BookShopService.class);
        cashier = applicationContext.getBean(Cashier.class);
    }

    @Test
    public void testDataSource() throws Exception {
        System.out.println(dataSource.getConnection());
    }

    @Test
    public void testBookShopDaoFindPriceByIsbn() throws Exception {
        System.out.println(bookShopDao.findBookPriceByIsbn("1001"));
    }

    @Test
    public void testBookShopDaoUpdateUserAccount() throws Exception {
        bookShopDao.updateUserAccount("AA", 100);
    }

    @Test
    public void testBookShopDaoUpdateBookStock() throws Exception {
        bookShopDao.updateBookStock("1001");

    }

    @Test
    public void testPerchase() throws Exception {

        bookShopService.purchase("AA", "1001");
    }

    @Test
    public void testTransactionPropagation() throws Exception {


        cashier.checkout("AA", Arrays.asList("1001", "1002"));
    }
}
