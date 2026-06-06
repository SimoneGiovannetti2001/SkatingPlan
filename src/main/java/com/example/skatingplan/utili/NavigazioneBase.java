package com.example.skatingplan.utili;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import javafx.scene.control.Label;

public class NavigazioneBase {

    private NavigazioneBase(){
        //non deve essere istanziata
    }

    public static void home(Ruolo ruolo){

        switch (ruolo) {
            case ATLETA -> FxmlLoader.setPage("views1/homeAtleta1-view");
            case ALLENATORE -> FxmlLoader.setPage("views1/homeAllenatore1-view");
            case MANAGER -> FxmlLoader.setPage("views1/homeManager1-view");
            default -> throw new IllegalArgumentException("Ruolo non trovato");
        }
    }

    public static void logout(Label erroriLabel){
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Ruolo.LOGIN);
            }
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }
        FxmlLoader.setPage("views1/login1-view");
    }
}
