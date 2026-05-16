package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.TipoPagamento;

import java.time.LocalDate;

public class Pagamento {

    private int idLezione;
    private TipoPagamento tipoPagamento;
    private StatoPagamento statoPagamento;
    private int importo;
    private LocalDate data;

    public Pagamento(int idLezione, TipoPagamento tipoPagamento, StatoPagamento statoPagamento, int importo, LocalDate data){
        this.idLezione = idLezione;
        this.tipoPagamento = tipoPagamento;
        this.statoPagamento = statoPagamento;
        this.importo = importo;
        this.data = data;
    }

    public int getIdLezione() {
        return idLezione;
    }
    public void setIdLezione(int idLezione) {
        this.idLezione = idLezione;
    }

    public int getImporto() {
        return importo;
    }
    public void setImporto(int importo) {
        this.importo = importo;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public StatoPagamento getStatoPagamento() {
        return statoPagamento;
    }
    public void setStatoPagamento(StatoPagamento statoPagamento) {
        this.statoPagamento = statoPagamento;
    }

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }




}
