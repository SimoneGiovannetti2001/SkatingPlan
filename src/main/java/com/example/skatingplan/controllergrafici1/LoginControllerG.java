package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginControllerG {

    public Button myButtony;
    @FXML
    private TextField userField;

    @FXML
    private TextField passField;

    @FXML
    private Label testoErrori;

    @FXML
    private void onLoginClick() {
        String pass;
        String user;
        pass = userField.getText();
        user = passField.getText();
        LoginBean loginBean = new LoginBean(user, pass);

        try{
            LoginController loginController = new LoginController();
            Role result = loginController.autenticazione(loginBean);
            if(result == Role.ATLETA) {
                FxmlLoader.setPage("views1/homeatleta1-view");
            }else if(result == Role.ALLENATORE) {
                FxmlLoader.setPage("views1/homeallenatore1-view");
            }else if(result == Role.MANAGER) {
                FxmlLoader.setPage("views1/homemanager1-view");
            }

        }catch(Exception e){
            testoErrori.setText("Login fallito");
            testoErrori.setVisible(true);
        }

    }


}