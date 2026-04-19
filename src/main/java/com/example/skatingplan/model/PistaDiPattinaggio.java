package com.example.skatingplan.model;

public class PistaDiPattinaggio {

    private String via;
    private int civico;
    private TipoPavimento tipoPavimento;

    public PistaDiPattinaggio(String via, int civico, TipoPavimento tipoPavimento){
        this.via = via;
        this.civico = civico;
        this.tipoPavimento = tipoPavimento;
    }

    public TipoPavimento getTipoPavimento(){
        return this.tipoPavimento;
    }

}
