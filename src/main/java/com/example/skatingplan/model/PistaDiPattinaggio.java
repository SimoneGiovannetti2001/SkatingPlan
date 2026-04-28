package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.TipoPavimento;

public class PistaDiPattinaggio {

    public String provincia;
    private String via;
    private int civico;
    private TipoPavimento tipoPavimento;

    public PistaDiPattinaggio(String provincia, String via, int civico, TipoPavimento tipoPavimento){
        this.provincia = provincia;
        this.via = via;
        this.civico = civico;
        this.tipoPavimento = tipoPavimento;
    }

    public String getProvincia() {
        return provincia;
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

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public void setCivico(int civico) {
        this.civico = civico;
    }

    public void setTipoPavimento(TipoPavimento tipoPavimento) {
        this.tipoPavimento = tipoPavimento;
    }
}
