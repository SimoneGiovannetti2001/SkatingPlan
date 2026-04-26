package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.enumerazioni.Role;

import java.sql.SQLException;

public interface LoginDAO {
    public Role login(LoginBean loginBean) throws SQLException;
}
