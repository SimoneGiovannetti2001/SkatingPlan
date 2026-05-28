package com.example.skatingplan.controllergcli.viewcli;

import com.example.skatingplan.model.bean.LezioneBean;
import com.example.skatingplan.model.bean.LezioniDisponibiliBean;
import com.example.skatingplan.model.enumerazioni.Regione;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;


import static java.lang.System.in;
import static java.lang.System.*;


public class PrenotaAtletaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));


    private PrenotaAtletaViewCLI(){
        //non deve essere istanziata
    }

    public static LocalDate chiediData() {
        out.println("Inserire la data (aaaa-mm-gg):");
        try {
            return LocalDate.parse(reader.readLine());
        }catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Data non valida (formato aaaa-mm-gg", e);
        }catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static LocalTime chiediOraInizio() {
        out.println("Inserire l'ora di inizio (hh:mm): ");
        try {
            return LocalTime.parse(reader.readLine());
        }catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Orario non valido (formato hh:mm)", e);
        }catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static Regione chiediRegione() {
        out.println("Inserire la regione");
        try {
            return Regione.valueOf(reader.readLine().toUpperCase());
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException("Regione non valida", e);
        }catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static void mostraLezioni(LezioniDisponibiliBean lezioni){
        for (int i = 1; i <= lezioni.lunghezza(); i++) {
            LezioneBean lezioneBean = lezioni.getLezione(i-1);
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

    public static int scegliLezione(){
        out.println("Quale lezione si vuole selezionare?");
        try{
            return Integer.parseInt(reader.readLine());
        }catch (IOException e){
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
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

    public static String chiediConferma(){
        out.println("Confermi la scelta? (si/no)");
        try {
            return reader.readLine().toLowerCase();
        } catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static String chiediSeCambiareFiltri(){
        out.println("vuoi cambiare i filtri? (si/no)");
        try {
            return reader.readLine().toLowerCase();
        } catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare",e);
        }
    }

    public static void mostraErrore(String string){
        out.println("Errore: " + string);
    }
}
