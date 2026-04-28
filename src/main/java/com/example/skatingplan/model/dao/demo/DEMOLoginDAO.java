package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.io.FileInputStream;
import java.io.IOException;


public class DEMOLoginDAO implements LoginDAO {

    @Override
    public Role login(LoginBean loginBean) {
        if(loginBean.getUser().equals("atleta") && loginBean.getPass().equals("atleta")){
            return Role.ATLETA;
        } else if (loginBean.getUser().equals("allenatore") && loginBean.getPass().equals("allenatore")) {
            return  Role.ALLENATORE;
        } else if (loginBean.getUser().equals("manager") && loginBean.getPass().equals("manager")) {
            return Role.MANAGER;
        }else{
            return null;
        }
    }
}
