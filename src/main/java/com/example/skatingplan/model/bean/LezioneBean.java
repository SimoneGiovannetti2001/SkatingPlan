package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.PistaDiPattinaggio;


import java.time.LocalDate;
import java.time.LocalTime;

public class LezioneBean {
    private int idLezione;
    private Allenatore allenatore;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;
    private PistaDiPattinaggio pistaDiPattinaggio;

    private int costo;

    public LezioneBean(Lezione lezione) {
        this.idLezione = lezione.getId();
        this.allenatore = lezione.getAllenatore();
        this.data = lezione.getData();
        this.oraInizio = lezione.getOraInizio();
        this.durata = lezione.getDurata();
        this.pistaDiPattinaggio = lezione.getPistaDiPattinaggio();
        this.costo = lezione.getCosto();
    }

    public  LezioneBean(int idLezione){
        this.idLezione = idLezione;
    }

    public int getIdLezione() {
        return idLezione;
    }

    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public PistaDiPattinaggio getPistaDiPattinaggio() {
        return pistaDiPattinaggio;
    }

    public void setPistaDiPattinaggio(PistaDiPattinaggio pistaDiPattinaggio) {
        this.pistaDiPattinaggio = pistaDiPattinaggio;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}