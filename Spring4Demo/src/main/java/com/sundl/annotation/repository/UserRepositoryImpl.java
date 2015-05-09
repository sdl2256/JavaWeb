package com.sundl.annotation.repository;

import org.springframework.stereotype.Repository;

/**
 * Created by Sun on 2015/5/10.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    public void add() {
        System.out.println("UserRepositoryImpl");
    }
}
