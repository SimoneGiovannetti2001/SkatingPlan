package com.example.skatingplan.utili;

import static java.lang.System.*;

public class MessaggiCLI {

    private MessaggiCLI(){
        //non deve essere istanziata
    }

    public static void mostraErrore(String string){
        out.println("Errore:" + string);
    }

    public static void mostraMessaggio(String string){
        out.println(string);
    }
}
