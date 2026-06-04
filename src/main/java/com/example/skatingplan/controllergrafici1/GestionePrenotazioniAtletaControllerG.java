package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;


public class GestionePrenotazioniAtletaControllerG {
    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Button prenotaLezione;

    @FXML
    public Button logout;

    @FXML
    public ScrollPane scrollpane;

    @FXML
    public VBox vBoxLezioniDisponibili;

    @FXML
    public Button home;

    @FXML
    public Label erroriLabel;

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeAtleta1-view");
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
    public void initialize() {
        //da implementare
    }

    @FXML
    public void onLogoutClick() {
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Ruolo.LOGIN);
            }
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }
        FxmlLoader.setPage("views1/login1-view");
    }
}
