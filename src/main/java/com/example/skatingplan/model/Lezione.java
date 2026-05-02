package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Regione;

import java.time.LocalDate;
import java.time.LocalTime;

public class Lezione {
    private int id;
    private PistaDiPattinaggio pistaDiPattinaggio;
    private Allenatore allenatore;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;

    public Lezione(int id, PistaDiPattinaggio pistaDiPattinaggio, Allenatore allenatore, LocalDate data, LocalTime oraInizio, int durata){
        this.id = id;
        this.pistaDiPattinaggio = pistaDiPattinaggio;
        this.allenatore = allenatore;
        this.data = data;
        this.oraInizio = oraInizio;
        this.durata = durata;
    }

    public PistaDiPattinaggio getPistaDiPattinaggio(){
        return this.pistaDiPattinaggio;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public LocalDate getData(){
        return this.data;
    }

    public LocalTime getOraInizio(){
        return this.oraInizio;
    }

    public int getDurata(){
        return this.durata;
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
}
