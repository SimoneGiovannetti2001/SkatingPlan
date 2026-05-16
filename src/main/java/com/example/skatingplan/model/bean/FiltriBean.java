package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.enumerazioni.Regione;

import java.time.LocalDate;
import java.time.LocalTime;


public class FiltriBean {
    private LocalDate data;
    private LocalTime oraInizio;
    private Regione regione;

    public FiltriBean(LocalDate data, LocalTime oraInizio, Regione regione){
        this.data = data;
        this.oraInizio = oraInizio;
        this.regione = regione;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public Regione getRegione() {
        return regione;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }
}
