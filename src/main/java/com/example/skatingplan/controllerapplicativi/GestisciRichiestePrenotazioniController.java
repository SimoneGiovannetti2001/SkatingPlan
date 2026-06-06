package com.example.skatingplan.controllerapplicativi;


import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.bean.PrenotazioneBean;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.dao.PagamentiDAO;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
import com.example.skatingplan.utili.FactoryConfig;


import java.util.ArrayList;
import java.util.List;


public class GestisciRichiestePrenotazioniController {

    public void confermaRichiestaPrenotazione(PrenotazioneBean prenotazionebean) throws DatabaseNonRaggiungibileException{
        Prenotazione prenotazione = new Prenotazione(prenotazionebean);
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        prenotazione.setStatoPrenotazione(StatoPrenotazione.CONFERMATA);
        lezioniDAO.aggiornastato(prenotazione);
    }

    public void rifiutaRichiestaPrenotazione(PrenotazioneBean prenotazionebean) throws DatabaseNonRaggiungibileException {

        Prenotazione prenotazione = new Prenotazione(prenotazionebean);
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();

        prenotazione.setStatoPrenotazione(StatoPrenotazione.CANCELLATA);
        lezioniDAO.aggiornastato(prenotazione);

        //annullo il pagamento
        //l'annullo non è stato implementanto in quando è stato implementato un vero pagamento online
        PagamentiDAO pagamentiDAO = FactoryConfig.getDaoFactory().creaPagamentiDAO();
        pagamentiDAO.annullaPagamento(prenotazione.getLezione().getId());

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


}
