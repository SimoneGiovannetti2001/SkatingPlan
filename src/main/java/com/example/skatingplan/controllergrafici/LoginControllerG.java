package com.example.skatingplan.controllergrafici;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LoginControllerG {

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

        try{
            LoginController loginController = new LoginController();
            Role result = loginController.autenticazione(loginBean);
            if(result == Role.ATLETA) {
                FxmlLoader.setPage("views/homeatleta-view");
            }
        }catch(Exception e){
            System.out.println("Errore Login");
        }



    }

}