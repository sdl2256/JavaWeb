package com.sundl.spring.dao;

import java.util.List;

/**
 * Created by SDL on 2015/5/19.
 */
public class GenericHibernateDAO<T> implements GenericDAO<T> {



    public T findById(String id) {
        return null;
    }

    public T makePersistent(T entity) {
        return null;
    }

    public void makeTransient(T entity) {

    }

    public void makeTransientByIds(String sql) {

    }

    public List<T> findByPage(String hql, int offset, int pageSize) {
        return null;
    }

    public List<T> findByPage(String hql, Object value, int offset, int pageSize) {
        return null;
    }

    public List<T> findByPage(String hql, Object[] values, int offset, int pageSize) {
        return null;
    }

    public List findByPageSQL(String sql, int offset, int pageSize) {
        return null;
    }

    public Integer getCount(String hql) {
        return null;
    }

    public void updateObj(String hql, Object[] values) {

    }
}
