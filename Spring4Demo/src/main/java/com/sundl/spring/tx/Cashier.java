package com.sundl.spring.tx;

import java.util.List;

/**
 * Created by Sun on 2015/5/10.
 */
public interface Cashier {
    public void checkout(String username, List<String> isbns);
}
