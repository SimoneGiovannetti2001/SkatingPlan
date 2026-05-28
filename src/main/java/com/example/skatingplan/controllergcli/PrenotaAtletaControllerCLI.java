package com.example.skatingplan.controllergcli;


import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.controllergcli.viewcli.HomeAtletaViewCLI;
import com.example.skatingplan.controllergcli.viewcli.PrenotaAtletaViewCLI;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioniDisponibiliBean;
import com.example.skatingplan.model.enumerazioni.Regione;



import java.time.LocalDate;
import java.time.LocalTime;


public class PrenotaAtletaControllerCLI {

    private PrenotaAtletaControllerCLI(){
        //non deve essere mai istanziata
    }

    public static void start() {
        boolean continua = true;
        FiltriBean filtriBean;
        while (continua) {
            try {
                LezioniDisponibiliBean lezioniDisponibiliBean;
                LocalDate data = PrenotaAtletaViewCLI.chiediData();
                LocalTime oraInizio = PrenotaAtletaViewCLI.chiediOraInizio();
                Regione regione = PrenotaAtletaViewCLI.chiediRegione();

                PrenotaAtletaViewCLI.mostraErrore(data + ", " + oraInizio + ", " + regione.toString());
                filtriBean = new FiltriBean(data, oraInizio, regione);

                PrenotaController prenotaController = new PrenotaController();
                lezioniDisponibiliBean = prenotaController.selezionaLezioni(filtriBean);

                PrenotaAtletaViewCLI.mostraLezioni(lezioniDisponibiliBean);


            }catch (IllegalArgumentException e) {
                HomeAtletaViewCLI.mostraErrore(e.getMessage());
            }

        }
    }

}
