package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.bean.ListePrenotazioniBean;

import java.util.ArrayList;
import java.util.List;

public class GestisciPrenotazioniController {

    public ListePrenotazioniBean selezionaPrenotazioni(){

        ListePrenotazioniBean listePrenotazioniBean = new ListePrenotazioniBean(null, null);

        List<Prenotazione> prenotazioniConfermate = new ArrayList<Prenotazione>();
        List<Prenotazione> prenotazioniRichieste = new ArrayList<Prenotazione>();

        //prendo la factory delle dao

        //creo la dao per le prenotazioni confermate

        //creo la dao per le prenotazioni richieste

        //eseguo l'operazione per prendere le prenotazioni su db

        //popolo le liste

        //creo il bean da ritornare

        return listePrenotazioniBean;

    }
}
