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


public class HomeAllenatoreControllerG {
    @FXML
    public Button home;

    @FXML
    public Button logout;

    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Label erroriLabel;

    @FXML
    public Button gestisciRichiestePrenotazioni;

    @FXML
    public void onHomeClick() {
        FxmlLoader.setPage("views1/homeAllenatore1-view");
    }

    @FXML
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

    @FXML
    public void onGestisciPrenotazioniClick() {

        FxmlLoader.setPage("views1/gestisciRichiestePrenotazioniAllenatore1-view");
    }



    public void onGestisciRichiestePrenotazioniClick() {
        FxmlLoader.setPage("views1/gestisciRichiestePrenotazioniAllenatore1-view");

    }
}
