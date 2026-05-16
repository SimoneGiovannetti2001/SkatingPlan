package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Qualifica;


public class Allenatore extends Utente{

    private Qualifica qualifica;

    private int tariffaOraria;

    public Allenatore(Utente utente, Qualifica qualifica, int tariffaOraria){
        super(utente.getNome(), utente.cognome, utente.getEmail(), utente.getRuolo(), utente.getIdUtente(), utente.getPassw());
        this.qualifica = qualifica;
        this.tariffaOraria = tariffaOraria;
    }

    public Allenatore(String nome, String cognome, Qualifica qualifica, int tariffaOraria){
        super(nome, cognome);
        this.qualifica = qualifica;
        this.tariffaOraria = tariffaOraria;
    }

    public Qualifica getQualifica(){
        return this.qualifica;
    }
    public void setTariffaOraria(int tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }

    public void setQualifica(Qualifica newQualifica){
        this.qualifica = newQualifica;
    }
    public int getTariffaOraria() {
        return tariffaOraria;
    }
}
