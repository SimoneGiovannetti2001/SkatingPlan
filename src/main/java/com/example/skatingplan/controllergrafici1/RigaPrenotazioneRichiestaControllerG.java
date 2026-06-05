package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.GestisciRichiestePrenotazioniController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.PrenotazioneBean;
import com.example.skatingplan.utili.PrenotazioneViewPopolatore;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class RigaPrenotazioneRichiestaControllerG {


    @FXML
    public Button confermaRichiesta;

    @FXML
    public Label oraInizio;

    @FXML
    public Label durata;

    @FXML
    public Label atleta;

    @FXML
    public Label pista;

    @FXML
    public Label indirizzo;

    @FXML
    public Label data;

    @FXML
    public Label regione;

    @FXML
    public Label livello;

    @FXML
    public Button annullaRichiesta;

    private PrenotazioneBean prenotazione;

    public void impostaDati(PrenotazioneBean prenotazioneBean){
        this.prenotazione = prenotazioneBean;
        PrenotazioneViewPopolatore.popolaInfoLuogo(prenotazioneBean, pista, indirizzo, regione);
        PrenotazioneViewPopolatore.popolaInfoAtleta(prenotazioneBean, atleta, livello);
        PrenotazioneViewPopolatore.popolaInfoTempo(prenotazioneBean, oraInizio, durata, data);
    }

    public void onConfermaRichiestaClick() throws DatabaseNonRaggiungibileException {
        try {
            GestisciRichiestePrenotazioniController gestisciRichiestePrenotazioniController = new GestisciRichiestePrenotazioniController();
            gestisciRichiestePrenotazioniController.aggiornaStatoPrenotazione(prenotazione);
            FxmlLoader.setPage("views1/gestisciRichiestePrenotazioniAllenatore1-view");
        }catch (DatabaseNonRaggiungibileException _){
            //non gestita
        }
    }

    public void onAnnullaRichiestaCliick() {
        //non implementata
    }
}
