package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.bean.LezioniDisponibiliBean;
import com.example.skatingplan.model.enumerazioni.Regione;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class PrenotaAtletaControllerG {
    @FXML
    public DatePicker data;

    @FXML
    public VBox vBoxLezioniDisponibili;

    @FXML
    public Button prenotaLezione;

    @FXML
    public Button home;

    @FXML
    public Button cerca;

    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    private ScrollPane scrollpane;

    @FXML
    private ComboBox<LocalTime> oraComboBox;

    @FXML
    private ComboBox<Regione> regioneComboBox;


    @FXML
    public void initialize() {
        scrollpane.setFocusTraversable(false);
        vBoxLezioniDisponibili.setFocusTraversable(false);

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
    private void onCerccaClick(){

        FiltriBean filtriBean = new FiltriBean(data.getValue(), oraComboBox.getValue(), regioneComboBox.getValue());
        PrenotaController prenotaController = new PrenotaController();
        LezioniDisponibiliBean lezioniDisponibiliBean = prenotaController.selezionaLezioni(filtriBean);

        vBoxLezioniDisponibili.getChildren().clear();

        for (int i = 0; i < lezioniDisponibiliBean.lunghezza(); i++) {
            vBoxLezioniDisponibili.getChildren().add(creaRiga(lezioniDisponibiliBean.getLezione(i)));
        }

    }

    private Parent creaRiga(LezioneBean lezioneBean){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/skatingplan/views1/rigalezione.fxml"));
            Parent node = loader.load();

            RigaLezioneControllerG rigaLezioneControllerG = loader.getController();

            rigaLezioneControllerG.setDati(lezioneBean);

            return node;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
    }

}
