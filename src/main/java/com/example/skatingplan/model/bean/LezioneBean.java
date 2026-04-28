package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.PistaDiPattinaggio;
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

    public LezioneBean(Lezione lezione, PistaDiPattinaggio pistaDiPattinaggio){
        this.allenatore = lezione.getAllenatore();
        this.data = lezione.getData();
        this.oraInizio = lezione.getOraInizio();
        this.durata = lezione.getDurata();
        this.provincia = pistaDiPattinaggio.getProvincia();
        this.via = pistaDiPattinaggio.getVia();
        this.civico = pistaDiPattinaggio.getCivico();
        this.tipoPavimento = pistaDiPattinaggio.getTipoPavimento();
    }

    public Allenatore getAllenatore() {
        return allenatore;
    }
    public void setAllenatore(Allenatore allenatore) {
        this.allenatore = allenatore;
    }
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public void setOraInizio(Time oraInizio) {
        this.oraInizio = oraInizio;
    }

    public int getDurata() {
        return durata;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public int getCivico() {
        return civico;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public TipoPavimento getTipoPavimento() {
        return tipoPavimento;
    }

    public void setTipoPavimento(TipoPavimento tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
    }
}
