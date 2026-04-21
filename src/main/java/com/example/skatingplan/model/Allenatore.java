package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Qualifica;
import com.example.skatingplan.model.enumerazioni.Role;

public class Allenatore extends Utente{

    private Qualifica qualifica;

    public Allenatore(String nome, String cognome, String email, Role role, Qualifica qualifica){
        super(nome, cognome, email, role);
        this.qualifica = qualifica;
    }

    public Qualifica getQualifica(){
        return this.qualifica;
    }

    public void setQualifica(Qualifica newQualifica){
        this.qualifica = newQualifica;
    }

}
