package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.dao.CreatoreFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;
import com.example.skatingplan.utili.FactoryConfig;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class SceltaModalitaControllerG {
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
        FactoryConfig.impostaFactory(CreatoreFactory.creaFactory(modalitaPersistenza.getValue()));
        if(modalitaGui.getValue() == ModalitaGui.TESTUALE){
            FxmlLoader.setPage("views/homeatleta-view");
        }else{
            FxmlLoader.setPage("views/login-view");
        }
    }



}
