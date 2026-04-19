package com.example.skatingplan.controllergrafici;


import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
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
        String pass;
        String user;
        pass = passLabel.getText();
        user = userLabel.getText();
        LoginBean loginBean = new LoginBean(user, pass);

        LoginController loginController = new LoginController();

        loginController.autenticazione(loginBean);


        FxmlLoader.setPage("views/homeatleta-view");
    }

}