package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.enumerazioni.Qualifica;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.TipoPavimento;


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
    private String nomePista;
    private Regione regionePista;
    private String viaPista;
    private String civicoPista;
    private TipoPavimento tipoPavimentoPista;
    private int costo;

    public LezioneBean(Lezione lezione) {
        this.idLezione = lezione.getId();
        this.nomeAllenatore = lezione.getAllenatore().getNome();
        this.cognomeAllenatore = lezione.getAllenatore().getCognome();
        this.qualifica = lezione.getAllenatore().getQualifica();
        this.data = lezione.getData();
        this.oraInizio = lezione.getOraInizio();
        this.durata = lezione.getDurata();
        this.nomePista = lezione.getPistaDiPattinaggio().getNome();
        this.regionePista = lezione.getPistaDiPattinaggio().getRegione();
        this.viaPista = lezione.getPistaDiPattinaggio().getVia();
        this.civicoPista = lezione.getPistaDiPattinaggio().getCivico();
        this.tipoPavimentoPista = lezione.getPistaDiPattinaggio().getTipoPavimento();
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

    public void setNomePista(String nomePista) {
        this.nomePista = nomePista;
    }
    public String getNomePista() {
        return nomePista;
    }

    public void setRegionePista(Regione regionePista) {
        this.regionePista = regionePista;
    }
    public Regione getRegionePista() {
        return regionePista;
    }

    public void setViaPista(String viaPista) {
        this.viaPista = viaPista;
    }
    public String getViaPista() {
        return viaPista;
    }

    public void setCivicoPista(String civicoPista) {
        this.civicoPista = civicoPista;
    }
    public String getCivicoPista() {
        return civicoPista;
    }


    public void setTipoPavimentoPista(TipoPavimento tipoPavimentoPista) {
        this.tipoPavimentoPista = tipoPavimentoPista;
    }
    public TipoPavimento getTipoPavimentoPista() {
        return tipoPavimentoPista;
    }

    public int getCosto() {
        return costo;
    }
    public void setCosto(int costo) {
        this.costo = costo;
    }

}