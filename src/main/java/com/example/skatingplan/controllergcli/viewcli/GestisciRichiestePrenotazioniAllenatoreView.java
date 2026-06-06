package com.example.skatingplan.controllergcli.viewcli;

import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.bean.PrenotazioneBean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import static java.lang.System.*;

public class GestisciRichiestePrenotazioniAllenatoreView {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private GestisciRichiestePrenotazioniAllenatoreView(){
        //non deve essere istanziata
    }

    public static void mostraPrenotazioniRichieste(List<PrenotazioneBean> prenotazioniRichieste){
        for (int i = 1; i <= prenotazioniRichieste.size(); i++){
            PrenotazioneBean prenotazioneBean = prenotazioniRichieste.get(i-1);
            String nomeAtleta = prenotazioneBean.getNomeAtleta() + " " + prenotazioneBean.getCognomeAtleta();
            String indirizzo = prenotazioneBean.getViaPista()+ " " + prenotazioneBean.getCivicoPista();
            String formato = "%-35s %-35s %-15s%n";
            out.println("----------------------------------- Prenotazione " + i + ": --------------------------------------------");
            out.println("------------------------------------------------------------------------------------------------");
            out.printf(formato, "Pista: " + prenotazioneBean.getNomePista(), "Atleta: "+ nomeAtleta, "Data:   "+ prenotazioneBean.getData());
            out.printf(formato, "Indirizzo: " + indirizzo, "Livello:  " + prenotazioneBean.getLivelloAtleta(), "Ora:    " + prenotazioneBean.getOraInizio());
            out.printf(formato, "Regione: " + prenotazioneBean.getRegionePista(), " "  , "Durata: " + prenotazioneBean.getDurata() + " minuti");
            out.println("------------------------------------------------------------------------------------------------");
        }
    }

    public static int scegliPrenotazioneDaConfermare() throws InputIllegaleException {
        try{
            out.println("Scegliere una prenotazione richiesta da confermare (exit per uscire)");
            String input = reader.readLine().toLowerCase();
            if(input.equals("exit")){
                return 0;
            }else {
                return Integer.parseInt(input);
            }
        } catch (IOException e) {
            throw new InputIllegaleException("Input non valido, riprovare", e);
        }
    }

    public static int richiestaConfermaAltraLezione() throws InputIllegaleException {
        try{
            out.println("Si vuole confermare un altra prenotazione? (si/no)");
            String scelta = reader.readLine().toLowerCase();
            if(scelta.equals("si")) {
                return 1;
            }else if (scelta.equals("no")){
                return 0;
            }else{
                throw new InputIllegaleException("Scelta non valida, inserire si o no");
            }
        } catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare", e);
        }
    }
}
