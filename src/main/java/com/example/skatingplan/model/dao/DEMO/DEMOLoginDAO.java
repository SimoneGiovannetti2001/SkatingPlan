package com.example.skatingplan.model.dao.DEMO;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.sql.SQLException;

public class DEMOLoginDAO implements LoginDAO {

    @Override
    public Role login(LoginBean loginBean) throws SQLException {
        System.out.println("ciao funziona");
        return null;
    }
}
