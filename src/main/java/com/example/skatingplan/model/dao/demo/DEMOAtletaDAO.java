package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.Atleta;


import com.example.skatingplan.model.dao.AtletaDAO;
import com.example.skatingplan.model.enumerazioni.Livello;
import com.example.skatingplan.model.enumerazioni.Ruolo;

import java.util.ArrayList;
import java.util.List;

public class DEMOAtletaDAO implements AtletaDAO {
    private static final List<Atleta> atleti = new ArrayList<>();

    static{
        atleti.add(new Atleta("Simone", "Giovannetti", "simo.giova@gmail.com", Ruolo.ATLETA, 1, "simone", Livello.AGONISMO_AVANZATO));
        atleti.add(new Atleta("Damiano", "Renzi", "dami.renzi@gmail.com", Ruolo.ATLETA, 2, "damiano", Livello.PRIMI_PASSI));
        atleti.add(new Atleta("Filippo", "Fiore", "fili.fiore@gmail.com", Ruolo.ALLENATORE, 3, "filippo", Livello.AGONISMO_BASE));
        atleti.add(new Atleta("Alessia", "Filippi", "ale.fili@gmail.com", Ruolo.ALLENATORE, 4, "alessia", Livello.PREAGONISMO_AVANZATO));
    }


    public Livello recuperaProfiloAtleta(int idUtente) {
        for (Atleta atleta: atleti){
            if (atleta.getIdUtente() == idUtente){
                return atleta.getLivello();
            }
        }
        return null;
    }
}
