package com.example.skatingplan.controllergcli;


import com.example.skatingplan.controllergcli.viewcli.HomeAllenatoreView;
import com.example.skatingplan.controllergcli.viewcli.HomeAtletaViewCLI;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.ExitException;
import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.MessaggiCLI;

import java.io.IOException;

public class HomeAllenatoreControllerCLI {

    private HomeAllenatoreControllerCLI() {
        //non deve essere istanziata
    }

    public static void start() {
        boolean continua = true;

        while (continua) {
            try {
                int choice;

                choice = selezionascelta();

                switch (choice) {
                    case 1 -> {}
                    case 2 -> {}
                    case 3 -> {}
                    case 4 -> {
                        logout();
                        continua = false;
                    }
                    default -> throw new InputIllegaleException("Scelta non valida, riprovare");

                }
            }catch (InputIllegaleException  e) {
                MessaggiCLI.mostraErrore(e.getMessage());
            }catch(ExitException e){
                MessaggiCLI.mostraMessaggio(e.getMessage());
            }
        }

    }

    private static int selezionascelta() throws InputIllegaleException {
        try {
            return HomeAllenatoreView.mostraMenuAllenatore();
        }catch (IOException e) {
            throw new InputIllegaleException("Input non valido, riprovare", e);
        }
    }

    private static void logout(){
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Ruolo.LOGIN);
            }

        }catch (DatabaseNonRaggiungibileException e){
            MessaggiCLI.mostraErrore(e.getMessage());
        }
    }

}

