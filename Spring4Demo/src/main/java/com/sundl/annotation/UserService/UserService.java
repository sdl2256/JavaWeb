package com.sundl.annotation.UserService;

import com.sundl.annotation.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * Created by Sun on 2015/5/10.
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired(required = false)
//    @Qualifier("userRepositoryJDBCImpl")
    public void setUserRepository(@Qualifier("userRepositoryJDBCImpl")UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void add() {
        System.out.println("UserService add");
        userRepository.add();
    }
}
