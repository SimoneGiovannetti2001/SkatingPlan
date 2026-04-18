package com.example.skatingplan.model;

public class Atleta extends Utente{

    private Livello livello;

    public Atleta(String nome, String cognome, String email, Livello livello){
        super(nome, cognome, email);
        this.livello = livello;
    }

    public Livello getLivello(){
        return this.livello;
    }

    public void setLivello(Livello newLivello){
        this.livello = newLivello;
    }
}
