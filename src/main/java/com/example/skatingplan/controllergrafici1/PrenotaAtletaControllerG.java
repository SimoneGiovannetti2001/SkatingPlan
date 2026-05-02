package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioniDisponibiliBean;
import com.example.skatingplan.model.enumerazioni.Regione;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PrenotaAtletaControllerG {
    @FXML
    public DatePicker data;

    @FXML
    public VBox vBoxLezioniDisponibili;

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

        FiltriBean filtriBean = new FiltriBean((LocalDate)data.getValue(), oraComboBox.getValue(), regioneComboBox.getValue());
        PrenotaController prenotaController = new PrenotaController();
        LezioniDisponibiliBean lezioniDisponibiliBean = prenotaController.selezionaLezioni(filtriBean);
    }

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
    }

}
