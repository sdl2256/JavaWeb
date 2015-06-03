package com.sundl.postgres.dao;

import com.sundl.postgres.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by SDL on 2015/6/3.
 */
@Repository("userDao")
public class UserDao<T extends User> extends BaseDaoImpl<T> implements IUserDao<T> {

    public static Logger logger = Logger.getLogger(UserDao.class);

}
