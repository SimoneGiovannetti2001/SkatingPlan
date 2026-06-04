package com.example.skatingplan.model;


import com.example.skatingplan.model.enumerazioni.Ruolo;

public class Utente {

    protected String nome;
    protected String cognome;
    protected String email;
    protected int idUtente;
    protected Ruolo ruolo;
    private String passw;

    public Utente(String nome, String cognome, String email, Ruolo ruolo, int idUtente, String passw){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.ruolo = ruolo;
        this.idUtente = idUtente;
        this.passw = passw;
    }

    public Utente(String nome, String cognome){
        this.nome = nome;
        this.cognome = cognome;
    }



    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome(){
        return cognome;
    }
    public void setCognome(String cognome){
        this.cognome = cognome;
    }

    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }
    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public int getIdUtente() {
        return idUtente;
    }
    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public String getPassw() {
        return passw;
    }

}
