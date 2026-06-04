package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
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
        FxmlLoader.setPage("views1/gestisciPrenotazioniAtleta1-view");
    }

    @FXML
    private void onCercaClick(){

        FiltriBean filtriBean = new FiltriBean(data.getValue(), oraComboBox.getValue(), regioneComboBox.getValue());
        PrenotaController prenotaController = new PrenotaController();
        List<LezioneBean> lezioniDisponibili = prenotaController.selezionaLezioni(filtriBean);
        if(!lezioniDisponibili.isEmpty()) {
            vBoxLezioniDisponibili.getChildren().clear();

            for (LezioneBean lezioneBean : lezioniDisponibili) {
                vBoxLezioniDisponibili.getChildren().add(creaRiga(lezioneBean));
            }
        }else{
            GestoreMessaggiGUI.mostraErrore(erroriLabel,"Lezioni non disponibili, riprovare");
        }

    }

    private Parent creaRiga(LezioneBean lezioneBean){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/skatingplan/views1/rigaLezione1.fxml"));
            Parent node = loader.load();

            RigaLezioneControllerG rigaLezioneControllerG = loader.getController();

            rigaLezioneControllerG.setDati(lezioneBean);

            return node;

        } catch (IOException e) {
            //non gestita

        }
        return null;
    }

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeAtleta1-view");
    }

    @FXML
    public void onLogoutClick() {
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Role.LOGIN);
            }
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }
        FxmlLoader.setPage("views1/login1-view");
    }
}
