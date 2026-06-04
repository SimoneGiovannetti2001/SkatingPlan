package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllergcli.viewcli.HomeAtletaViewCLI;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.ExitException;
import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;

import java.io.IOException;

public class HomeAtletaControllerCLI {

    private HomeAtletaControllerCLI(){
        //non deve essere istanziata
    }

    public static void start()  {

        boolean continua = true;

            while (continua) {
                try {
                    int choice;

                    choice = selezionascelta();

                    switch (choice) {
                        case 1 -> PrenotaAtletaControllerCLI.start();
                        case 2 -> GestisciPrenotazioniAtletaCLI.start();
                        case 3 -> {
                            logout();
                            continua = false;
                        }
                        default -> throw new InputIllegaleException("Scelta non valida, riprovare");

                    }
                }catch (InputIllegaleException  e) {
                    HomeAtletaViewCLI.mostraErrore(e.getMessage());
                }catch(ExitException e){
                    HomeAtletaViewCLI.mostraMessaggio(e.getMessage());
                }
            }

    }

    private static int selezionascelta() throws InputIllegaleException {
        try {
            return HomeAtletaViewCLI.mostraOperazioni();
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
            HomeAtletaViewCLI.mostraErrore(e.getMessage());
        }
    }
}
