package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.enumerazioni.Regione;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PrenotaAtletaControllerG {
    @FXML
    private ScrollPane scrollpane;

    @FXML
    private ComboBox<LocalTime> oraComboBox;

    @FXML
    private ComboBox<Regione> regioneComboBox;

    @FXML
    private Button prenotaLezione;

    @FXML
    private Button gestisciPrenotazioni;

    @FXML
    private Button cerca;

    @FXML
    private Button home;

    @FXML
    public void initialize() {
        regioneComboBox.getItems().addAll(Regione.values());
        List<LocalTime> fasce = new ArrayList<>();

        for (int h = 8; h <= 18; h++) {
            fasce.add(LocalTime.of(h, 0));
        }

        oraComboBox.getItems().addAll(fasce);
    }
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
