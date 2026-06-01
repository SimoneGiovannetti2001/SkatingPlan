package com.example.skatingplan.model.dao.demo;


import com.example.skatingplan.eccezioni.CredenzialiErrateException;
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
        utenti.add(new Utente("Filippo", "Fiore", "fili.fiore@gmail.com", Role.ATLETA, 3, "filippo"));
        utenti.add(new Utente("Alessia", "Filippi", "ale.fili@gmail.com", Role.ATLETA, 4, "alessia"));

        //allenatori
        utenti.add(new Utente("Francesco", "Filippi", "fra.filippi@gmail.com", Role.ALLENATORE, 4,"francesco"));
        utenti.add(new Utente("Floriana", "Foglietta", "dam.foglietta@gmail.com", Role.ALLENATORE, 6, "floriana"));
        utenti.add(new Utente("Daniele", "Giovannini", "dan.giovannini@gmail.com", Role.ALLENATORE, 7, "daniele"));
        utenti.add(new Utente("Flavio", "Rizzo", "fla.rizzo@gmail.com", Role.ALLENATORE, 8, "flavio"));
        utenti.add(new Utente("Marcus", "Pagliari", "mar.pagliati@gmail.com", Role.ALLENATORE, 9, "marcus"));

        //manager
        utenti.add(new Utente("Max", "Quirini", "max.quiri@gmail.com", Role.MANAGER, 10, "max"));
        utenti.add(new Utente("Claudio", "Gabrielli", "cla.gabri@gmail.com", Role.MANAGER, 11, "claudio"));
        utenti.add(new Utente("Laura", "Fedele", "lau.fede@gmail.com", Role.MANAGER, 12, "laura"));


    }

    @Override
    public Utente login(String user, String passw) throws CredenzialiErrateException {
        for (Utente utente: utenti){
            if(user.equals(utente.getNome().toLowerCase()) && passw.equals(utente.getPassw().toLowerCase())){
                return utente;
            }
        }
        throw new CredenzialiErrateException("Utente o password errati");
    }
}
