package com.example.skatingplan.model;

public class Allenatore extends Utente{

    private Qualifica qualifica;

    public Allenatore(String nome, String cognome, String email, Qualifica qualifica){
        super(nome, cognome, email);
        this.qualifica = qualifica;
    }

    public Qualifica getQualifica(){
        return this.qualifica;
    }

    public void setQualifica(Qualifica newQualifica){
        this.qualifica = newQualifica;
    }

}
