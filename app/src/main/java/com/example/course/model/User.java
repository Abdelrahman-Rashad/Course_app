package com.example.course.model;

public class User {
    private int id;
    private String fullname,email,password,username;

    public User(int id, String fullname, String username, String email, String password) {
        this.id = id;
        this.fullname = fullname;
        this.username = username;
        this.email = email;
        this.password = password;
    }



    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }



    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public String getFullname() {
        return fullname;
    }



    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }



    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }



    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
}
