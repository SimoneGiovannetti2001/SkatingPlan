package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.bean.InfoPagamentoBean;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;

import java.sql.SQLException;

public interface PagamentiDAO {
    public abstract void inserisciPagamento(Pagamento pagamento);

    public abstract void aggiornaPagamento(Pagamento pagamento, StatoPagamento statoPagamento) throws SQLException;
}
