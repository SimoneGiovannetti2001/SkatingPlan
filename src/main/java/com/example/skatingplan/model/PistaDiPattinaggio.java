package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.TipoPavimento;

public class PistaDiPattinaggio {

    private String nome;
    private Regione regione;
    private String via;
    private String civico;
    private TipoPavimento tipoPavimento;

    public PistaDiPattinaggio(String nome, Regione regione, String via, String civico, TipoPavimento tipoPavimento){
        this.nome = nome;
        this.regione = regione;
        this.via = via;
        this.civico = civico;
        this.tipoPavimento = tipoPavimento;
    }

    public String getNome() {
        return nome;
    }

    public Regione getRegione() {
        return regione;
    }
    public String getVia(){
        return this.via;
    }
    public String getCivico() {
        return civico;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoPavimento getTipoPavimento(){
        return this.tipoPavimento;
    }

    public void setRegione(Regione regione) {
        this.regione = regione;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public void setTipoPavimento(TipoPavimento tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
    }
}
