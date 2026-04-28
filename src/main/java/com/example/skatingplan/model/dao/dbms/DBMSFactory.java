package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.dao.DAOFactory;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.dao.PagamentiDAO;

public class DBMSFactory extends DAOFactory {

    @Override
    public LoginDAO creaLoginDAO() {
        return new DBMSLoginDAO();
    }

    @Override
    public PagamentiDAO creaPagamentiDAO() {
        return null;
    }

    @Override
    public LezioniDAO creaLezioniDAO() {
        return null;
    }
}
