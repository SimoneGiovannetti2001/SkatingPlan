package com.example.skatingplan.controllerapplicativi;

import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.bean.*;
import com.example.skatingplan.model.dao.CreatoreFactory;
import com.example.skatingplan.model.dao.DAOFactory;
import com.example.skatingplan.utili.FactoryConfig;

import java.util.ArrayList;
import java.util.List;

public class PrenotaController {

    public LezioniDisponibiliBean selezionaLezioni(FiltriBean filtriBean){
        List<Lezione> lezioni = FactoryConfig.getDaoFactory().creaLezioniDAO().selezionaLezioni(filtriBean.getData(), filtriBean.getOraInizio(), filtriBean.getRegione().toString());

        List<LezioneBean> lezioneBeanList = new ArrayList<>();
        for(Lezione lezione : lezioni){
            lezioneBeanList.add(new LezioneBean(lezione));
        }
        return new LezioniDisponibiliBean(lezioneBeanList);
    }


    /*
    public void registraRichiestaPrenotazione(Lezione lezione){}
    */

    /*
    public EsitoPagamentoBean paga(InfoPagamentoBean infoPagamentoBean){}
    */

    /*
    public void salvaPrenotazione(Lezione lezione){}
    */

}
