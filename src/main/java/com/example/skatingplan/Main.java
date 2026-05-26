package com.example.skatingplan;


import com.example.skatingplan.controllergcli.NavigatoreControllerCLI;
import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.utili.ConnectionFactory;
import com.example.skatingplan.utili.ModalitaUIConfig;
import javafx.application.Application;

import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FxmlLoader fxmlLoader = new FxmlLoader();
        fxmlLoader.start(stage);
    }

    public static void main(String[] args) {
        launch();
        if(ModalitaUIConfig.getModalita() == ModalitaGui.CLI){
            NavigatoreControllerCLI.start();
        }

    }
}