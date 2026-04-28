package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.dao.DAOFactory;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.dao.PagamentiDAO;

public class DEMOFactory extends DAOFactory {
    @Override
    public LoginDAO creaLoginDAO() {
        return new DEMOLoginDAO();
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
