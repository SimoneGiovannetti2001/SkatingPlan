package com.example.skatingplan.model.dao.dbms;


import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Ruolo;

import java.sql.*;

public class DBMSLoginDAO implements LoginDAO {

    public Utente login(String user, String passw) throws CredenzialiErrateException, DatabaseNonRaggiungibileException {
        Connection connection = ConnectionFactory.getConnection();

        try(CallableStatement cs = connection.prepareCall("call login(?,?)")){
            Utente utente = null;
            cs.setString(1, user);
            cs.setString(2, passw);

            ResultSet rs = cs.executeQuery();
            if (rs.next()) {
                utente = new Utente(rs.getString(1), rs.getString(2), rs.getString(3), Ruolo.fromInt(rs.getInt(4)), rs.getInt(5), rs.getString(6));
            }

            if(utente == null){
                throw new CredenzialiErrateException("Utente o password errati");
            }else{
                ConnectionFactory.changeRole(utente.getRuolo());
                return utente;
            }

        }catch(SQLException e){
            throw new DatabaseNonRaggiungibileException("Database non raggiungibile", e);
        }
    }
}
