package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.enumerazioni.Role;

public abstract class DAOFactory {
    public abstract LoginDAO creaLoginDAO();
    public abstract PagamentiDAO creaPagamentiDAO();
    public abstract LezioniDAO creaLezioniDAO();

    public abstract AtletaDAO creaAtletaDAO();

    public abstract AllenatoreDAO creaAlleantoreDAO();
}
