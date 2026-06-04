package com.example.skatingplan.utili;

import com.example.skatingplan.model.bean.LezioneBean;
import javafx.scene.control.Label;


public class LezioneViewPopolatore {

    private LezioneViewPopolatore(){
        //Non va istanziato
    }

    public static void popolaInfoTempo(LezioneBean lezioneBean, Label oraInizio, Label durata, Label data) {

        oraInizio.setText(lezioneBean.getOraInizio().toString());
        durata.setText(lezioneBean.getDurata() + " minuti");
        data.setText(lezioneBean.getData().toString());
    }

    public static void popolaInfoLuogo(LezioneBean lezioneBean, Label pista, Label indirizzo, Label regione){
        pista.setText(lezioneBean.getPistaDiPattinaggio().getNome());
        indirizzo.setText(lezioneBean.getPistaDiPattinaggio().getVia() + " " + lezioneBean.getPistaDiPattinaggio().getCivico());
        regione.setText(lezioneBean.getPistaDiPattinaggio().getRegione().toString());
    }


    public static void popolaInfoAllenatore(LezioneBean lezioneBean, Label allenatore, Label qualifica, Label costo){
        allenatore.setText(lezioneBean.getNomeAllenatore() + " " + lezioneBean.getCognomeAllenatore());

        qualifica.setText(lezioneBean.getQualifica().toString());
        costo.setText(String.valueOf(lezioneBean.getCosto())+ ".00€");
    }


}
