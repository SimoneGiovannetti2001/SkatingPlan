package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.GestoreMessaggiUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


public class HomeAllenatoreControllerG {
    @FXML
    public Button home;
    @FXML
    public Button logout;
    @FXML
    public Button confermaPrenotazioni;
    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Label erroriLabel;


    @FXML
    public void onHomeClick() {
        FxmlLoader.setPage("views1/homeallenatore1-view");
    }

    @FXML
    public void onLogoutClick() {
        try {
            ConnectionFactory.changeRole(Role.LOGIN);
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiUI.mostraErrore(erroriLabel, e.getMessage());
        }
        FxmlLoader.setPage("views1/login1-view");
    }

    @FXML
    public void onGestisciPrenotazioniClick() {
        FxmlLoader.setPage("views1/gestisciprenotazioniallenatore1-view");
    }

    @FXML
    public void onConfermaPrenotazioniClick(){
        FxmlLoader.setPage("views1/confermaprenotazioni1-view");
    }
}
