package com.example.skatingplan.model.dao.dbms;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.*;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.enumerazioni.*;
import com.example.skatingplan.utili.ConnectionFactory;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DBMSLezioneDAO implements LezioniDAO {

    @Override
    public List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione) throws DatabaseNonRaggiungibileException{
        List<Lezione> lezioni = new ArrayList<>();
        try(CallableStatement cs = getConnection().prepareCall("call seleziona_lezioni(?,?,?)")){

            Lezione lezione;

            PistaDiPattinaggio pistaDiPattinaggio;
            Allenatore allenatore;
            

            cs.setObject(1, data);
            cs.setObject(2, oraInizio);
            cs.setString(3, regione.toUpperCase());


            if(cs.execute()) {
                ResultSet rs = cs.getResultSet();
                while (rs.next()) {
                    pistaDiPattinaggio = new PistaDiPattinaggio(rs.getString(9), Regione.valueOf(rs.getString(12)), rs.getString(10), rs.getString(11), TipoPavimento.valueOf(rs.getString(13)));
                    allenatore = new Allenatore(rs.getString(5), rs.getString(6), Qualifica.valueOf(rs.getString(7)), rs.getInt(8));

                    lezione = new Lezione(rs.getInt(1), pistaDiPattinaggio, allenatore, rs.getDate(2).toLocalDate(), rs.getTime(3).toLocalTime(), rs.getInt(4), rs.getInt(14));
                    lezioni.add(lezione);

                }
            }
        }catch(SQLException e){
            throw new DatabaseNonRaggiungibileException("Database non diusponibile, riprovare in seguito",e);
        }
        return lezioni;
    }

    @Override
    public void aggiornastato(int idLezione, StatoPrenotazione statoPrenotazione) throws DatabaseNonRaggiungibileException{

        try(CallableStatement cs = getConnection().prepareCall("call cambia_stato(?,?)")) {

            cs.setInt(1, idLezione);
            cs.setString(2, statoPrenotazione.toString().toUpperCase());

            if(cs.executeUpdate() != 1){
                throw new DatabaseNonRaggiungibileException("Database non diusponibile, riprovare in seguito");
            }

        } catch (SQLException e) {
            throw new DatabaseNonRaggiungibileException("Database non diusponibile, riprovare in seguito", e);
        }

    }

    @Override
    public void associaAtleta(Prenotazione prenotazione) throws DatabaseNonRaggiungibileException{

        try(CallableStatement cs = getConnection().prepareCall("call associa_atleta(?,?)"))  {

            cs.setInt(1, prenotazione.getLezione().getId());
            cs.setInt(2, prenotazione.getAtleta().getIdUtente()); //devi avere l'id atleta


            if(cs.executeUpdate() != 1){
                throw new SQLException();
            }

        } catch (SQLException e) {
            throw new DatabaseNonRaggiungibileException("Database non diusponibile, riprovare in seguito",e);
        }
    }

    @Override
    public List<Prenotazione> prendiLezioniRichiesteAllenatore(Utente utente) throws DatabaseNonRaggiungibileException {
        List<Prenotazione> prenotazioniRichieste = new ArrayList<>();

        try(CallableStatement cs = getConnection().prepareCall("call seleziona_richieste_allenatore(?)"))  {

            //imposto l'allenatore che è quello loggato correntemente
            Allenatore allenatore = new Allenatore(Sessione.getSessioneCorrente());
            Lezione lezione;
            PistaDiPattinaggio pistaDiPattinaggio;
            Atleta atleta;
            Prenotazione prenotazione;

            cs.setInt(1, utente.getIdUtente());

            if(cs.execute()) {
                ResultSet rs = cs.getResultSet();

                while (rs.next()) {
                    //creo pista
                    pistaDiPattinaggio = new PistaDiPattinaggio(rs.getString(6),Regione.valueOf(rs.getString(9)),rs.getString(7), rs.getString(8), TipoPavimento.valueOf(rs.getString(10)));

                    //creo lezione
                    lezione = new Lezione(rs.getInt(1),pistaDiPattinaggio,allenatore, rs.getDate(2).toLocalDate(), rs.getTime(3).toLocalTime(),rs.getInt(4), rs.getInt(5));

                    //creo atleta
                    atleta = new Atleta(rs.getString(12), rs.getString(13), Livello.valueOf(rs.getString(11)));

                    //creo prenotazione
                    prenotazione = new Prenotazione(lezione, atleta);

                    prenotazioniRichieste.add(prenotazione);
                }
            }

        } catch (SQLException e) {
            throw new DatabaseNonRaggiungibileException("Database non disponibile, riprovare in seguito",e);
        }

        return prenotazioniRichieste;
    }

    @Override
    public List<Prenotazione> prendiLezioniConfermate(Utente utente) {
        return new ArrayList<>();
    }


    private Connection getConnection(){
        return ConnectionFactory.getConnection();
    }
}
