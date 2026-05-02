package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.model.ConnectionFactory;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DBMSLezioneDAO implements LezioniDAO {
    @Override
    public List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione) {
        try(Connection connection = ConnectionFactory.getConnection();
            CallableStatement cs = connection.prepareCall("call seleziona_lezioni(?,?,?)")){

            List<Lezione> lezioni = new ArrayList<>();
            Lezione lezione = null;

            cs.setObject(1, data);
            cs.setObject(2, oraInizio);
            cs.setString(3, regione);
            cs.execute();

            ResultSet rs = cs.getResultSet();
            //sistemare prima stored su db
            return lezioni;
        }catch(SQLException e){
            System.out.println("errore login");
        }
        return null;
    }

    @Override
    public boolean aggiornastato(StatoPrenotazione statoPrenotazione) {
        return false;
    }
}
