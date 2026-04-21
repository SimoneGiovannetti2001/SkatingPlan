package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Role;

public class Utente {

    protected String nome;
    protected String cognome;
    protected String email;
    protected Role role;

    public Utente(String nome, String cognome, String email, Role role){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.role = role;
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

    public Role getRole() {
        return role;
    }
}
