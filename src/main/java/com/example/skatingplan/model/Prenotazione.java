package com.example.skatingplan.model;

import com.example.skatingplan.model.bean.PrenotazioneBean;
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

    public Prenotazione(PrenotazioneBean prenotazioneBean){
        this.statoPrenotazione = prenotazioneBean.getStatoPrenotazione();
        this.atleta = new Atleta(prenotazioneBean.getNomeAtleta(), prenotazioneBean.getCognomeAtleta(), prenotazioneBean.getLivelloAtleta());
        this.lezione = new Lezione(prenotazioneBean.getIdLezione(),
                       new PistaDiPattinaggio(prenotazioneBean.getNomePista(), prenotazioneBean.getRegionePista(), prenotazioneBean.getViaPista(), prenotazioneBean.getCivicoPista(), prenotazioneBean.getTipoPavimentoPista()),
                       new Allenatore(prenotazioneBean.getNomeAllenatore(), prenotazioneBean.getCognomeAllenatore(), prenotazioneBean.getTariffaOraria()),
                        prenotazioneBean.getData(), prenotazioneBean.getOraInizio(), prenotazioneBean.getDurata(), prenotazioneBean.getCosto());
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
