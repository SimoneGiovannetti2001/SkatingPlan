package com.example.skatingplan.controllergcli.viewcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.in;
import static java.lang.System.out;

public class PagaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private PagaViewCLI(){
        //non deve essere istanziata
    }

    public static String chiediTipoPagamento(){
        out.println("Come si vuole effettuare il pagamento? (lezione/online)");
        try {
            return reader.readLine();
        } catch (IOException e) {
            throw new IllegalArgumentException("Impossibile recuperare input, riprovare", e);
        }
    }




    public static void mostraErrore(String string){
        out.println("Errore: " + string);
    }

}
