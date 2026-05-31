package com.example.skatingplan.controllergcli.viewcli;

import com.example.skatingplan.eccezioni.InputIllegaleException;
import com.example.skatingplan.model.enumerazioni.TipoPagamento;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import static java.lang.System.*;

public class PagaViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private PagaViewCLI(){
        //non deve essere istanziata
    }

    public static TipoPagamento chiediTipoPagamento() throws InputIllegaleException {
        out.println("Come si vuole effettuare il pagamento? (lezione/online)");
        try {
            return TipoPagamento.valueOf(reader.readLine().toUpperCase());
        } catch (IOException e) {
            throw new InputIllegaleException("Impossibile recuperare input, riprovare", e);
        }
    }


    public static void mostraErrore(String string){
        out.println("Errore: " + string);
    }

}
