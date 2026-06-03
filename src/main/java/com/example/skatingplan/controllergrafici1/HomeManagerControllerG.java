package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.enumerazioni.Role;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HomeManagerControllerG {


    @FXML
    public Button home;

    @FXML
    public Button logout;

    @FXML
    public Label erroriLabel;

    @FXML
    public Button gestisciEvento;

    @FXML
    public Button inserisciEvento;

    @FXML
    private void onHomeClick(){
        FxmlLoader.setPage("views1/homeManager1-view");
    }

    public void onLogoutClick() {
        try {
            //resetto la connessione per fare il login
            if(FactoryConfig.getDaoFactory() instanceof DBMSFactory){
                ConnectionFactory.changeRole(Role.LOGIN);
            }
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }
        FxmlLoader.setPage("views1/login1-view");
    }


    public void onGestisciEventoClick() {
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "Funzionalità non disponibile al momento");
    }

    public void onInserisciEventoClick() {
        GestoreMessaggiGUI.mostraErrore(erroriLabel, "Funzionalità non disponibile al momento");
    }
}
