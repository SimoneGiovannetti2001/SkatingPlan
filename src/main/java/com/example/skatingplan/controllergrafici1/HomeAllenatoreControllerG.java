package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import com.example.skatingplan.utili.NavigazioneBase;
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
        NavigazioneBase.home(Sessione.getSessioneCorrente().getRuolo());
    }

    @FXML
    public void onLogoutClick() {
        NavigazioneBase.logout(erroriLabel);
    }

    @FXML
    public void onGestisciPrenotazioniClick() {
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "non implementato");
    }




    public void onGestisciRichiestePrenotazioniClick() {
        FxmlLoader.setPage("views1/gestisciRichiestePrenotazioniAllenatore1-view");
    }
}
