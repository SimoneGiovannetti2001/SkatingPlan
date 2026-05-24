package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.bean.LoginBean;
import com.example.skatingplan.controllerapplicativi.LoginController;
import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.model.bean.UtenteBean;
import com.example.skatingplan.model.enumerazioni.Role;
import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.util.Duration;



public class LoginControllerG {
    @FXML
    public Button myButtony;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private Label testoErroreLogin;

    private PauseTransition pausa;

    @FXML
    private void onLoginClick() {
        String pass;
        String user;
        user = userField.getText();
        pass = passField.getText();
        LoginBean loginBean = new LoginBean(user, pass);

        try{
            if ((user == null || user.isBlank()) && (pass == null || pass.isBlank())) {
                throw new IllegalArgumentException("Inserire nome utente e password");
            }

            if(user == null || user.isBlank()) {
                throw new IllegalArgumentException("Inserire nome utente");
            }

            if(pass == null || pass.isBlank()) {
                throw new IllegalArgumentException("Inserire password");
            }
            LoginController loginController = new LoginController();
            UtenteBean result = loginController.autenticazione(loginBean);
            if(result.getRuolo() == Role.ATLETA) {
                FxmlLoader.setPage("views1/homeatleta1-view");
            }else if(result.getRuolo() == Role.ALLENATORE) {
                FxmlLoader.setPage("views1/homeallenatore1-view");
            }else if(result.getRuolo() == Role.MANAGER) {
                FxmlLoader.setPage("views1/homemanager1-view");
            }

        }catch(CredenzialiErrateException | IllegalArgumentException | DatabaseNonRaggiungibileException | FSOperazioneExcpetion | FSNonEsistenteException loginexception){
            mostraErrore(loginexception.getMessage());
        }

    }

    public void mostraErrore(String msg) {

        testoErroreLogin.setText(msg);
        testoErroreLogin.setVisible(true);

        // se c'è già un timer attivo lo fermo
        if (pausa != null) {
            pausa.stop();
        }

        pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(e -> testoErroreLogin.setVisible(false));
        pausa.playFromStart();
    }

}