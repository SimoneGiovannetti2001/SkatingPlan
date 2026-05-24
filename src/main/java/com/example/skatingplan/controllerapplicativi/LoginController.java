package com.example.skatingplan.controllerapplicativi;


import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.bean.LoginBean;

import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.dao.LoginDAO;

import com.example.skatingplan.utili.FactoryConfig;



public class LoginController {
    public UtenteBean autenticazione(LoginBean loginBean) throws CredenzialiErrateException, DatabaseNonRaggiungibileException, FSOperazioneExcpetion, FSNonEsistenteException {
        LoginDAO loginDAO = FactoryConfig.getDaoFactory().creaLoginDAO();
        Utente utente = loginDAO.login(loginBean.getUser(), loginBean.getPass());
        Sessione.setSessione(utente);
        return new UtenteBean(utente);
    }


}
