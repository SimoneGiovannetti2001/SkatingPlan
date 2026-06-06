package com.example.skatingplan.model.dao.fs;

import com.example.skatingplan.model.dao.*;

public class FSFactoryDAO extends DAOFactory {

    @Override
    public LoginDAO creaLoginDAO() {
        return new FSLoginDAO();
    }

    @Override
    public PagamentiDAO creaPagamentiDAO() {
        //non implementato
        return null;
    }

    @Override
    public LezioniDAO creaLezioniDAO() {
        //non implementato
        return null;
    }

    @Override
    public AtletaDAO creaAtletaDAO() {
        //non implementato
        return null;
    }


}
