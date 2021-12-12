package com.example.repository;

import com.example.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : danpeng
 * @Date : 17:45 2021/12/11
 * @Description : TODO
 */

@Repository
public interface UserRepository  extends JpaRepository<User,Integer> {
}
