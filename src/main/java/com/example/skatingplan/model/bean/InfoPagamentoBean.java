package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.TipoPagamento;

public class InfoPagamentoBean {

    private int importo;
    private int idLezione;
    private TipoPagamento tipoPagamento;
    private StatoPagamento statoPagamento;

    public InfoPagamentoBean(int importo, int idLezione){
        this.importo = importo;
        this.idLezione = idLezione;
    }

    public StatoPagamento getStatoPagamento(){
        return this.statoPagamento;
    }
    public void setStatoPagamento(StatoPagamento statoPagamento){
        this.statoPagamento = statoPagamento;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento){
        this.tipoPagamento = tipoPagamento;
    }

    public int getImporto(){
        return this.importo;
    }

    public int getIdLezione() {
        return idLezione;
    }

    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }

    public void setImporto(int importo) {
        this.importo = importo;
    }
}
