package com.example.skatingplan.controllergcli;


import com.example.skatingplan.controllerapplicativi.PrenotaController;
import com.example.skatingplan.controllergcli.viewcli.HomeAtletaViewCLI;
import com.example.skatingplan.controllergcli.viewcli.PrenotaAtletaViewCLI;
import com.example.skatingplan.model.bean.FiltriBean;
import com.example.skatingplan.model.bean.LezioneBean;
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
        PrenotaController prenotaController = new PrenotaController();

        while (continua) {
            try {

                LezioneBean lezioneScelta = scegliLezione(prenotaController);


            }catch (IllegalArgumentException e) {
                HomeAtletaViewCLI.mostraErrore(e.getMessage());
            }
        }
    }

    private static FiltriBean acquisisciFiltri(){
        LocalDate data = PrenotaAtletaViewCLI.chiediData();
        LocalTime oraInizio = PrenotaAtletaViewCLI.chiediOraInizio();
        Regione regione = PrenotaAtletaViewCLI.chiediRegione();
        return new FiltriBean(data, oraInizio, regione);
    }


    private static LezioneBean scegliLezione(PrenotaController currentController){
        boolean continua = true;
        while (continua) {
            //acqusisci filtri
            FiltriBean filtriBean = acquisisciFiltri();

            //richiedi le lezioni al controller e le stampi
            LezioniDisponibiliBean lezioniDisponibiliBean = currentController.selezionaLezioni(filtriBean);
            PrenotaAtletaViewCLI.mostraLezioni(lezioniDisponibiliBean);
            //chiedo quale lezione si voglia prenotare
            int scelta = PrenotaAtletaViewCLI.scegliLezione();

            //stampo un riepilogo della lezione
            PrenotaAtletaViewCLI.mostraRiepilogoLezione(lezioniDisponibiliBean.getLezione(scelta - 1));

            //chiedo la seconda conferma
            String conferma = PrenotaAtletaViewCLI.chiediConferma();

            if(conferma.equals("si")){
                return lezioniDisponibiliBean.getLezione(scelta-1);
            }else{
                return null;
            }
        }
        return null;
    }

}
