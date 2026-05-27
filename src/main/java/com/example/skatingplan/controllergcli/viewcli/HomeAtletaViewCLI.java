package com.example.skatingplan.controllergcli.viewcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;
import static java.lang.System.in;

public class HomeAtletaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private HomeAtletaViewCLI(){
        //non deve essere istanziata
    }

    public static int mostraOperazioni() throws IOException {

        while (true) {
            out.println("Quale operazione vuoi eseguire?");
            out.println("1)Prenota lezione");
            out.println("2)Gestisci prenotazioni");
            out.println("3)Logout");

            String input = reader.readLine();

            if (input == null) continue;

            input = input.trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                out.println("Errore: devi inserire un numero valido.");
            }
        }
    }

    public static void mostraErrore(String string){
        out.println("Errore:" + string);
    }

}
