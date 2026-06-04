package com.example.skatingplan.model.dao.demo;

import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.dao.AllenatoreDAO;
import com.example.skatingplan.model.enumerazioni.Qualifica;
import com.example.skatingplan.model.enumerazioni.Ruolo;

import java.util.ArrayList;
import java.util.List;

public class DEMOAllenatoreDAO implements AllenatoreDAO {
    private static final List<Allenatore> allenatori = new ArrayList<>();

    static {
        allenatori.add(new Allenatore(new Utente("Francesco", "Filippi", "fra.filippi@gmail.com", Ruolo.ALLENATORE, 5,"francesco"), Qualifica.FISR2, 35));
        allenatori.add(new Allenatore(new Utente("Damiano", "Foglietta", "dam.foglietta@gmail.com", Ruolo.ALLENATORE, 6, "damiano"), Qualifica.FISR1, 40));
        allenatori.add(new Allenatore(new Utente("Daniele", "Giovannini", "dan.giovannini@gmail.com", Ruolo.ALLENATORE, 7, "daniele"), Qualifica.FISR2, 35));
        allenatori.add(new Allenatore(new Utente("Filippo", "Rizzo", "fil.rizzo@gmail.com", Ruolo.ALLENATORE, 8, "filippo"), Qualifica.FISR3,50));
        allenatori.add(new Allenatore(new Utente("Marcus", "Pagliari", "mar.pagliati@gmail.com", Ruolo.ALLENATORE, 9, "marcus"), Qualifica.FISR3,60));
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
