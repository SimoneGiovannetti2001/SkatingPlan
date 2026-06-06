package com.example.skatingplan.controllergrafici1;

import com.example.skatingplan.FxmlLoader;
import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.Sessione;
import com.example.skatingplan.model.bean.InfoPagamentoBean;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.TipoPagamento;
import com.example.skatingplan.utili.GestoreMessaggiGUI;
import com.example.skatingplan.utili.NavigazioneBase;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class PagaControllerG {
    @FXML
    public Button home;

    @FXML
    public Button pagaAllaLezione;

    @FXML
    public Button pagaOnline;

    @FXML
    public Label erroriLabel;

    private InfoPagamentoBean infoPagamentoBean;

    @FXML
    private void onHomeClick(){
        NavigazioneBase.home(Sessione.getSessioneCorrente().getRuolo());
    }

    public void onPagaAllaLezione() {
        infoPagamentoBean.setTipoPagamento(TipoPagamento.LEZIONE);
        infoPagamentoBean.setStatoPagamento(StatoPagamento.IN_ATTESA);
        paga();
    }

    public void onPagaOnline() {
        infoPagamentoBean.setTipoPagamento(TipoPagamento.ONLINE);
        infoPagamentoBean.setStatoPagamento(StatoPagamento.COMPLETATO);
        paga();

    }

    public void paga(){
        try {
            PrenotaController prenotaController = new PrenotaController();
            prenotaController.paga(infoPagamentoBean);
            FxmlLoader.setPage("views1/homeAtleta1-view");
        }catch (DatabaseNonRaggiungibileException e){
            GestoreMessaggiGUI.mostraErrore(erroriLabel, e.getMessage());
        }
    }

    public void setInfoPagamento(InfoPagamentoBean infoPagamentoBean){
        this.infoPagamentoBean = infoPagamentoBean;
    }


}
