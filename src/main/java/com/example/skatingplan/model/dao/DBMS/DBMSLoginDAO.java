package com.example.skatingplan.model.dao.DBMS;

import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class DBMSLoginDAO implements LoginDAO {
    public Role login(LoginBean loginBean) throws SQLException {

        try(Connection connection = ConnectionFactory.getConnection();
            CallableStatement cs = connection.prepareCall("call login(?,?,?)")){

            int ruoloUtente;
            Role ruolo;
            cs.setString(1, loginBean.getUser());
            cs.setString(2, loginBean.getPass());
            cs.registerOutParameter(3, Types.NUMERIC);
            cs.execute();

            ruoloUtente = cs.getInt(3);
            ruolo = Role.fromInt(ruoloUtente);
            return ruolo;
        }catch(SQLException e){
            System.out.println("errore login");
        }
        return null;
    }
}
