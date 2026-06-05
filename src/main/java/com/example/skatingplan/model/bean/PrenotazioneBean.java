package com.example.skatingplan.model.bean;


import com.example.skatingplan.model.Prenotazione;
import com.example.skatingplan.model.enumerazioni.Livello;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
import com.example.skatingplan.model.enumerazioni.TipoPavimento;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrenotazioneBean {

    private int idLezione;
    private String nomeAllenatore;
    private String cognomeAllenatore;
    private int tariffaOraria;
    private String nomeAtleta;
    private String cognomeAtleta;
    private Livello livelloAtleta;
    private LocalDate data;
    private LocalTime oraInizio;
    private int durata;
    private String nomePista;
    private Regione regionePista;
    private String viaPista;
    private String civicoPista;
    private TipoPavimento tipoPavimentoPista;
    private int costo;
    private StatoPrenotazione statoPrenotazione;

    public PrenotazioneBean(Prenotazione prenotazione){
        this.idLezione = prenotazione.getLezione().getId();
        this.nomeAllenatore = prenotazione.getLezione().getAllenatore().getNome();
        this.cognomeAllenatore = prenotazione.getLezione().getAllenatore().getCognome();
        this.tariffaOraria = prenotazione.getLezione().getAllenatore().getTariffaOraria();
        this.nomeAtleta = prenotazione.getAtleta().getNome();
        this.cognomeAtleta = prenotazione.getAtleta().getCognome();
        this.livelloAtleta = prenotazione.getAtleta().getLivello();
        this.data = prenotazione.getLezione().getData();
        this.oraInizio = prenotazione.getLezione().getOraInizio();
        this.durata = prenotazione.getLezione().getDurata();
        this.nomePista = prenotazione.getLezione().getAllenatore().getNome();
        this.regionePista = prenotazione.getLezione().getPistaDiPattinaggio().getRegione();
        this.viaPista = prenotazione.getLezione().getPistaDiPattinaggio().getVia();
        this.civicoPista = prenotazione.getLezione().getPistaDiPattinaggio().getCivico();
        this.tipoPavimentoPista = prenotazione.getLezione().getPistaDiPattinaggio().getTipoPavimento();
        this.costo = prenotazione.getLezione().getCosto();
        this.statoPrenotazione = prenotazione.getStatoPrenotazione();
    }


    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }
    public int getIdLezione() {
        return idLezione;
    }

    public void setNomeAllenatore(String nomeAllenatore) {
        this.nomeAllenatore = nomeAllenatore;
    }
    public String getNomeAllenatore() {
        return nomeAllenatore;
    }

    public void setCognomeAllenatore(String cognomeAllenatore) {
        this.cognomeAllenatore = cognomeAllenatore;
    }
    public String getCognomeAllenatore() {
        return cognomeAllenatore;
    }

    public void setTariffaOraria(int tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }
    public int getTariffaOraria() {
        return tariffaOraria;
    }

    public void setNomeAtleta(String nomeAtleta) {
        this.nomeAtleta = nomeAtleta;
    }
    public String getNomeAtleta() {
        return nomeAtleta;
    }

    public void setCognomeAtleta(String cognomeAtleta) {
        this.cognomeAtleta = cognomeAtleta;
    }
    public String getCognomeAtleta() {
        return cognomeAtleta;
    }

    public void setLivelloAtleta(Livello livello) {
        this.livelloAtleta = livello;
    }
    public Livello getLivelloAtleta() {
        return livelloAtleta;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    public LocalDate getData() {
        return data;
    }

    public void setOraInizio(LocalTime oraInizio) {
        this.oraInizio = oraInizio;
    }
    public LocalTime getOraInizio() {
        return oraInizio;
    }

    public void setDurata(int durata) {
        this.durata = durata;
    }
    public int getDurata() {
        return durata;
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

    public void setCosto(int costo) {
        this.costo = costo;
    }
    public int getCosto() {
        return costo;
    }

    public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
        this.statoPrenotazione = statoPrenotazione;
    }
    public StatoPrenotazione getStatoPrenotazione() {
        return statoPrenotazione;
    }
}
