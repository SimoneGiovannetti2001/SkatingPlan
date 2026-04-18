package com.example.skatingplan.ControllerGrafici;

import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class DettagliPrenotazioneAtletaControllerG {

    @FXML
    private Button confermaScelta;

    @FXML
    private Button tornaAllaScelta;

    public void onConfermaSceltaClick(){
        FxmlLoader.setPage("views/homeatleta-view");
    }

    public void onTornaAllaScelta(){
        FxmlLoader.setPage("views/prenotaatleta-view");
    }


}
