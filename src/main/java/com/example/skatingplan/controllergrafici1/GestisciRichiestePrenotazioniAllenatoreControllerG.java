package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.GestisciRichiestePrenotazioniController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.bean.LezioniBean;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GestisciRichiestePrenotazioniAllenatoreControllerG {

    @FXML
    public Button gestisciPrenotazioni;

    @FXML
    public Button gestisciRichiestePrenotazioni;

    @FXML
    public ScrollPane scrollpane;

    @FXML
    public VBox vBoxLezioniRichieste;

    @FXML
    public Label erroriLabel;

    @FXML
    public Button logout;

    @FXML
    public Button home;

    GestisciRichiestePrenotazioniController gestisciRichiestePrenotazioniController = new GestisciRichiestePrenotazioniController();

    public void initialize(){
        LezioniBean lezioniRichieste;
        lezioniRichieste = gestisciRichiestePrenotazioniController.selezionaPrenotazioniRichieste();

        if(lezioniRichieste.lunghezza() != 0) {
            vBoxLezioniRichieste.getChildren().clear();

            for (int i = 0; i < lezioniRichieste.lunghezza(); i++) {
                vBoxLezioniRichieste.getChildren().add(creaRiga(lezioniRichieste.getLezione(i)));
            }

        }else{
            GestoreMessaggiGUI.mostraErrore(erroriLabel,"Nessuna lezione richiesta al momento");
        }

    }

    private Parent creaRiga(LezioneBean lezioneBean){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/skatingplan/views1/rigaPrenotazioneRichiesta.fxml"));
            Parent node = loader.load();

            RigaPrenotazioneRichiestaControllerG rigaPrenotazioneRichiestaControllerG = loader.getController();

            rigaPrenotazioneRichiestaControllerG.impostaDati(lezioneBean);

            return node;

        } catch (IOException e) {
            e.printStackTrace();

        }
        return null;
    }

    public void onGestisciPrenotazioniClick() {
        //da implementare
    }

    public void onGestisciRichiestePrenotazioniClick() {
        FxmlLoader.setPage("views1/gestisciRichiestePrenotazioniAllenatore1-view");
    }

    public void onHomeClick() {
        FxmlLoader.setPage("views1/homeAllenatore1-view");
    }

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
