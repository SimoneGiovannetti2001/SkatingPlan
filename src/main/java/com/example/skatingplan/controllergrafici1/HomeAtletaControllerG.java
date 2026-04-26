package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;



public class HomeAtletaControllerG {

    @FXML
    private TextField ricerca;

    @FXML
    private Button prenota;

    @FXML
    private Button gestisciPrenotazioni;


    @FXML
    private void onPrenotaClick(){
        FxmlLoader.setPage("views/prenotaatleta-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        FxmlLoader.setPage("views/gestisciprenotazioniatleta-view");
    }

}
