package com.example.skatingplan.model.dao;

public abstract class DAOFactory {
    public abstract LoginDAO creaLoginDAO();
    public abstract PagamentiDAO creaPagamentiDAO();
    public abstract LezioniDAO creaLezioniDAO();
}
