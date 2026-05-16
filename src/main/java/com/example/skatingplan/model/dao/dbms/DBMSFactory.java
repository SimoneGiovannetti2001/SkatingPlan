package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.dao.*;


public class DBMSFactory extends DAOFactory {

    @Override
    public LoginDAO creaLoginDAO() {
        return new DBMSLoginDAO();
    }

    @Override
    public PagamentiDAO creaPagamentiDAO() {
        return new DBMSPagamentiDAO();
    }

    @Override
    public LezioniDAO creaLezioniDAO() {
        return new DBMSLezioneDAO();
    }

    @Override
    public AtletaDAO creaAtletaDAO() {
        return new DBMSAtletaDAO();
    }

    @Override
    public AllenatoreDAO creaAlleantoreDAO() {
        return new DBMSAllenatoreDAO();
    }


}
