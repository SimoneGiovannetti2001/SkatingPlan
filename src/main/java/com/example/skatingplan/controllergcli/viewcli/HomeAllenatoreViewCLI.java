package com.example.skatingplan.controllergcli.viewcli;

import com.example.skatingplan.eccezioni.InputIllegaleException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class HomeAllenatoreViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private HomeAllenatoreViewCLI(){
        //non deve essere istanziata
    }

    public static int mostraOperazioni() throws IOException, InputIllegaleException {

        while (true) {
            out.println("Quale operazione vuoi eseguire?");
            out.println("1) Inserisci Evento");
            out.println("2) Gestisci eventi");
            out.println("3) Logout");

            String input = reader.readLine();

            if (input == null) continue;

            input = input.trim();
            try {
                return Integer.parseInt(input);
            }catch(NumberFormatException e){
                throw new InputIllegaleException("Input non valido, riprovare", e);
            }
        }
    }
}
