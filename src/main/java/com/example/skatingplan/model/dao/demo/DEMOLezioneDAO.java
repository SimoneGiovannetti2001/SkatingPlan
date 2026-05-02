package com.example.skatingplan.model.dao.demo;


import com.example.skatingplan.model.Allenatore;
import com.example.skatingplan.model.Lezione;
import com.example.skatingplan.model.PistaDiPattinaggio;
import com.example.skatingplan.model.dao.DAOFactory;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.enumerazioni.*;

import java.time.LocalDate;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

public class DEMOLezioneDAO implements LezioniDAO {

    @Override
    public List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione) {
        List<Lezione> lezioniFiltrate = new ArrayList<Lezione>();
        List<PistaDiPattinaggio> pisteDiPattinaggio = new ArrayList<>();
        List<Allenatore> allenatori = new ArrayList<>();
        List<Lezione> lezioni = new ArrayList<>();

        pisteDiPattinaggio.add(new PistaDiPattinaggio("Palaghiaccio Mezzaluna", Regione.LAZIO, "via dello sport", 12, TipoPavimento.RESINA));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Ice park Re di Roma", Regione.LAZIO, "via appia nuova", 450, TipoPavimento.PARQUET));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Olimpia Revolution", Regione.LAZIO, "via tuscolana", 120, TipoPavimento.CEMENTO));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Ice Arena Assago", Regione.LOMBARDIA, "via milanofiori", 1, TipoPavimento.PARQUET));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("IceLab Bergamo", Regione.ABRUZZO, "via Gramsci", 45, TipoPavimento.CEMENTO));

        allenatori.add(new Allenatore("Francesco", "Filippi", "fra.filippi@gmail.com", Role.ALLENATORE, Qualifica.FISR2));
        allenatori.add(new Allenatore("Damiano", "Foglietta", "dam.foglietta@gmail.com", Role.ALLENATORE, Qualifica.FISR1));
        allenatori.add(new Allenatore("Daniele", "Giovannini", "dan.giovannini@gmail.com", Role.ALLENATORE, Qualifica.FISR2));
        allenatori.add(new Allenatore("Filippo", "Rizzo", "fil.rizzo@gmail.com", Role.ALLENATORE, Qualifica.FISR3));
        allenatori.add(new Allenatore("Marcus", "Pagliari", "mar.pagliati@gmail.com", Role.ALLENATORE, Qualifica.FISR3));

        lezioni.add(new Lezione(1, pisteDiPattinaggio.get(1), allenatori.get(1), LocalDate.of(2026, 7, 10),LocalTime.of(16,30), 60));
        lezioni.add(new Lezione(2, pisteDiPattinaggio.get(2), allenatori.get(2), LocalDate.of(2026, 7, 16),LocalTime.of(15,0), 120));
        lezioni.add(new Lezione(3, pisteDiPattinaggio.get(3), allenatori.get(3), LocalDate.of(2026, 7, 17),LocalTime.of(17,30), 60));
        lezioni.add(new Lezione(4, pisteDiPattinaggio.get(4), allenatori.get(4), LocalDate.of(2026, 7, 19),LocalTime.of(18,0), 120));
        lezioni.add(new Lezione(5, pisteDiPattinaggio.get(5), allenatori.get(5), LocalDate.of(2026, 7, 20),LocalTime.of(16,0), 60));

        for (int i = 0; i <5 ; i++) {
            if (lezioni.get(i).getData() == data && lezioni.get(i).getOraInizio().isAfter(oraInizio)) {
                lezioni.add(lezioni.get(i));
            }
        }


        return lezioni;


    }

    @Override
    public boolean aggiornastato(StatoPrenotazione statoPrenotazione) {
        return false;
    }
}
