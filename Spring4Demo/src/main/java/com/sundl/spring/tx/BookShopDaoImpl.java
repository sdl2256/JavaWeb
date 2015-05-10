package com.sundl.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by Sun on 2015/5/10.
 */
@Repository("bookShopDao")
public class BookShopDaoImpl implements BookShopDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int findBookPriceByIsbn(String isbn) {
        String sql = "SELECT price FROM book WHERE isbn = ?";

        return jdbcTemplate.queryForObject(sql, Integer.class, isbn);
    }

    public void updateBookStock(String isbn) {
        String sql = "SELECT stock FROM book_stock WHERE isbn = ?";
        int stock = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        if (stock == 0)
            throw new BookStockException("库存不足！");
        sql = "UPDATE book_stock SET stock = stock-1 WHERE isbn = ?";
        jdbcTemplate.update(sql, isbn);

    }

    public void updateUserAccount(String username, int price) {
        String sql = "SELECT balance FROM account WHERE username = ?";
        int balance = jdbcTemplate.queryForObject(sql, Integer.class, username);
        if (balance < price)
            throw new UserAccountException("余额不足！");
        sql = "UPDATE account SET balance = balance - ? WHERE username = ?";
        jdbcTemplate.update(sql, price, username);

    }
}
