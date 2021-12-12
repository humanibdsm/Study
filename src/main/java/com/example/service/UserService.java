package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author : danpeng
 * @Date : 17:37 2021/12/11
 * @Description : TODO
 */
@Service
public class UserService {


    @Autowired
    UserRepository userRepository;


    @Cacheable(value = "user#200s")
    public User getUser(Integer id){

        System.out.println("这在查询数据库.......");
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        return user;

    }

    @Cacheable(value = "userName")
    public String getUserName(Integer id){
        System.out.println("这在查询数据库.......");
        Optional<User> byId = userRepository.findById(id);
        String user = byId.get().getUserName();
        return user;

    }





}
