package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.GestisciRichiestePrenotazioniController;
import com.example.skatingplan.controllergcli.viewcli.GestisciRichiestePrenotazioniAllenatoreView;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;

import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.bean.PrenotazioneBean;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
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

                prenotazioniRichieste = gestisciRichiestePrenotazioniController.selezionaPrenotazioniRichieste();

                if (prenotazioniRichieste.isEmpty()) {
                    MessaggiCLI.mostraMessaggio("Nessuna prenotazione richiesta al momento");
                    break;
                } else {

                    continua = gestisciPrenotazione(gestisciRichiestePrenotazioniController, prenotazioniRichieste);

                }
            }

        }catch (DatabaseNonRaggiungibileException | InputIllegaleException e){
            MessaggiCLI.mostraErrore(e.getMessage());
        }
    }

    private static boolean gestisciPrenotazione(GestisciRichiestePrenotazioniController gestisciRichiestePrenotazioniController, List<PrenotazioneBean> prenotazioniRichieste) throws InputIllegaleException, DatabaseNonRaggiungibileException {

        int scelta;
        PrenotazioneBean prenotazioneScelta;
        String nuovoStato;

        GestisciRichiestePrenotazioniAllenatoreView.mostraPrenotazioniRichieste(prenotazioniRichieste);

        scelta = GestisciRichiestePrenotazioniAllenatoreView.scegliPrenotazioneDaConfermare();

        if(scelta == 0 ) {
            return false;
        }

        prenotazioneScelta = prenotazioniRichieste.get(scelta - 1);

        nuovoStato = GestisciRichiestePrenotazioniAllenatoreView.confermaOCancella();

        if(nuovoStato.equals(StatoPrenotazione.CONFERMATA.toString())){
            gestisciRichiestePrenotazioniController.confermaRichiestaPrenotazione(prenotazioneScelta);
        } else if (nuovoStato.equals(StatoPrenotazione.CANCELLATA.toString())) {
            gestisciRichiestePrenotazioniController.rifiutaRichiestaPrenotazione(prenotazioneScelta);
        } else if (nuovoStato.equals("exit")) {
            return false;
        }


        scelta = GestisciRichiestePrenotazioniAllenatoreView.confermaOCancellaAltraLezione();

        return scelta != 0;


    }




}
