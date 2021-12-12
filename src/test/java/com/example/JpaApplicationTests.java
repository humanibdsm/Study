package com.example;

import com.example.JpaApplication;
import com.example.entity.User;
import com.example.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest/*(classes = JpaApplication.class)
@RunWith(SpringRunner.class)*/
public class JpaApplicationTests {

    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {
        User user = userService.getUser(1);
        System.out.println(user);
        String userName = userService.getUserName(1);
        System.out.println(userName);

    }

    @Test
    public void update(){
        String userPassword = userService.getUserPassword(2,"44");
        System.out.println(userPassword);
    }

    @Test
    public void delete(){
        userService.deletePassword(2);


    }

}
