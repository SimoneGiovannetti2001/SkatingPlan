package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Atleta;
import com.example.skatingplan.model.Utente;

import java.sql.SQLException;

public interface LoginDAO {
    public Utente login(String user, String passw) throws SQLException;
}
