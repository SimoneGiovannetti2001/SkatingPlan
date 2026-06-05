package com.example.skatingplan.utili;


import com.example.skatingplan.model.bean.PrenotazioneBean;
import javafx.scene.control.Label;

public class PrenotazioneViewPopolatore {

    private PrenotazioneViewPopolatore(){
        //non deve essere istanziata
    }

    public static void popolaInfoAtleta(PrenotazioneBean prenotazioneBean, Label atleta, Label livello){
        atleta.setText(prenotazioneBean.getNomeAtleta() + " " + prenotazioneBean.getCognomeAtleta());
        livello.setText(prenotazioneBean.getLivelloAtleta().toString());
    }

    public static void popolaInfoTempo(PrenotazioneBean prenotazioneBean, Label oraInizio, Label durata, Label data) {
        oraInizio.setText(prenotazioneBean.getOraInizio().toString());
        durata.setText(prenotazioneBean.getDurata() + " minuti");
        data.setText(prenotazioneBean.getData().toString());
    }

    public static void popolaInfoLuogo(PrenotazioneBean prenotazioneBean, Label pista, Label indirizzo, Label regione){
        pista.setText(prenotazioneBean.getNomePista());
        indirizzo.setText(prenotazioneBean.getViaPista() + " " + prenotazioneBean.getCivicoPista());
        regione.setText(prenotazioneBean.getRegionePista().toString());
    }
}
