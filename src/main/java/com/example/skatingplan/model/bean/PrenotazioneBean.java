package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Atleta;
import com.example.skatingplan.model.PistaDiPattinaggio;
import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotazioneBean {

    private int idLezione;
    private Allenatore allenatore;
    private Atleta atleta;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;
    private PistaDiPattinaggio pistaDiPattinaggio;
    private int costo;
    private StatoPrenotazione statoPrenotazione;

    public PrenotazioneBean(Prenotazione prenotazione){
        this.idLezione = prenotazione.getLezione().getId();
        this.allenatore = prenotazione.getLezione().getAllenatore();
        this.atleta = prenotazione.getAtleta();
        this.data = prenotazione.getLezione().getData();
        this.oraInizio = prenotazione.getLezione().getOraInizio();
        this.durata = prenotazione.getLezione().getDurata();
        this.pistaDiPattinaggio = prenotazione.getLezione().getPistaDiPattinaggio();;
        this.costo = prenotazione.getLezione().getCosto();
        this.statoPrenotazione = prenotazione.getStatoPrenotazione();
    }


    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }
    public int getIdLezione() {
        return idLezione;
    }


    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }
    public Allenatore getAllenatore() {
        return allenatore;
    }

    public void setAtleta(Atleta atleta) {
        this.atleta = atleta;
    }
    public Atleta getAtleta() {
        return atleta;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalDate getData() {
        return data;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }
    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    public int getDurata() {
        return durata;
    }

    public void setPistaDiPattinaggio(PistaDiPattinaggio pistaDiPattinaggio) {
        this.pistaDiPattinaggio = pistaDiPattinaggio;
    }
    public PistaDiPattinaggio getPistaDiPattinaggio() {
        return pistaDiPattinaggio;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getCosto() {
        return costo;
    }


    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }
    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }
}
