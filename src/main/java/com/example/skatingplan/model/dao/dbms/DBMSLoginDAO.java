package com.example.skatingplan.model.dao.dbms;


import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.sql.*;

public class DBMSLoginDAO implements LoginDAO {

    public Utente login(String user, String passw) throws SQLException{
        Connection connection = ConnectionFactory.getConnection();

        try(CallableStatement cs = connection.prepareCall("call login(?,?)")){
            Utente utente = null;
            cs.setString(1, user);
            cs.setString(2, passw);

            ResultSet rs = cs.executeQuery();

            if (rs.next()) {
                utente = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), Role.fromInt(rs.getInt(4)), rs.getInt(5), rs.getString(6));
            }
            if(utente == null){
                throw new SQLException("Utente o Password errati");
            }else{
                return utente;
            }

        }catch(SQLException e){
            throw new SQLException("Utente o Password errati");
        }
    }
}
