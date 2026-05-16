package com.example.skatingplan.model;

import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lezione {
    private int id;
    private PistaDiPattinaggio pistaDiPattinaggio;
    private Allenatore allenatore;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;
    private int costo;

    public Lezione(int id, PistaDiPattinaggio pistaDiPattinaggio, Allenatore allenatore, LocalDate data, LocalTime oraInizio, int durata, int costo) {
        this.id = id;
        this.pistaDiPattinaggio = pistaDiPattinaggio;
        this.allenatore = allenatore;
        this.data = data;
        this.oraInizio = oraInizio;
        this.durata = durata;
        this.costo = costo;

    }

    public Lezione(LezioneBean lezioneBean) {
        this.id = lezioneBean.getIdLezione();
        this.pistaDiPattinaggio = lezioneBean.getPistaDiPattinaggio();
        this.allenatore = lezioneBean.getAllenatore();
        this.data = lezioneBean.getData();
        this.oraInizio = lezioneBean.getOraInizio();
        this.durata = lezioneBean.getDurata();
        this.costo = lezioneBean.getCosto();
    }

    public int getId() {
        return id;
    }

    public PistaDiPattinaggio getPistaDiPattinaggio() {
        return this.pistaDiPattinaggio;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public LocalDate getData() {
        return this.data;
    }

    public LocalTime getOraInizio() {
        return this.oraInizio;
    }

    public int getDurata() {
        return this.durata;
    }

    public int getCosto() {
        return costo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPistaDiPattinaggio(PistaDiPattinaggio pistaDiPattinaggio) {
        this.pistaDiPattinaggio = pistaDiPattinaggio;
    }

    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}



