package com.example.skatingplan.controllergcli.viewcli;

import com.example.skatingplan.eccezioni.ExitException;
import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.enumerazioni.Regione;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;


import static java.lang.System.*;


public class PrenotaAtletaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));


    private PrenotaAtletaViewCLI(){
        //non deve essere istanziata
    }


    public static LocalDate chiediData() throws InputIllegaleException, ExitException {
        out.println("Inserire la data (aaaa-mm-gg):");
        try {
            String data = reader.readLine();
            if(data.equals("exit")) {
                throw new ExitException("Operazione annullata");
            }else{
                return LocalDate.parse(data);
            }
        }catch(DateTimeParseException e) {
            throw new InputIllegaleException("Data non valida (formato aaaa-mm-gg)", e);
        }catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static LocalTime chiediOraInizio() throws InputIllegaleException, ExitException {
        out.println("Inserire l'ora di inizio (hh:mm): ");
        try {
            String oraInizio = reader.readLine();
            if(oraInizio.equals("exit")) {
                throw new ExitException("Operazione annullata");
            }else{
                return LocalTime.parse(oraInizio);
            }
        }catch(DateTimeParseException e) {
            throw new InputIllegaleException("Orario non valido (formato hh:mm)", e);
        }catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static Regione chiediRegione() throws InputIllegaleException, ExitException {
        out.println("Inserire la regione");
        try {
            String regione = reader.readLine();
            if(regione.equals("exit")) {
                throw new ExitException("Operazione annullata");
            }else{
                return Regione.valueOf(regione);
            }
        } catch (IllegalArgumentException e){
            throw new InputIllegaleException("Regione non valida", e);
        }catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static void mostraLezioni(List<LezioneBean> lezioniBean){
        for (int i = 1; i <= lezioniBean.size(); i++) {
            LezioneBean lezioneBean = lezioniBean.get(i-1);
            String nomeAllenatore = lezioneBean.getAllenatore().getNome() + " " + lezioneBean.getAllenatore().getCognome();
            String indirizzo = lezioneBean.getPistaDiPattinaggio().getVia()+ " " + lezioneBean.getPistaDiPattinaggio().getCivico();
            String formato = "%-35s %-35s %-15s%n";
            out.println("----------------------------------- Lezione " + i + ": --------------------------------------------");
            out.println("-------------------------------------------------------------------------------------------");
            out.printf(formato, "Pista: " + lezioneBean.getPistaDiPattinaggio().getNome(), "Allenatore: "+ nomeAllenatore, "Data:   "+ lezioneBean.getData());
            out.printf(formato, "Indirizzo: " + indirizzo, "Qualifica:  " + lezioneBean.getAllenatore().getQualifica(), "Ora:    " + lezioneBean.getOraInizio());
            out.printf(formato, "Regione: " + lezioneBean.getPistaDiPattinaggio().getRegione(), "Costo:      " + (double)lezioneBean.getCosto() + "€", "Durata: " + lezioneBean.getDurata() + "minuti");
            out.println("-------------------------------------------------------------------------------------------");
        }
    }

    public static int scegliLezione() throws InputIllegaleException {
        out.println("Quale lezione si vuole selezionare?");
        try{
            return Integer.parseInt(reader.readLine());
        }catch (IOException e){
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }

    }

    public static void mostraRiepilogoLezione(LezioneBean lezioneBean){
        String delimitatore = "+---------------------------+---------------------------+---------------------------+";
        String formato = "| %-25s | %-25s | %-25s |%n";
        String nomeAllenatore = lezioneBean.getAllenatore().getNome() + " " + lezioneBean.getAllenatore().getCognome();
        String indirizzo = lezioneBean.getPistaDiPattinaggio().getVia()+ " " + lezioneBean.getPistaDiPattinaggio().getCivico();
        String costo = Double.toString(lezioneBean.getCosto());
        out.println(delimitatore);
        out.printf(formato, "Pista", "Allenatore", "Lezione");
        out.println(delimitatore);
        out.printf(formato, lezioneBean.getPistaDiPattinaggio().getNome(), nomeAllenatore, lezioneBean.getData());
        out.println(delimitatore);
        out.printf(formato, indirizzo, lezioneBean.getAllenatore().getQualifica(), lezioneBean.getOraInizio());
        out.println(delimitatore);
        out.printf(formato, lezioneBean.getPistaDiPattinaggio().getRegione(), costo + "€", lezioneBean.getDurata() + "minuti");
        out.println(delimitatore);
    }

    public static String chiediConferma() throws InputIllegaleException {
        out.println("Confermi la scelta? (si/no)");
        try {
            return reader.readLine().toLowerCase();
        } catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static String chiediSeCambiareFiltri() throws InputIllegaleException {
        out.println("vuoi cambiare i filtri? (si/no)");
        try {
            return reader.readLine().toLowerCase();
        } catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static void mostraErrore(String string){
        out.println("Errore: " + string);
    }

    public static void mostraMessaggio(String string){
        out.println(string);
    }
}
