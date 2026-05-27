package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.controllergcli.viewcli.LoginViewCLI;
import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;


import java.io.IOException;


import static java.lang.System.*;

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

                ConnectionFactory.changeRole(Role.LOGIN);

                continua = LoginViewCLI.chiediSeRiloggare();

            } catch (CredenzialiErrateException | IllegalArgumentException | DatabaseNonRaggiungibileException | FSOperazioneExcpetion | FSNonEsistenteException | IOException e) {
                LoginViewCLI.mostraErrore(e.getMessage());
            }

        }

    }

    private static void checkInputLogin(LoginBean loginBean){
        if ((loginBean.getUser() == null || loginBean.getUser().isBlank()) && (loginBean.getPass() == null || loginBean.getPass().isBlank())) {
            throw new IllegalArgumentException("Inserire nome utente e password");
        }

        if(loginBean.getUser() == null || loginBean.getUser().isBlank()) {
            throw new IllegalArgumentException("Inserire nome utente");
        }

        if(loginBean.getPass() == null || loginBean.getPass().isBlank()) {
            throw new IllegalArgumentException("Inserire password");
        }
    }
}
