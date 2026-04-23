package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.bean.LoginBean;

import com.example.skatingplan.model.dao.LoginDao;
import com.example.skatingplan.model.enumerazioni.Role;



public class LoginController {
    public Role autenticazione(LoginBean loginBean) {
        LoginDao loginDAO = new LoginDao();
        Role ruolo = null;
        try {
            ruolo = loginDAO.login(loginBean);
        } catch (Exception e) {
            System.out.println("errore");
        }
        return ruolo;
    }
}
