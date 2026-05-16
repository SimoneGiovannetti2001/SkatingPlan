package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.dao.AllenatoreDAO;
import com.example.skatingplan.model.enumerazioni.Livello;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBMSAllenatoreDAO implements AllenatoreDAO {


    @Override
    public Allenatore recuperaProfiloAllenatore(int idUtente) {
        Allenatore allenatore;
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call recupera_profilo_allenatore(?)")) {

            cs.setInt(1, idUtente);

            if(cs.execute()){
                ResultSet rs = cs.getResultSet();
                if(rs.next()){
                    //
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
