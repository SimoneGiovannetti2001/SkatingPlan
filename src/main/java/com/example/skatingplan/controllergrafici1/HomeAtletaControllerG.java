package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import com.example.skatingplan.utili.NavigazioneBase;
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
        NavigazioneBase.home(Sessione.getSessioneCorrente().getRuolo());
    }


    public void onLogoutClick() {
        NavigazioneBase.logout(erroriLabel);
    }
}
