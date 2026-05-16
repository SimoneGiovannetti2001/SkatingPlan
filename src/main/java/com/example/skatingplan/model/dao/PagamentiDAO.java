package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;

import java.sql.SQLException;

public interface PagamentiDAO {
    void inserisciPagamento(Pagamento pagamento);

    void aggiornaPagamento(Pagamento pagamento, StatoPagamento statoPagamento) throws SQLException;
}
