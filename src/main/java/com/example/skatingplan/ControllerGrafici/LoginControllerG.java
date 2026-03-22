package com.example.skatingplan.ControllerGrafici;


import com.example.skatingplan.FxmlLoader;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginControllerG {
    @FXML
    private Button myButtony;
    @FXML
    private TextField userLabel;

    @FXML
    private TextField passLabel;

    @FXML
    private void onLoginClick() {
        /*
        String pass;
        String user;
        pass = passLabel.getText();
        user = userLabel.getText();
        */



        FxmlLoader.setPage("views/homeatleta-view");
    }

}