package com.example.skatingplan.controllergrafici;

import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GestionePrenotazioniAtletaControllerG {

    @FXML
    private Button homeAtleta;

    @FXML
    private Button disdiciPrenotazione;

    public void onClickDisdiciPrenotazioneClick(){
        FxmlLoader.setPage("views/gestioneprenotazioniatleta-view");
    }
}
