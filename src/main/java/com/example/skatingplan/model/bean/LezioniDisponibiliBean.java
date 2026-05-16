package com.example.skatingplan.model.bean;

import java.util.List;

public class LezioniDisponibiliBean {
    private List<LezioneBean> listaLezioniDisponibili;

    public LezioniDisponibiliBean(List<LezioneBean> listaLezioniDisponibili) {
        this.listaLezioniDisponibili = listaLezioniDisponibili;
    }
    public LezioneBean getLezione(int i){
        return this.listaLezioniDisponibili.get(i);
     }


     public int lunghezza(){
        int lunghezza = 0;
        for (int i = 0; i < listaLezioniDisponibili.size(); i++) {
            lunghezza++;
        }
        return lunghezza;
     }
}
