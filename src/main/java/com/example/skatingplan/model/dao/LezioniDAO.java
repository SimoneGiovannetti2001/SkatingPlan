package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.bean.ListePrenotazioniBean;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LezioniDAO {
    List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione);

    void aggiornastato(int idLezione, StatoPrenotazione statoPrenotazione);

    void associaAtleta(Prenotazione prenotazione);

    ListePrenotazioniBean prendiLezioniRichieste(Utente utente);

    ListePrenotazioniBean prendiLezioniConfermate(Utente utente);
}
