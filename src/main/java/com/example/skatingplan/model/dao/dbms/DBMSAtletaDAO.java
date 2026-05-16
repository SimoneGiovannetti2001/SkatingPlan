package com.example.skatingplan.model.dao.dbms;


import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.dao.AtletaDAO;
import com.example.skatingplan.model.enumerazioni.Livello;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBMSAtletaDAO implements AtletaDAO {


    @Override
    public Livello recuperaProfiloAtleta(int idUtente) {
        Connection connection = ConnectionFactory.getConnection();
        Livello livello = null;
        try(CallableStatement cs = connection.prepareCall("call recupera_profilo_atleta(?)")) {


            cs.setInt(1, idUtente);

            if(cs.execute()){
                ResultSet rs = cs.getResultSet();
                if(rs.next()){
                    livello = Livello.valueOf(rs.getString(1));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return livello;
    }
}
