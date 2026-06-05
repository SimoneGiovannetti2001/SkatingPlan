package com.example.skatingplan.controllerapplicativi;


import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.bean.PrenotazioneBean;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
import com.example.skatingplan.utili.FactoryConfig;


import java.util.ArrayList;
import java.util.List;


public class GestisciRichiestePrenotazioniController {

    public void confermaRichiestaPrenotazione(){
        //serve per accettare una prenotazione
    }

    public void rifiutaRichiestaPrenotazione(){
        //serve per rifiutarla
    }

    public List<PrenotazioneBean> selezionaPrenotazioniRichieste() throws DatabaseNonRaggiungibileException {

        List<Prenotazione> prenotazioniTrovate;
        List<PrenotazioneBean> prenotazioniRichieste = new ArrayList<>();
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        prenotazioniTrovate = lezioniDAO.prendiLezioniRichiesteAllenatore(Sessione.getSessioneCorrente());
        for (Prenotazione prenotazione: prenotazioniTrovate){
            prenotazioniRichieste.add(new PrenotazioneBean(prenotazione));
        }
        return prenotazioniRichieste;
    }

    public void aggiornaStatoPrenotazione(PrenotazioneBean prenotazionebean) throws DatabaseNonRaggiungibileException {
        Prenotazione prenotazione = new Prenotazione(prenotazionebean);
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        lezioniDAO.aggiornastato(prenotazione.getLezione().getId(), StatoPrenotazione.CONFERMATA);
    }
}
