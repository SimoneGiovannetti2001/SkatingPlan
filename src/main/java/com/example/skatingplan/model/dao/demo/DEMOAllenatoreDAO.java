package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.dao.AllenatoreDAO;
import com.example.skatingplan.model.enumerazioni.Qualifica;
import com.example.skatingplan.model.enumerazioni.Role;

import java.util.ArrayList;
import java.util.List;

public class DEMOAllenatoreDAO implements AllenatoreDAO {
    private static final List<Allenatore> allenatori = new ArrayList<>();

    static {
        allenatori.add(new Allenatore("Francesco", "Filippi", "fra.filippi@gmail.com", Role.ALLENATORE, 1,"francesco", Qualifica.FISR2, 35));
        allenatori.add(new Allenatore("Damiano", "Foglietta", "dam.foglietta@gmail.com", Role.ALLENATORE, 2, "damiano", Qualifica.FISR1, 40));
        allenatori.add(new Allenatore("Daniele", "Giovannini", "dan.giovannini@gmail.com", Role.ALLENATORE, 3, "daniele", Qualifica.FISR2, 35));
        allenatori.add(new Allenatore("Filippo", "Rizzo", "fil.rizzo@gmail.com", Role.ALLENATORE, 4, "filippo", Qualifica.FISR3,50));
        allenatori.add(new Allenatore("Marcus", "Pagliari", "mar.pagliati@gmail.com", Role.ALLENATORE, 5, "marcus", Qualifica.FISR3,60));
    }

    public Allenatore recuperaProfiloAllenatore(int idUtente) {
        for(Allenatore allenatore: allenatori){
            if(allenatore.getIdUtente() == idUtente){
                return allenatore;
            }
        }
        return null;
    }
}
