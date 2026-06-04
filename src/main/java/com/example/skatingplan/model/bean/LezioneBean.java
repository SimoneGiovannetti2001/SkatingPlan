package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.PistaDiPattinaggio;
import com.example.skatingplan.model.enumerazioni.Qualifica;


import java.time.LocalDate;
import java.time.LocalTime;

public class LezioneBean {
    private int idLezione;
    private String nomeAllenatore;
    private String cognomeAllenatore;
    private Qualifica qualifica;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;
    private PistaDiPattinaggio pistaDiPattinaggio;
    private int costo;

    public LezioneBean(Lezione lezione) {
        this.idLezione = lezione.getId();
        this.nomeAllenatore = lezione.getAllenatore().getNome();
        this.cognomeAllenatore = lezione.getAllenatore().getCognome();
        this.qualifica = lezione.getAllenatore().getQualifica();
        this.data = lezione.getData();
        this.oraInizio = lezione.getOraInizio();
        this.durata = lezione.getDurata();
        this.pistaDiPattinaggio = lezione.getPistaDiPattinaggio();
        this.costo = lezione.getCosto();
    }

    public int getIdLezione() {
        return idLezione;
    }
    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }

    public String getNomeAllenatore() {
        return nomeAllenatore;
    }
    public void setNomeAllenatore(String nomeAllenatore) {
        this.nomeAllenatore = nomeAllenatore;
    }

    public String getCognomeAllenatore() {
        return cognomeAllenatore;
    }
    public void setCognomeAllenatore(String cognomeAllenatore) {
        this.cognomeAllenatore = cognomeAllenatore;
    }

    public Qualifica getQualifica() {
        return qualifica;
    }
    public void setQualifica(Qualifica qualifica) {
        this.qualifica = qualifica;
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