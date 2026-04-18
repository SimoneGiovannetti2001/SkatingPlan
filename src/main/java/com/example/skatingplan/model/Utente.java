package com.example.skatingplan.model;

public class Utente {

    protected String nome;
    protected String cognome;
    protected String email;
    //protected Role role;

    public Utente(String nome, String cognome, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        //this.role = role;
    }

    public String getNome(){
        return this.nome;
    }

    public String getCognome(){
        return cognome;
    }

    public String getEmail(){
        return this.email;
    }

}
