package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

public class Prenotazione {
    private Lezione lezione;
    private Atleta atleta;
    private StatoPrenotazione statoPrenotazione = StatoPrenotazione.DISPONIBILE;


    public Prenotazione(Lezione lezione, Atleta atleta, StatoPrenotazione statoPrenotazione){
        this.lezione = lezione;
        this.atleta = atleta;
        this.statoPrenotazione = statoPrenotazione;
    }

    public Prenotazione(Lezione lezione, Atleta atletaCorrente) {
        this.lezione = lezione;
        this.atleta = atletaCorrente;
    }

    public Lezione getLezione() {
        return lezione;
    }
    public void setLezione(Lezione lezione) {
        this.lezione = lezione;
    }

    public Atleta getAtleta() {
        return atleta;
    }
    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }

    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }
    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }

}
