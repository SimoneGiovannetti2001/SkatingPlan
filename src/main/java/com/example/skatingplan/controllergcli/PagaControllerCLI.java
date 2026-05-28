package com.example.skatingplan.controllergcli;

import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.controllergcli.viewcli.PagaViewCLI;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.InfoPagamentoBean;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.TipoPagamento;

public class PagaControllerCLI {

    private PagaControllerCLI(){
        //non deve essere istanziata
    }

    public static void start(PrenotaController prenotaController, InfoPagamentoBean infoPagamentoBean){
        try {
            //chiedo come si vuole pagare
            TipoPagamento tipoPagamento = TipoPagamento.valueOf(PagaViewCLI.chiediTipoPagamento());

            if(tipoPagamento.equals(TipoPagamento.ONLINE)){
                infoPagamentoBean.setStatoPagamento(StatoPagamento.COMPLETATO);
                infoPagamentoBean.setTipoPagamento(TipoPagamento.ONLINE);
            }else{
                infoPagamentoBean.setStatoPagamento(StatoPagamento.IN_ATTESA);
                infoPagamentoBean.setTipoPagamento(TipoPagamento.ALLA_LEZIONE);
            }

            //creo il bean da passare
            prenotaController.paga(infoPagamentoBean);

        }catch (IllegalArgumentException e){
            PagaViewCLI.mostraErrore(e.getMessage());
        } catch (DatabaseNonRaggiungibileException e) {
            throw new RuntimeException(e);
        }
    }
}
