package com.sundl.dao;

import com.sundl.entity.User;
import com.sundl.exception.UserException;

import java.util.List;

/**
 * Created by SDL on 2015/5/25.
 */
public class UserDaoImpl<T extends User> extends BaseDaoImpl<T> implements IUserDao<T> {
    public T createUser(T user) throws UserException {
        List userList = this.createQuery(" SELECT u FROM User u WHERE u.login = :login ").setParameter("login", user.getUsername().toLowerCase().trim()).getResultList();
        if (userList.size() > 0) {
            throw new UserException("用户名已经存在：" + user.getUsername());
        }
        return persist(user);
    }

    public T findUser(String login, String password) throws UserException {
        List list = this.createQuery(" SELECT u FROM User u WHERE u.login = :login and u.password=:password ").setParameter("login", login.toLowerCase().trim()).setParameter("password", password).getResultList();
        if (list.size() > 0) {
            return (T) list.get(0);
        }
        return null;
    }
}
