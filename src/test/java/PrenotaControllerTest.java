import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioniDisponibiliBean;
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


import static org.junit.jupiter.api.Assertions.assertNotNull;

class PrenotaControllerTest {

    @Test
    void testNonNull() throws SQLException, DatabaseNonRaggiungibileException, IOException {

        PrenotaController prenotaController = new PrenotaController();

        LocalDate data = LocalDate.of(2026,6,10);
        LocalTime oraInizio = LocalTime.of(14, 0);
        Regione regione = Regione.LAZIO;
        FiltriBean filtri = new FiltriBean(data, oraInizio, regione);
        FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(ModalitaPersistenza.DBMS));
        ConnectionFactory.init();
        ConnectionFactory.changeRole(Role.ATLETA);

        LezioniDisponibiliBean result = prenotaController.selezionaLezioni(filtri);

        assertNotNull(result);

    }
}