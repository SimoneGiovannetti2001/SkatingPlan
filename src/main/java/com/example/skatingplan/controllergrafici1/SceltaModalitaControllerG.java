package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.dao.CreatoreFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.FactoryConfig;
import com.example.skatingplan.utili.GestoreMessaggiUI;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.sql.SQLException;

public class SceltaModalitaControllerG {
    @FXML
    public Button conferma;

    @FXML
    public Label errorLabel;

    @FXML
    private ComboBox<ModalitaPersistenza> modalitaPersistenza;

    @FXML
    private ComboBox<ModalitaGui> modalitaGui;

    @FXML
    public void initialize() {
        modalitaPersistenza.getItems().addAll(ModalitaPersistenza.values());
        modalitaGui.getItems().addAll(ModalitaGui.values());
    }

    @FXML
    private void onConfermaClick(){
        try {
            if (modalitaPersistenza.getValue() == ModalitaPersistenza.DBMS) {
                ConnectionFactory.init();
            }
            FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(modalitaPersistenza.getValue()));
            if (modalitaGui.getValue() == ModalitaGui.GRAFICA2) {
                FxmlLoader.setPage("views2/login2-view");
            } else {
                FxmlLoader.setPage("views1/login1-view");
            }
        } catch (SQLException | DatabaseNonRaggiungibileException | IOException e) {
            GestoreMessaggiUI.mostraErrore(errorLabel, e.getMessage());
        }
    }
}
