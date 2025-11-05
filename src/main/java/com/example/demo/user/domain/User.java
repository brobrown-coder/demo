package com.example.demo.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {

    @Id
    private Long id;

    private String passengerId;

    private String survived;

    private String pclass;

    private String name;

    private String sex;

    private String age;

    private String sibSp;

    private String parch;

    private String ticket;

    private String fare;

    private String cabin;

    private String embarked;
}
