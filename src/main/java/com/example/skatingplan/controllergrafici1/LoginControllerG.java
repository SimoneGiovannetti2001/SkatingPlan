package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;


public class LoginControllerG {
    @FXML
    public Button myButtony;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label testoErrori;

    @FXML
    private void onLoginClick() {
        String pass;
        String user;
        user = userField.getText();
        pass = passField.getText();
        LoginBean loginBean = new LoginBean(user, pass);

        try{
            LoginController loginController = new LoginController();
            UtenteBean result = loginController.autenticazione(loginBean);
            if(result.getRuolo() == Role.ATLETA) {
                FxmlLoader.setPage("views1/homeatleta1-view");
            }else if(result.getRuolo() == Role.ALLENATORE) {
                FxmlLoader.setPage("views1/homeallenatore1-view");
            }else if(result.getRuolo() == Role.MANAGER) {
                FxmlLoader.setPage("views1/homemanager1-view");
            }

        }catch(SQLException e){
            testoErrori.setText("Utente o password errati");
            testoErrori.setVisible(true);
        }

    }


}