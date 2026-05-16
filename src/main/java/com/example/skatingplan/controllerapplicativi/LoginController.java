package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.bean.LoginBean;

import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.dao.LoginDAO;

import com.example.skatingplan.utili.FactoryConfig;

import java.sql.SQLException;


public class LoginController {
    public UtenteBean autenticazione(LoginBean loginBean) throws SQLException {
        LoginDAO loginDAO = FactoryConfig.getDaoFactory().creaLoginDAO();
        Utente utente = loginDAO.login(loginBean.getUser(), loginBean.getPass());
        ConnectionFactory.changeRole(utente.getRuolo());
//        FactoryConfig.getDaoFactory().creaUte
        Sessione.setSessione(utente);
        return new UtenteBean(utente);
    }


}
