package com.sundl.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by Sun on 2015/5/10.
 */
@Repository
public class UserRepositoryJDBCImpl implements UserRepository {
    public void add() {

        System.out.println("UserRepositoryJDBCImpl");
    }
}
