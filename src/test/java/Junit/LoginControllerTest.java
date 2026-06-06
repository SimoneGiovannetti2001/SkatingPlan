package Junit;

import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.dao.CreatoreFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;
import com.example.skatingplan.model.enumerazioni.Ruolo;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/* Simone Giovannetti 0293682 */

class LoginControllerTest {

    @Test
    void autenticazioneTest() throws SQLException, DatabaseNonRaggiungibileException, IOException, CredenzialiErrateException, FSOperazioneExcpetion, FSNonEsistenteException {
        LoginController loginController = new LoginController();

        //creo la connessione verso il db
        ConnectionFactory.init();
        FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(ModalitaPersistenza.DBMS));

        //creo il bean per il login
        LoginBean loginBean = new LoginBean("simone","simone");
        UtenteBean utenteBean = loginController.autenticazione(loginBean);

        //verifico che l'utente che è stato ritornato sia corretto
        assertNotNull(utenteBean);
        assertEquals(0, utenteBean.getIdUtente());
        assertEquals("Simone", utenteBean.getNome());
        assertEquals("simo.giova@gmail.com", utenteBean.getEmail());
        assertEquals(Ruolo.ATLETA, utenteBean.getRuolo());
    }
}
