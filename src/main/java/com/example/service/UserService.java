package com.example.service;

import com.example.entity.User;
import com.example.repository.UserRepository;
import org.hibernate.annotations.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
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


    @Cacheable(value = "user#200s",key = "#id")
    public User getUser(Integer id) {

        System.out.println("这在查询数据库.......");
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        return user;

    }

    @Cacheable(value = "userName",key = "#id")
    public String getUserName(Integer id) {
        System.out.println("这在查询数据库.......");
        Optional<User> byId = userRepository.findById(id);
        String user = byId.get().getUserName();
        return user;
    }


    @CachePut(value = "password",key = "#id")
    public String getUserPassword(Integer id,String password) {
        System.out.println("更新缓存的密码了!");
        Optional<User> byId = userRepository.findById(id);
        User user = byId.get();
        user.setUserPassword(password);
        userRepository.save(user);
        return user.getUserPassword();
    }

    @CacheEvict(value = "password")
    public void deletePassword( Integer id){
        System.out.println("删除中...");
    }


}
