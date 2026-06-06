package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.dao.*;


public class DEMOFactory extends DAOFactory {

    private final LezioniDAO lezioniDAO = new DEMOLezioneDAO();

    private final PagamentiDAO pagamentiDAO = new DEMOPagamentiDAO();

    @Override
    public LoginDAO creaLoginDAO() {
        return new DEMOLoginDAO();
    }

    @Override
    public PagamentiDAO creaPagamentiDAO() {
        return pagamentiDAO;
    }

    @Override
    public LezioniDAO creaLezioniDAO() {
        return lezioniDAO;
    }

    @Override
    public AtletaDAO creaAtletaDAO() {
        return new DEMOAtletaDAO();
    }




}
