package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrenotaAtletaControllerG {

    @FXML
    private Button prenotaLezione;

    @FXML
    private Button gestisciPrenotazioni;

    @FXML
    private Button conferma;

    @FXML
    private Button home;
    @FXML
    private void onPrenotaLezioneClick(){
        FxmlLoader.setPage("views1/prenotaatleta1-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        FxmlLoader.setPage("views1/gestisciprenotazioniatleta1-view");
    }

    @FXML
    private void onConfermaClick(){
        FxmlLoader.setPage("views1/dettagliprenotazioneatleta1-view");
    }

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
    }

}
