package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class HomeAtletaControllerG {
    @FXML
    public Button logout;

    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Button prenotaLezione;

    @FXML
    public Button home;

    @FXML
    public Label erroriLabel;

    @FXML
    private void onPrenotaLezioneClick(){
        FxmlLoader.setPage("views1/prenotaAtleta1-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "non implementato");
    }

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeAtleta1-view");
    }


    public void onLogoutClick() {
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
