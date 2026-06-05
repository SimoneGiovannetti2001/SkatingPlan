package com.example.skatingplan.utili;


import com.example.skatingplan.model.bean.PrenotazioneBean;
import javafx.scene.control.Label;

public class PrenotazioneViewPopolatore {

    private PrenotazioneViewPopolatore(){
        //non deve essere istanziata
    }

    public static void popolaInfoAtleta(PrenotazioneBean prenotazioneBean, Label atleta, Label livello){
        atleta.setText(prenotazioneBean.getAtleta().getNome() + " " + prenotazioneBean.getAtleta().getCognome());
        livello.setText(prenotazioneBean.getAtleta().getLivello().toString());
    }

    public static void popolaInfoTempo(PrenotazioneBean prenotazioneBean, Label oraInizio, Label durata, Label data) {
        oraInizio.setText(prenotazioneBean.getOraInizio().toString());
        durata.setText(prenotazioneBean.getDurata() + " minuti");
        data.setText(prenotazioneBean.getData().toString());
    }

    public static void popolaInfoLuogo(PrenotazioneBean prenotazioneBean, Label pista, Label indirizzo, Label regione){
        pista.setText(prenotazioneBean.getPistaDiPattinaggio().getNome());
        indirizzo.setText(prenotazioneBean.getPistaDiPattinaggio().getVia() + " " + prenotazioneBean.getPistaDiPattinaggio().getCivico());
        regione.setText(prenotazioneBean.getPistaDiPattinaggio().getRegione().toString());
    }
}
