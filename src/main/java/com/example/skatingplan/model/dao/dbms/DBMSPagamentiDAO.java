package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.Pagamento;
import com.example.skatingplan.model.dao.PagamentiDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


public class DBMSPagamentiDAO implements PagamentiDAO{
    @Override
    public void inserisciPagamento(Pagamento pagamento) throws DatabaseNonRaggiungibileException{
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call inserisci_pagamento(?,?,?,?,?)")){

            cs.setString(1, pagamento.getTipoPagamento().toString());
            cs.setDate(2, Date.valueOf(pagamento.getData()));
            cs.setInt(3, pagamento.getImporto());
            cs.setInt(4, pagamento.getIdLezione());
            cs.setString(5,pagamento.getStatoPagamento().toString());

            int righe = cs.executeUpdate();
            if(righe != 1){
                throw new SQLException();
            }

        }catch (SQLException e){
            throw new DatabaseNonRaggiungibileException("Database non diusponibile, riprovare in seguito",e);
        }
    }

    @Override
    public void aggiornaPagamento(Pagamento pagamento) throws DatabaseNonRaggiungibileException{
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call aggiorna_pagamento(?,?)")){

            cs.setInt(1,pagamento.getIdLezione());
            cs.setString(2, pagamento.getStatoPagamento().toString());

            if(cs.executeUpdate() != 1){
                throw new SQLException();
            }

        }catch(SQLException e){
            throw new DatabaseNonRaggiungibileException("Database non disponibile, riprovare in seguito",e);
        }
    }

    @Override
    public void annullaPagamento(int idLezione) throws DatabaseNonRaggiungibileException {
        Connection connection = ConnectionFactory.getConnection();

        try(CallableStatement cs = connection.prepareCall("call annulla_pagamento(?)")){

            cs.setInt(1,idLezione);

            if(cs.executeUpdate() != 1){
                throw new SQLException();
            }

        }catch(SQLException e){
            throw new DatabaseNonRaggiungibileException("Database non disponibile, riprovare in seguito",e);
        }
    }

}
