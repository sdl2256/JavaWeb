package com.sundl.dao;

import com.sundl.entity.User;
import com.sundl.exception.UserException;

/**
 * Created by SDL on 2015/5/25.
 */
public interface IUserDao<T extends User> extends IBaseDao<T> {

    /** 创建用户，检查帐号是否存在 */
    public T createUser(T user) throws UserException;
    /** 以帐号密码查找用户 */
    public T findUser(String login, String password) throws UserException;

}
