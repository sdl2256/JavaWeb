package com.sundl.spring.generic.di;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Sun on 2015/5/10.
 */
public class BaseService<T> {

    @Autowired
    protected BaseRepository<T> repository;

    public void add() {
        System.out.println("add....");
    }
}
