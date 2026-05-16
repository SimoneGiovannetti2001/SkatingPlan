package com.example.skatingplan.controllergrafici1;


import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.utili.LezioneViewPopolatore;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.model.bean.InfoPagamentoBean;
import com.example.skatingplan.model.bean.LezioneBean;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RigaLezioneControllerG {
    @FXML
    public Label data;
    @FXML
    public Label regione;
    @FXML
    public Label qualifica;
    @FXML
    public Label costo;

    @FXML
    private Button seleziona;
    @FXML
    private Label oraInizio;
    @FXML
    private Label durata;
    @FXML
    private Label allenatore;
    @FXML
    private Label pista;
    @FXML
    private Label indirizzo;

    private LezioneBean lezione;



    public void setDati(LezioneBean lezioneBean){
        this.lezione = lezioneBean;
        LezioneViewPopolatore.popola(lezioneBean, oraInizio, durata, allenatore, pista, indirizzo, data, regione, qualifica, costo);
    }
    public void onSelezionaClick() {
        boolean confermato = RiepilogoLezioneControllerG.mostra(lezione);


        if (confermato) {
            try{
                PrenotaController prenotaController = new PrenotaController();
                prenotaController.registraRichiestaPrenotazione(lezione);

            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            FXMLLoader loader = FxmlLoader.setPage("views1/paga1-view");

            PagaControllerG pagaControllerG = loader.getController();

            pagaControllerG.setInfoPagamento(new InfoPagamentoBean(lezione.getCosto(), lezione.getIdLezione()));

        }
    }
}
