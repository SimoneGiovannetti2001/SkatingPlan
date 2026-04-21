package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

public class Prenotazione {
    private Lezione lezione;
    private Atleta atleta;
    private StatoPrenotazione statoPrenotazione;

    public Lezione getLezione() {
        return lezione;
    }

    public Atleta getAtleta() {
        return atleta;
    }

    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }

    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }
}
