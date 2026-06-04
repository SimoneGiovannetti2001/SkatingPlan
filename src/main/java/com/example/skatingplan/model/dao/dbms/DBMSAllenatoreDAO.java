package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.dao.AllenatoreDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBMSAllenatoreDAO implements AllenatoreDAO {


    @Override
    public Allenatore recuperaProfiloAllenatore(int idUtente) {
        Allenatore allenatore = null;
        Connection connection = ConnectionFactory.getConnection();
        try(CallableStatement cs = connection.prepareCall("call recupera_profilo_allenatore(?)")) {

            cs.setInt(1, idUtente);

            if(cs.execute()){
                ResultSet rs = cs.getResultSet();
                if(rs.next()){
                    //sistemare
                }
            }

        } catch (SQLException _) {
            //non gestita
        }
        return allenatore;
    }

}
