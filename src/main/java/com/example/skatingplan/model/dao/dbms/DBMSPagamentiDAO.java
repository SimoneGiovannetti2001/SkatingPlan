package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.dao.PagamentiDAO;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class DBMSPagamentiDAO implements PagamentiDAO{
    @Override
    public void inserisciPagamento(Pagamento pagamento) {
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call inserisci_pagamento(?,?,?,?,?)")){

            cs.setString(1, pagamento.getTipoPagamento().toString());
            cs.setDate(2, Date.valueOf(pagamento.getData()));
            cs.setInt(3, pagamento.getImporto());
            cs.setInt(4, pagamento.getIdLezione());
            cs.setString(5,pagamento.getStatoPagamento().toString());

            int righe = cs.executeUpdate();
            if(righe != 1){
                throw new RuntimeException();
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void aggiornaPagamento(Pagamento pagamento, StatoPagamento statoPagamento)  {
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call aggiorna_pagamento(?,?)")){

            cs.setInt(1,pagamento.getIdLezione());
            cs.setString(2, statoPagamento.toString());
            if(cs.executeUpdate() != 1){
                //vedi come gestire l'errore di salvataggio
                //lancia magri un tipo di eccezione che crei
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
