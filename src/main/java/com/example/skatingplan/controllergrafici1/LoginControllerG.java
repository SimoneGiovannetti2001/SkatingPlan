package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class LoginControllerG {

    @FXML
    private TextField userLabel;

    @FXML
    private TextField passLabel;

    @FXML
    private Label testoErrori;

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
            }else if(result == Role.ALLENATORE) {
                FxmlLoader.setPage("views/homeallenatore-view");
            }else if(result == Role.MANAGER) {
                FxmlLoader.setPage("views/homemanager-view");
            } else if (result == null) {
                testoErrori.setText("Login fallito");
                testoErrori.setVisible(true);
            }

        }catch(Exception e){
            System.out.println("Errore Login");
        }

    }


}