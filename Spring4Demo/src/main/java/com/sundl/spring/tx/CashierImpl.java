package com.sundl.spring.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Sun on 2015/5/10.
 */
@Service("cashier")
public class CashierImpl implements Cashier {

    @Autowired
    private BookShopService bookShopService;


    @Transactional
    public void checkout(String username, List<String> isbns) {

        for (String isbn : isbns) {
            bookShopService.purchase(username, isbn);
        }

    }
}
