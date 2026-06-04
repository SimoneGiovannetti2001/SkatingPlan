package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.controllergcli.viewcli.LoginViewCLI;
import com.example.skatingplan.eccezioni.*;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;

import java.io.IOException;

public class LoginControllerCLI {

    private LoginControllerCLI(){
        //non deve essere istanziata
    }

    public static void start(){
        boolean continua = true;
        while(continua) {
            LoginController loginController = new LoginController();
            try {
                LoginBean loginBean = new LoginBean(LoginViewCLI.chiediNomeUtente(), LoginViewCLI.chiediPassUtente());
                checkInputLogin(loginBean);
                UtenteBean utenteCorrente = loginController.autenticazione(loginBean);
                switch (utenteCorrente.getRuolo()) {
                    case ATLETA -> HomeAtletaControllerCLI.start();
                    case ALLENATORE -> HomeAllenatoreControllerCLI.start();
                    case MANAGER -> HomeManagerControllerCLI.start();
                    default -> throw new CredenzialiErrateException("Unexpected value: " + utenteCorrente.getRuolo());
                }

                resetUtente();

                continua = LoginViewCLI.chiediSeRiloggare();

            } catch (CredenzialiErrateException | InputIllegaleException | DatabaseNonRaggiungibileException | FSOperazioneExcpetion | FSNonEsistenteException | IOException e) {
                LoginViewCLI.mostraErrore(e.getMessage());
            }

        }

    }

    private static void checkInputLogin(LoginBean loginBean) throws InputIllegaleException {
        if ((loginBean.getUser() == null || loginBean.getUser().isBlank()) && (loginBean.getPass() == null || loginBean.getPass().isBlank())) {
            throw new InputIllegaleException("Inserire nome utente e password");
        }

        if(loginBean.getUser() == null || loginBean.getUser().isBlank()) {
            throw new InputIllegaleException("Inserire nome utente");
        }

        if(loginBean.getPass() == null || loginBean.getPass().isBlank()) {
            throw new InputIllegaleException("Inserire password");
        }
    }

    private static void resetUtente(){
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Ruolo.LOGIN);
            }
        }catch (DatabaseNonRaggiungibileException e){
            LoginViewCLI.mostraErrore(e.getMessage());
        }

    }

}
