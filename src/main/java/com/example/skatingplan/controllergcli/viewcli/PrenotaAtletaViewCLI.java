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
import static java.lang.System.out;


public class PrenotaAtletaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));


    private PrenotaAtletaViewCLI(){
        //non deve essere istanziata
    }

    public static LocalDate chiediData() throws IOException {
        out.println("Inserire la data (aaaa-mm-gg):");
        try {
            return LocalDate.parse(reader.readLine());
        }catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Data non valida (formato aaaa-mm-gg");
        }
    }

    public static LocalTime chiediOraInizio() throws IOException {
        out.println("Inserire l'ora di inizio (hh:mm): ");
        try {
            return LocalTime.parse(reader.readLine());
        }catch(DateTimeParseException e) {
            throw new IllegalArgumentException("Orario non valido (formato hh:mm)");
        }
    }

    public static Regione chiediRegione() throws IOException{
        out.println("Inserire la regione");
        String regione = reader.readLine();
        return Regione.valueOf(regione.toUpperCase());

    }

    public static void mostraLezioni(LezioniDisponibiliBean lezioni){
        for (int i = 1; i <= lezioni.lunghezza(); i++) {
            LezioneBean lezioneBean = lezioni.getLezione(i-1);
            String nomeAllenatore = lezioneBean.getAllenatore().getNome() + " " + lezioneBean.getAllenatore().getCognome();
            String indirizzo = lezioneBean.getPistaDiPattinaggio().getVia()+ " " + lezioneBean.getPistaDiPattinaggio().getCivico();
            String formato = "%-35s %-35s %-15s%n";
            out.println("*********************************** Lezione " + i + ": ********************************************");
            out.println("*******************************************************************************************");
            out.printf(formato, "Pista: " + lezioneBean.getPistaDiPattinaggio().getNome(), "Allenatore: "+ nomeAllenatore, "Data:   "+ lezioneBean.getData());
            out.printf(formato, "Indirizzo: " + indirizzo, "Qualifica:  " + lezioneBean.getAllenatore().getQualifica(), "Ora:    " + lezioneBean.getOraInizio());
            out.printf(formato, "Regione: " + lezioneBean.getPistaDiPattinaggio().getRegione(), "Costo:      " + (double)lezioneBean.getCosto(), "Durata: " + lezioneBean.getDurata());
            out.println("*******************************************************************************************");
        }
    }

    public static void mostraErrore(String string){
        out.println("Errore:" + string);
    }
}
