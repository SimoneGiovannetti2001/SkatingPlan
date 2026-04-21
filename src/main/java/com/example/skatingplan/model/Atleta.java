package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Livello;
import com.example.skatingplan.model.enumerazioni.Role;

public class Atleta extends Utente{

    private Livello livello;

    public Atleta(String nome, String cognome, String email, Role role, Livello livello){
        super(nome, cognome, email, role);
        this.livello = livello;
    }

    public Livello getLivello(){
        return this.livello;
    }

    public void setLivello(Livello newLivello){
        this.livello = newLivello;
    }
}
