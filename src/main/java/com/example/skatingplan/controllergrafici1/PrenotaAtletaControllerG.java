package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import com.example.skatingplan.utili.NavigazioneBase;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
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
    public Button prenotaLezione;

    @FXML
    public Button home;

    @FXML
    public Button cerca;

    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Button logout;

    @FXML
    public Label erroriLabel;

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

        for (int h = 8; h <= 20; h++) {
            fasce.add(LocalTime.of(h, 0));
            fasce.add(LocalTime.of(h,30));
        }

        oraComboBox.getItems().addAll(fasce);
    }
    @FXML
    private void onPrenotaLezioneClick(){
        FxmlLoader.setPage("views1/prenotaAtleta1-view");
    }

    @FXML
    private void onGestisciPrenotazioniClick(){
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "non implementato");
    }

    @FXML
    private void onCercaClick(){
        try {
            vBoxLezioniDisponibili.getChildren().clear();
            FiltriBean filtriBean = controllaFiltri(data.getValue(), oraComboBox.getValue(), regioneComboBox.getValue());
            PrenotaController prenotaController = new PrenotaController();
            List<LezioneBean> lezioniDisponibili = prenotaController.selezionaLezioni(filtriBean);
            if (!lezioniDisponibili.isEmpty()) {
                for (LezioneBean lezioneBean : lezioniDisponibili) {
                    vBoxLezioniDisponibili.getChildren().add(creaRiga(lezioneBean));
                }
            } else {
                GestoreMessaggiGUI.mostraErrore(erroriLabel, "Lezioni non disponibili, riprovare");
            }
        }catch (DatabaseNonRaggiungibileException | InputIllegaleException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }

    }

    private FiltriBean controllaFiltri(LocalDate data, LocalTime oraInizio, Regione regione) throws InputIllegaleException {

        if (regione == null){
            throw new InputIllegaleException("Inserire regione per continuare");
        }

        if (data == null){
            throw new InputIllegaleException("Inserire data per continuare");
        }

        if (oraInizio == null){
            throw new InputIllegaleException("Inserire ora di inizio per continuare");
        }



        return new FiltriBean(data, oraInizio, regione);
    }

    private Parent creaRiga(LezioneBean lezioneBean){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/skatingplan/views1/rigaLezione1.fxml"));
            Parent node = loader.load();

            RigaLezioneControllerG rigaLezioneControllerG = loader.getController();

            rigaLezioneControllerG.setDati(lezioneBean);

            return node;

        } catch (IOException _) {
            //non gestita

        }
        return null;
    }

    @FXML
    private void onHomeClick(){
        NavigazioneBase.home(Sessione.getSessioneCorrente().getRuolo());
    }

    @FXML
    public void onLogoutClick() {
        NavigazioneBase.logout(erroriLabel);
    }
}
