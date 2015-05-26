package com.sundl.dao;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by SDL on 2015/5/25.
 */
public interface IBaseDao<T> {
    public T find(Class<? extends T> clazz, int id);

    public T find(Class<? extends T> clazz, String id);

    public T persist(T t);

    public T merge(T t);

    public T remove(T t);

    public T remove(Class<? extends T> clazz, int id);

    public List<T> listAll(Class<? extends T> clazz);

    public List<T> list(String jpql);

    public int getTotalCount(Class<? extends T> clazz);

    public List<T> list(Class<? extends T> clazz, int firstResult, int maxResult);

    public int getTotalCount(String jpql);

    public List<T> list(String jpql, int firstResult, int maxResult);

    public Query createQuery(String jpql);


}
