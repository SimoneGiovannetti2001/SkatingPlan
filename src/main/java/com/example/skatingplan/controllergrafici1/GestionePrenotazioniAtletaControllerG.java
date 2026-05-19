package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.sql.SQLException;

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
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeatleta1-view");
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
    public void initialize() {
        //da implementare
    }

    public void onLogoutClick() {
        try {
            ConnectionFactory.changeRole(Role.LOGIN);
        }catch (SQLException e){
            //gestisci errore logout
        }
        FxmlLoader.setPage("views1/login1-view");
    }
}
