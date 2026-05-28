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

        PrenotaController prenotaController = new PrenotaController();

        try {

            LezioneBean lezioneScelta = scegliLezione(prenotaController);

            //registro la richiesta
            prenotaController.registraRichiestaPrenotazione(lezioneScelta);

            //richiedo come si vuole pagare

            //registro il pagamento


        }catch (IllegalArgumentException e) {
            HomeAtletaViewCLI.mostraErrore(e.getMessage());
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
        LezioneBean lezioneScelta = null;

        while (continua) {

            //acqusisci filtri
            FiltriBean filtriBean = acquisisciFiltri();

            //richiedi le lezioni al controller e le stampi
            LezioniDisponibiliBean lezioniDisponibiliBean = currentController.selezionaLezioni(filtriBean);

            lezioneScelta= confermaSceltaLezione(lezioniDisponibiliBean);

            if(lezioneScelta != null){
                //essendo stata scelta esco dal ciclo
                continua = false;
            }

        }
        return lezioneScelta;
    }

    private static LezioneBean confermaSceltaLezione(LezioniDisponibiliBean lezioniDisponibili){
        LezioneBean lezioneScelta = null;
        boolean continua = true;
        String conferma ;

        while(continua) {

            PrenotaAtletaViewCLI.mostraLezioni(lezioniDisponibili);

            //chiedo quale lezione si voglia prenotare
            int scelta = PrenotaAtletaViewCLI.scegliLezione();

            if(scelta <= lezioniDisponibili.lunghezza()){
                //stampo un riepilogo della lezione
                PrenotaAtletaViewCLI.mostraRiepilogoLezione(lezioniDisponibili.getLezione(scelta - 1));

                //chiedo la seconda conferma
                conferma = PrenotaAtletaViewCLI.chiediConferma();

                if(conferma.equals("si")){
                    lezioneScelta = lezioniDisponibili.getLezione(scelta-1);
                    continua = false;
                }

                //chiedo se si vuole cambiare filtri
                conferma = PrenotaAtletaViewCLI.chiediSeCambiareFiltri();

                //se si esco dal ciclo
                if (conferma.equals("si")){
                    continua = false;
                }
            }

        }
        return lezioneScelta;

    }

}
