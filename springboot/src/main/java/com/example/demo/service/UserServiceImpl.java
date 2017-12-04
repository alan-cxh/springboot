package com.example.demo.service;

import com.example.demo.dao.UserRepository;
import com.example.demo.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;

/**
 * Created by Alan on 2017/11/29.
 */
@Service
public class UserServiceImpl {
    public static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    @Resource
    private UserRepository userRepository;

    @Transactional
    public void add(User user) {
        userRepository.save(user);
    }


    public User get(Long id) {
        return userRepository.getOne(id);
    }

    public User getByName(String s) {
        return userRepository.getByUsername1(s);
    }
}
