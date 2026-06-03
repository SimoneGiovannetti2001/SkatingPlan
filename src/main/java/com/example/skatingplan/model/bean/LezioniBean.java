package com.example.skatingplan.model.bean;

import java.util.List;

public class LezioniBean {

    private final List<LezioneBean> listaLezioni;

    public LezioniBean(List<LezioneBean> listaLezioniDisponibili) {
        this.listaLezioni = listaLezioniDisponibili;
    }

    public LezioneBean getLezione(int i){
        return this.listaLezioni.get(i);
    }

    public int lunghezza(){
        return listaLezioni.size();
    }
}
