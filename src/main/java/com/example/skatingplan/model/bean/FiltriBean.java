package com.example.skatingplan.model.bean;

import java.sql.Time;
import java.util.Date;

public class FiltriBean {
    private Date data;
    private Time oraInizio;
    private String provincia;

    public FiltriBean(Date data, Time oraInizio, String provincia){
        this.data = data;
        this.oraInizio = oraInizio;
        this.provincia = provincia;
    }

    public Date getData() {
        return data;
    }

    public Time getOraInizio() {
        return oraInizio;
    }

    public String getProvincia() {
        return provincia;
    }
}
