package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class HomeAtletaControllerG {
    @FXML
    private Button prenota;

    @FXML
    private Button button3;

    @FXML
    private TextField ricerca;

    @FXML
    private Button prenotaLezione;

    @FXML
    private Button gestisciPrenotazioni;

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
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
    }


}
