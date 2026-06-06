package com.example.skatingplan.model.dao;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.Utente;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface LezioniDAO {
    List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione) throws DatabaseNonRaggiungibileException;

    void aggiornastato(Prenotazione prenotazione) throws DatabaseNonRaggiungibileException;

    void associaAtleta(Prenotazione prenotazione) throws DatabaseNonRaggiungibileException;

    List<Prenotazione> prendiLezioniRichiesteAllenatore(Utente utente) throws DatabaseNonRaggiungibileException;

}
