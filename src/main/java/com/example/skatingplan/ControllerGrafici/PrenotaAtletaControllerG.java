package com.example.skatingplan.ControllerGrafici;

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
    private void onPrenotaLezioneClick(){
        FxmlLoader.setPage("views/prenotaatleta-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        FxmlLoader.setPage("views/gestisciprenotazioniatleta-view");
    }

    @FXML
    private void onConfermaClick(){
        FxmlLoader.setPage("views/dettagliprenotazioneatleta-view");
    }
}
