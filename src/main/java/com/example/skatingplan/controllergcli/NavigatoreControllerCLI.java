package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.controllergcli.viewcli.LoginViewCLI;
import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;


import java.io.IOException;


import static java.lang.System.*;

public class NavigatoreControllerCLI {


    public static void start(){
        boolean continua = true;
        while(continua) {
            LoginController loginController = new LoginController();
            try {
                LoginBean loginBean = new LoginBean(LoginViewCLI.chiediNomeUtente(), LoginViewCLI.chiediPassUtente());
                UtenteBean utenteCorrente = loginController.autenticazione(loginBean);
                switch (utenteCorrente.getRuolo()) {
                    case ATLETA -> HomeAtletaCLI.start();
                    case ALLENATORE -> HomeAllenatoreCLI.start();
                    case MANAGER -> HomeManagerCLI.start();
                    default -> throw new CredenzialiErrateException("Unexpected value: " + utenteCorrente.getRuolo());
                }

                ConnectionFactory.changeRole(Role.LOGIN);

                continua = LoginViewCLI.chiediSeRiloggare();

            } catch (IOException | FSNonEsistenteException | FSOperazioneExcpetion | DatabaseNonRaggiungibileException | CredenzialiErrateException e) {
                out.println("Errore: " + e.getMessage());
            }

        }

    }

}
