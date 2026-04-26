package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.bean.LoginBean;

import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.FactoryConfig;


public class LoginController {
    public Role autenticazione(LoginBean loginBean) {
        LoginDAO loginDAO= FactoryConfig.getDaoFactory().creaLoginDAO();
        Role ruolo = null;
        try {
            ruolo = loginDAO.login(loginBean);
        } catch (Exception e) {
            System.out.println("errore");
        }
        return ruolo;
    }
}
