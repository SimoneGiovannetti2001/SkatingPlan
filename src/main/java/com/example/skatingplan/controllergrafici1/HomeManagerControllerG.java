package com.example.skatingplan.controllergrafici1;


import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import com.example.skatingplan.utili.NavigazioneBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeManagerControllerG {


    @FXML
    public Button home;

    @FXML
    public Button logout;

    @FXML
    public Label erroriLabel;

    @FXML
    public Button gestisciEvento;

    @FXML
    public Button inserisciEvento;

    @FXML
    private void onHomeClick(){
        NavigazioneBase.home(Sessione.getSessioneCorrente().getRuolo());
    }

    public void onLogoutClick() {
        NavigazioneBase.logout(erroriLabel);
    }


    public void onGestisciEventoClick() {
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "Funzionalità non disponibile al momento");
    }

    public void onInserisciEventoClick() {
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "Funzionalità non disponibile al momento");
    }
}
