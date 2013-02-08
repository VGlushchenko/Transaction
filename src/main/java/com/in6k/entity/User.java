package com.in6k.entity;

import com.in6k.form.UserForm;

public class User {
    int id;
    String name;
    String email;
    String password;

    public User() {
    }

    public User(UserForm form) {
        name = form.getName();
        email = form.getEmail();
        password = form.getPassword();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
