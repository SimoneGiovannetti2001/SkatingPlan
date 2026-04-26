package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

import java.sql.Time;
import java.util.Date;
import java.util.List;

public interface LezioniDAO {
    public abstract List<Lezione> selezionaLezioni(Date data, Time oraInizio);
    public abstract boolean aggiornastato(StatoPrenotazione statoPrenotazione);
}
