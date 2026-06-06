package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.*;
import com.example.skatingplan.model.bean.*;
import com.example.skatingplan.model.dao.AtletaDAO;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.dao.PagamentiDAO;
import com.example.skatingplan.model.enumerazioni.Livello;
import com.example.skatingplan.model.enumerazioni.StatoPagamento;
import com.example.skatingplan.model.enumerazioni.StatoPrenotazione;
import com.example.skatingplan.utili.FactoryConfig;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class PrenotaController {

    public  List<LezioneBean> selezionaLezioni(FiltriBean filtriBean) throws DatabaseNonRaggiungibileException {
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        List<Lezione> lezioni = lezioniDAO.selezionaLezioni(filtriBean.getData(), filtriBean.getOraInizio(), filtriBean.getRegione().toString());
        List<LezioneBean> lezioneBeanList = new ArrayList<>();

        for (Lezione lezione : lezioni) {
            lezioneBeanList.add(new LezioneBean(lezione));
        }
        return lezioneBeanList;
    }


    public void registraRichiestaPrenotazione(LezioneBean lezioneBean) throws DatabaseNonRaggiungibileException {
        Lezione lezione = new Lezione(lezioneBean);
        LezioniDAO lezioniDAO = FactoryConfig.getDaoFactory().creaLezioniDAO();
        Utente utenteCorrente = Sessione.getSessioneCorrente();
        AtletaDAO atletaDAO = FactoryConfig.getDaoFactory().creaAtletaDAO();
        Livello livello = atletaDAO.recuperaProfiloAtleta(utenteCorrente.getIdUtente());

        Atleta atletaCorrente = new Atleta(utenteCorrente.getNome(), utenteCorrente.getCognome(), utenteCorrente.getEmail(), utenteCorrente.getRuolo(), utenteCorrente.getIdUtente(), utenteCorrente.getPassw(), livello);
        Prenotazione prenotazione = new Prenotazione(new Lezione(lezioneBean), atletaCorrente);

        lezioniDAO.aggiornastato(lezione.getId(), StatoPrenotazione.RICHIESTA);
        prenotazione.setStatoPrenotazione(StatoPrenotazione.RICHIESTA);
        lezioniDAO.associaAtleta(prenotazione);

    }

    public void paga(InfoPagamentoBean infoPagamentoBean) throws DatabaseNonRaggiungibileException {
        //eseguo il pagamento online
        //non implementato
        LocalDate data = LocalDate.now(ZoneId.systemDefault());
        Pagamento pagamento = new Pagamento(infoPagamentoBean.getIdLezione(), infoPagamentoBean.getTipoPagamento(), infoPagamentoBean.getStatoPagamento(), infoPagamentoBean.getImporto(), data);
        creaPagamento(pagamento);
        salvaPagamento(pagamento);
    }


    private void creaPagamento(Pagamento pagamento) throws DatabaseNonRaggiungibileException {
        PagamentiDAO pagamentiDAO = FactoryConfig.getDaoFactory().creaPagamentiDAO();

        pagamentiDAO.inserisciPagamento(pagamento);

    }


    private void salvaPagamento(Pagamento pagamento) throws DatabaseNonRaggiungibileException {
        PagamentiDAO pagamentiDAO = FactoryConfig.getDaoFactory().creaPagamentiDAO();

        if (pagamento.getTipoPagamento().toString().equals("ONLINE")) {
            pagamentiDAO.aggiornaPagamento(pagamento, StatoPagamento.COMPLETATO);
        }

    }
}
