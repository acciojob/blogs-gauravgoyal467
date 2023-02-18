package com.driver.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name="user")
public class User {

    @Id //primary key annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;

    private String password;

    private String firstName="test";

    private String lastName="test";


    @OneToMany(mappedBy = "user",cascade =CascadeType.ALL)
    private List<Blog> blogList;

    public User() {
        blogList=new ArrayList<>();
    }
    public User(String username, String password) {
        blogList=new ArrayList<>();
        this.userName=username;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

}