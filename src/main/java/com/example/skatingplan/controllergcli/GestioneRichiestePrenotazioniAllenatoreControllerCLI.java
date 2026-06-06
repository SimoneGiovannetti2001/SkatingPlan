package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.GestisciRichiestePrenotazioniController;
import com.example.skatingplan.controllergcli.viewcli.GestisciRichiestePrenotazioniAllenatoreView;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;

import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.bean.PrenotazioneBean;
import com.example.skatingplan.utili.MessaggiCLI;


import java.util.List;

public class GestioneRichiestePrenotazioniAllenatoreControllerCLI {

    private GestioneRichiestePrenotazioniAllenatoreControllerCLI(){
        //non deve essere istanziata
    }


    public static void start(){
        try {
            GestisciRichiestePrenotazioniController gestisciRichiestePrenotazioniController = new GestisciRichiestePrenotazioniController();
            boolean continua = true;
            while(continua) {
                List<PrenotazioneBean> prenotazioniRichieste;
                int scelta;
                PrenotazioneBean prenotazioneScelta;

                prenotazioniRichieste = gestisciRichiestePrenotazioniController.selezionaPrenotazioniRichieste();

                if (prenotazioniRichieste.isEmpty()) {
                    MessaggiCLI.mostraMessaggio("Nessuna prenotazione richiesta al momento");
                    break;
                } else {

                    GestisciRichiestePrenotazioniAllenatoreView.mostraPrenotazioniRichieste(prenotazioniRichieste);

                    scelta = GestisciRichiestePrenotazioniAllenatoreView.scegliPrenotazioneDaConfermare();

                    if(scelta != 0 ){
                        prenotazioneScelta = prenotazioniRichieste.get(scelta - 1);

                        gestisciRichiestePrenotazioniController.confermaRichiestaPrenotazione(prenotazioneScelta);

                        scelta = GestisciRichiestePrenotazioniAllenatoreView.richiestaConfermaAltraLezione();

                        if(scelta == 0){
                            continua = false;
                        }
                    }

                }
            }

        }catch (DatabaseNonRaggiungibileException | InputIllegaleException e){
            MessaggiCLI.mostraErrore(e.getMessage());
        }
    }


}
