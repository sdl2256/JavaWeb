package com.sundl.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Sun on 2015/5/10.
 */
@Service("bookShopService")
public class BookShopServiceImpl implements BookShopService {

    @Autowired
    private BookShopDao bookShopDao;

    @Transactional(propagation = Propagation.REQUIRED,
            isolation = Isolation.READ_COMMITTED, readOnly = false, timeout = 3)
    public void purchase(String username, String isbn) {
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
        }

        //1. 获取书的单价
        int bookPriceByIsbn = bookShopDao.findBookPriceByIsbn(isbn);

        //2.更新书的库存
        bookShopDao.updateBookStock(isbn);

        //3.更新用户余额
        bookShopDao.updateUserAccount(username, bookPriceByIsbn);
    }
}
