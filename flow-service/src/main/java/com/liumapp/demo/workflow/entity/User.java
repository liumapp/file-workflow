package com.liumapp.demo.workflow.entity;

import org.springframework.stereotype.Component;

/**
 * @author liumapp
 * @file User.java
 * @email liumapp.com@gmail.com
 * @homepage http://www.liumapp.com
 * @date 6/6/18
 */
@Component
public class User {

    private String name;

    private Integer age;

    private String headPic;

    public User() {
    }

    public User(String name, Integer age, String headPic) {
        this.name = name;
        this.age = age;
        this.headPic = headPic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }
}
