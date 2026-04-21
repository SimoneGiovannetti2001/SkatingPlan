package com.example.skatingplan.controllergrafici;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;
import com.example.skatingplan.utili.AppConfig;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class SceltaModalitàControllerG {
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
        AppConfig.init(modalitaPersistenza.getValue(), modalitaGui.getValue());
        if(AppConfig.getInstance().getModalitaGuiCorrente()== ModalitaGui.GRAFICA){
            FxmlLoader.setPage("views/login-view");
        }else{
            FxmlLoader.setPage("views/home-view");
        }
    }



}
