package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.enumerazioni.Livello;
import com.example.skatingplan.model.enumerazioni.Ruolo;

public class UtenteBean {

    private String nome;
    private String cognome;
    private String email;
    private int idUtente;
    private Livello livello;
    private Ruolo ruolo;

    public UtenteBean(Utente utente){
        this.nome = utente.getNome();
        this.cognome = utente.getCognome();
        this.email = utente.getEmail();
        this.idUtente = getIdUtente();
        this.ruolo = utente.getRuolo();
    }


    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCognome(String cognome){
        this.cognome = cognome;
    }
    public String getCognome(){
        return this.cognome;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public int getIdUtente() {
        return idUtente;
    }
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public Livello getLivello() {
        return livello;
    }
    public void setLivello(Livello livello) {
        this.livello = livello;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
