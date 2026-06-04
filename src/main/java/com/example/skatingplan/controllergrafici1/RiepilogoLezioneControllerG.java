package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.utili.LezioneViewPopolatore;
import com.example.skatingplan.model.bean.LezioneBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RiepilogoLezioneControllerG {
    @FXML
    public Button conferma;
    @FXML
    public Button annulla;
    @FXML
    public Label pista;
    @FXML
    public Label indirizzo;
    @FXML
    public Label regione;
    @FXML
    public Label allenatore;
    @FXML
    public Label qualifica;
    @FXML
    public Label costo;
    @FXML
    public Label data;
    @FXML
    public Label oraInizio;
    @FXML
    public Label durata;

    private Stage stage;

    private boolean confermato = false;

    public void impostaStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isConfermato() {
        return confermato;
    }

    public void onAnnullaClick() {
        stage.close();
    }

    public void onConfermaClick() {
        confermato = true;
        stage.close();
    }

    public static boolean mostra(LezioneBean lezioneBean) {

        try {
            FXMLLoader loader = new FXMLLoader(RiepilogoLezioneControllerG.class.getResource("/com/example/skatingplan/views1/riepilogo-lezione1.fxml"));

            Parent root = loader.load();

            RiepilogoLezioneControllerG controller = loader.getController();

            Stage stage = new Stage();

            controller.impostaStage(stage);
            controller.setData(lezioneBean);

            stage.setTitle("Riepilogo Lezione");
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(new Scene(root));


            stage.showAndWait();

            return controller.isConfermato();

        } catch (IOException _) {
            //non gestita
        }
        return false;
    }

    private void setData(LezioneBean lezioneBean){
        LezioneViewPopolatore.popolaInfoTempo(lezioneBean, oraInizio, durata, data);
        LezioneViewPopolatore.popolaInfoLuogo(lezioneBean, pista, indirizzo, regione);
        LezioneViewPopolatore.popolaInfoAllenatore(lezioneBean, allenatore, qualifica, costo);
    }

}
