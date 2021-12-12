package com.example.entity;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author: MaoLin
 * @Date: 2019/3/24 14:36
 * @Version 1.0
 */


@Table(schema = "test", indexes = {
        @Index(name = "idx_user_userid", columnList = "userId")
})
@Entity(name = "user")
@Getter
@Setter

//lombok依赖，可省略get set方法
public class User implements Serializable {

    @ToString.Include
    @Column(nullable = false)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @ToString.Include
    private String userName;

    @ToString.Include
    private String userPassword;

    public User(int userId, String userName, String userPassword) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User() {

    }

    @PostRemove
    public void postRemove() {

    }

    @PostLoad
    public void postLoad() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return userId != null && Objects.equals(userId, user.userId);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "userId = " + userId + ", " +
                "userName = " + userName + ", " +
                "userPassword = " + userPassword + ")";
    }
}

