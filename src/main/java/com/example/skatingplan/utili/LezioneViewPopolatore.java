package com.example.skatingplan.utili;

import com.example.skatingplan.model.bean.LezioneBean;
import javafx.scene.control.Label;


public class LezioneViewPopolatore {

    private LezioneViewPopolatore(){
        //Non va istanziato
    }

    public static void popola(
            LezioneBean lezioneBean,
            Label oraInizio,
            Label durata,
            Label allenatore,
            Label pista,
            Label indirizzo,
            Label data,
            Label regione,
            Label qualifica,
            Label costo) {
        oraInizio.setText(lezioneBean.getOraInizio().toString());
        durata.setText(lezioneBean.getDurata() + " minuti");
        allenatore.setText(lezioneBean.getAllenatore().getNome() + " " + lezioneBean.getAllenatore().getCognome());
        pista.setText(lezioneBean.getPistaDiPattinaggio().getNome());
        indirizzo.setText(lezioneBean.getPistaDiPattinaggio().getVia() + " " + lezioneBean.getPistaDiPattinaggio().getCivico());
        data.setText(lezioneBean.getData().toString());
        regione.setText(lezioneBean.getPistaDiPattinaggio().getRegione().toString());
        qualifica.setText(lezioneBean.getAllenatore().getQualifica().toString());
        costo.setText(String.valueOf(lezioneBean.getCosto())+ ".00€");
    }
}
