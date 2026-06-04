package Junit;

import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.dao.CreatoreFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;
import com.example.skatingplan.model.enumerazioni.Regione;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrenotaControllerTest {

    @Test
    void selezionaLezioniTestNotNull() throws SQLException, DatabaseNonRaggiungibileException, IOException {

        PrenotaController prenotaController = new PrenotaController();
        //imposto dei filtri validi e creo il bean
        LocalDate data = LocalDate.of(2026,Month.JUNE,28);
        LocalTime oraInizio = LocalTime.of(14, 0);
        Regione regione = Regione.LAZIO;
        FiltriBean filtri = new FiltriBean(data, oraInizio, regione);
        //imposto factory e connessione
        FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(ModalitaPersistenza.DBMS));
        ConnectionFactory.init();
        ConnectionFactory.changeRole(Role.ATLETA);
        //eseguo la selezione
        List<LezioneBean> lezioniDisponibili = prenotaController.selezionaLezioni(filtri);
        //verifico che non venga restituito null
        assertNotNull(lezioniDisponibili);

    }

    @Test
    void selezionaLezioniTestRitornoVuoto() throws SQLException, DatabaseNonRaggiungibileException, IOException {

        PrenotaController prenotaController = new PrenotaController();
        //imposto dei filtri validi ma senza lezioni disponibili e creo il bean
        LocalDate data = LocalDate.of(2026, Month.JUNE,28);
        LocalTime oraInizio = LocalTime.of(14, 0);
        Regione regione = Regione.LAZIO;
        FiltriBean filtri = new FiltriBean(data, oraInizio, regione);
        //imposto factory e connessione
        FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(ModalitaPersistenza.DBMS));
        ConnectionFactory.init();
        ConnectionFactory.changeRole(Role.ATLETA);
        //eseguo la selezione
        List<LezioneBean> lezioniDisponibili = prenotaController.selezionaLezioni(filtri);
        //verifico che venga restituita una lista vuota
       assertEquals(0, lezioniDisponibili.size());

    }


}