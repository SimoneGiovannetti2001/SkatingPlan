package com.example.skatingplan.model.bean;

public class LoginBean {
    String user;
    String pass;

    public LoginBean(String user, String pass){
        this.user = user;
        this.pass = pass;
    }

    public String getUser() {
        return this.user;
    }

    public String getPass(){
        return this.pass;
    }
}
