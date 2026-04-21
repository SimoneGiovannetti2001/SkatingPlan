package com.example.skatingplan.model;

import java.sql.Time;
import java.util.Date;

public class Lezione {
    private PistaDiPattinaggio pistaDiPattinaggio;
    private Allenatore allenatore;
    private Date data;
    private Time oraInizio;
    private int durata;

    public Lezione(PistaDiPattinaggio pistaDiPattinaggio, Allenatore allenatore, Date data, Time oraInizio, int durata){
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

    public Date getData(){
        return this.data;
    }

    public Time getOraInizio(){
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

    public void setData(Date data) {
        this.data = data;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
}
