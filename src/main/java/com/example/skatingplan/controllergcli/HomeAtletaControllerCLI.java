package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllergcli.viewcli.HomeAtletaViewCLI;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;

import java.io.IOException;

public class HomeAtletaControllerCLI {

    private HomeAtletaControllerCLI(){
        //non deve essere istanziata
    }

    public static void start(){

        boolean continua = true;

            while (continua) {
                try {
                    int choice;

                    choice = HomeAtletaViewCLI.mostraOperazioni();

                    switch (choice) {
                        case 1 -> PrenotaAtletaControllerCLI.start();
                        case 2 -> GestisciPrenotazioniAtletaCLI.start();
                        case 3 -> {
                            logout();
                            continua = false;
                        }
                        default -> throw new IllegalArgumentException("Scelta non valida, riprovare");

                    }
                }catch (IOException e) {
                    throw new IllegalArgumentException("Errore: input non disponibile, riprovare", e);

                }catch (IllegalArgumentException e) {
                    HomeAtletaViewCLI.mostraErrore(e.getMessage());
                }
            }

    }

    private static void logout(){
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Role.LOGIN);
            }

        }catch (DatabaseNonRaggiungibileException e){
            HomeAtletaViewCLI.mostraErrore(e.getMessage());
        }
    }
}
