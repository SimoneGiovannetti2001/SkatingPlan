package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GestionePrenotazioniAtletaControllerG {

    public Button gestisciPrenotazioni;
    public Button prenotaLezione;
    @FXML
    private Button homeAtleta;

    @FXML
    private Button disdiciPrenotazione;

    @FXML
    private Button home;

    @FXML
    public void onClickDisdiciPrenotazioneClick(){
        FxmlLoader.setPage("views1/gestioneprenotazioniatleta1-view");
    }
    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
    }

    @FXML
    private void onPrenotaLezioneClick(){
        FxmlLoader.setPage("views1/prenotaatleta1-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        FxmlLoader.setPage("views1/gestisciprenotazioniatleta1-view");
    }


}
