package com.example.skatingplan.model.dao;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;


public interface PagamentiDAO {
    void inserisciPagamento(Pagamento pagamento) throws DatabaseNonRaggiungibileException;

    void aggiornaPagamento(Pagamento pagamento, StatoPagamento statoPagamento) throws DatabaseNonRaggiungibileException;
}
