package com.example.skatingplan.model.dao.demo;


import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.util.ArrayList;
import java.util.List;


public class DEMOLoginDAO implements LoginDAO {
    private static final List<Utente> utenti = new ArrayList<>();

    static{
        //atleti
        utenti.add(new Utente("Simone", "Giovannetti", "simo.giova@gmail.com", Role.ATLETA, 1, "simone"));
        utenti.add(new Utente("Damiano", "Renzi", "dami.renzi@gmail.com", Role.ATLETA, 2, "damiano"));
        utenti.add(new Utente("Filippo", "Fiore", "fili.fiore@gmail.com", Role.ALLENATORE, 3, "filippo"));
        utenti.add(new Utente("Alessia", "Filippi", "ale.fili@gmail.com", Role.ALLENATORE, 4, "alessia"));

        //allenatori
        utenti.add(new Utente("Francesco", "Filippi", "fra.filippi@gmail.com", Role.ALLENATORE, 1,"francesco"));
        utenti.add(new Utente("Damiano", "Foglietta", "dam.foglietta@gmail.com", Role.ALLENATORE, 2, "damiano"));
        utenti.add(new Utente("Daniele", "Giovannini", "dan.giovannini@gmail.com", Role.ALLENATORE, 3, "daniele"));
        utenti.add(new Utente("Filippo", "Rizzo", "fil.rizzo@gmail.com", Role.ALLENATORE, 4, "filippo"));
        utenti.add(new Utente("Marcus", "Pagliari", "mar.pagliati@gmail.com", Role.ALLENATORE, 5, "marcus"));
    }

    @Override
    public Utente login(String user, String passw) {
        for (Utente utente: utenti){
            if(user.equals(utente.getNome().toLowerCase()) && passw.equals(utente.getPassw().toLowerCase())){
                return utente;
            }
        }
        return null;
    }
}
