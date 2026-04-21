package com.example.skatingplan.model.bean;

public class EsitoPagamentoBean {
    private boolean esitoPagamento;

    public EsitoPagamentoBean(boolean esitoPagamento){
        this.esitoPagamento = esitoPagamento;
    }

    public boolean getEsitoPagamento(){
        return  this.esitoPagamento;
    }
}
