package com.example.skatingplan.model;

import com.example.skatingplan.model.enumerazioni.Qualifica;
import com.example.skatingplan.model.enumerazioni.Role;

public class Allenatore extends Utente{

    private Qualifica qualifica;

    private int tariffaOraria;

    public Allenatore(String nome, String cognome, String email, Role role, int idUtente, String passw, Qualifica qualifica, int tariffaOraria){
        super(nome, cognome, email, role, idUtente, passw);
        this.qualifica = qualifica;
        this.tariffaOraria = tariffaOraria;
    }

    public Allenatore(String nome, String cognome, Qualifica qualifica, int tariffaOraria){
        super(nome, cognome);
        this.qualifica = qualifica;
        this.tariffaOraria = tariffaOraria;
    }

    public Qualifica getQualifica(){
        return this.qualifica;
    }
    public void setTariffaOraria(int tariffaOraria) {
        this.tariffaOraria = tariffaOraria;
    }

    public void setQualifica(Qualifica newQualifica){
        this.qualifica = newQualifica;
    }
    public int getTariffaOraria() {
        return tariffaOraria;
    }
}
