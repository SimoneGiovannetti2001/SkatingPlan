package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.TipoPavimento;

public class PistaDiPattinaggio {

    private String via;
    private int civico;
    private TipoPavimento tipoPavimento;

    public PistaDiPattinaggio(String via, int civico, TipoPavimento tipoPavimento){
        this.via = via;
        this.civico = civico;
        this.tipoPavimento = tipoPavimento;
    }

    public String getVia(){
        return this.via;
    }
    public int getCivico() {
        return civico;
    }

    public TipoPavimento getTipoPavimento(){
        return this.tipoPavimento;
    }
}
