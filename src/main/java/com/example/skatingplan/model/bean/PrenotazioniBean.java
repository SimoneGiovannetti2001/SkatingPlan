package com.example.skatingplan.model.bean;

import java.util.List;

public class PrenotazioniBean {

    private final List<PrenotazioneBean> listaPrenotazioni;

    public PrenotazioniBean(List<PrenotazioneBean> listaLezioniDisponibili) {
        this.listaPrenotazioni = listaLezioniDisponibili;
    }

    public PrenotazioneBean getPrenotazione(int i){
        return this.listaPrenotazioni.get(i);
    }

    public int lunghezza(){
        return listaPrenotazioni.size();
    }

}
