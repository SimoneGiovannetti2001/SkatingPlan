package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.enumerazioni.TipoPavimento;

import java.sql.Time;
import java.util.Date;

public class LezioneBean {
    private Allenatore allenatore;
    private Date data;
    private Time oraInizio;
    private int durata;
    private String provincia;
    private String via;
    private int civico;
    private TipoPavimento tipoPavimento;

    public LezioneBean(Lezione lezione){
        this.allenatore = lezione.getAllenatore();
        this.data = lezione.getData();
        this.oraInizio = lezione.getOraInizio();
        this.durata = lezione.getDurata();
        this.provincia = provincia;
        this.via = via;
        this.civico = civico;
        this.tipoPavimento = tipoPavimento;
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }

    public Date getData() {
        return data;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public int getDurata() {
        return durata;
    }
    public String getProvincia() {
        return provincia;
    }

    public String getVia() {
        return via;
    }

    public int getCivico() {
        return civico;
    }

    public TipoPavimento getTipoPavimento() {
        return tipoPavimento;
    }
}
