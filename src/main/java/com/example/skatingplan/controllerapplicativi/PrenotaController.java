package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.*;
import com.example.skatingplan.model.bean.*;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.dao.PagamentiDAO;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
import com.example.skatingplan.utili.FactoryConfig;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PrenotaController {

    public LezioniDisponibiliBean selezionaLezioni(FiltriBean filtriBean){
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        List<Lezione> lezioni = lezioniDAO.selezionaLezioni(filtriBean.getData(), filtriBean.getOraInizio(), filtriBean.getRegione().toString());
        List<LezioneBean> lezioneBeanList = new ArrayList<>();

        for(Lezione lezione : lezioni){
            lezioneBeanList.add(new LezioneBean(lezione));
        }
        return new LezioniDisponibiliBean(lezioneBeanList);
    }


    public void registraRichiestaPrenotazione(LezioneBean lezioneBean){
        Lezione lezione = new Lezione(lezioneBean);
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        Utente utenteCorrente = Sessione.getSessioneCorrente();
        Atleta atletaCorrente = new Atleta(utenteCorrente.getNome(), utenteCorrente.getCognome(), utenteCorrente.getEmail(), utenteCorrente.getRuolo(), utenteCorrente.getIdUtente(), utenteCorrente.getPassw());
        Prenotazione prenotazione = new Prenotazione(new Lezione(lezioneBean), atletaCorrente);

        lezioniDAO.aggiornastato(lezione.getId(), StatoPrenotazione.RICHIESTA);
        prenotazione.setStatoPrenotazione(StatoPrenotazione.RICHIESTA);
        lezioniDAO.associaAtleta(prenotazione);

    }

    public void paga(InfoPagamentoBean infoPagamentoBean){
        //eseguo il pagamento online
        //non implementato
        Pagamento pagamento = new Pagamento(infoPagamentoBean.getIdLezione(), infoPagamentoBean.getTipoPagamento(), infoPagamentoBean.getStatoPagamento(),infoPagamentoBean.getImporto(), LocalDate.now());



















        creaPagamento(pagamento);
        salvaPrenotazione(pagamento);
    }


    private void creaPagamento(Pagamento pagamento){
        PagamentiDAO pagamentiDAO = FactoryConfig.getDaoFactory().creaPagamentiDAO();

        try {
            pagamentiDAO.inserisciPagamento(pagamento);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


    private void salvaPrenotazione(Pagamento pagamento) {
        PagamentiDAO pagamentiDAO = FactoryConfig.getDaoFactory().creaPagamentiDAO();
        try {

            if (pagamento.getTipoPagamento().toString().equals("ONLINE")) {
                pagamentiDAO.aggiornaPagamento(pagamento, StatoPagamento.COMPLETATO);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
