package com.example.skatingplan.utili;

import com.example.skatingplan.model.enumerazioni.ModalitaGui;

public class ModalitaUIConfig {

    private static ModalitaGui corrente;

    private ModalitaUIConfig(){
        //non deve essere inizializzata
    }
    public static void setModalita(ModalitaGui nuovaModalitaGui){
        corrente = nuovaModalitaGui;
    }

    public static ModalitaGui getModalita(){
        return corrente;
    }
}
