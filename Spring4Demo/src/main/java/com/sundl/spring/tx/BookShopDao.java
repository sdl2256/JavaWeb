package com.sundl.spring.tx;

/**
 * Created by Sun on 2015/5/10.
 */
public interface BookShopDao {

    public int findBookPriceByIsbn(String isbn);

    public void updateBookStock(String isbn);

    public void updateUserAccount(String username, int price);
}
