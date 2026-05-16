package com.example.skatingplan.model;

public class Sessione {
    private static Utente utenteCorrente;

    private Sessione(){
        //non istanziabile
    }

    public static void setSessione(Utente utente){
        utenteCorrente = utente;
    }

    public static Utente getSessioneCorrente(){
        return utenteCorrente;
    }

    public static void logout(){
        utenteCorrente = null;
    }
}
