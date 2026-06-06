package com.example.skatingplan.model.dao.demo;


import com.example.skatingplan.model.*;
import com.example.skatingplan.model.dao.LezioniDAO;
import com.example.skatingplan.model.enumerazioni.*;

import java.time.LocalDate;
import java.time.LocalTime;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class DEMOLezioneDAO implements LezioniDAO {
    List<Lezione> lezioniFiltrate;

    private static final List<PistaDiPattinaggio> pisteDiPattinaggio = new ArrayList<>();
    private static final List<Allenatore> allenatori = new ArrayList<>();
    private static final List<Lezione> lezioni = new ArrayList<>();
    private static final List<Prenotazione> prenotazioni = new ArrayList<>();

    static{
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Palaghiaccio Mezzaluna", Regione.LAZIO, "Via dello sport", "12", TipoPavimento.RESINA));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Ice park Re di Roma", Regione.LAZIO, "Via appia nuova", "450", TipoPavimento.PARQUET));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Olimpia Revolution", Regione.LAZIO, "Via tuscolana", "120", TipoPavimento.CEMENTO));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("Ice Arena Assago", Regione.LOMBARDIA, "Via milanofiori", "1", TipoPavimento.PARQUET));
        pisteDiPattinaggio.add(new PistaDiPattinaggio("IceLab Bergamo", Regione.ABRUZZO, "Via gramsci", "45", TipoPavimento.CEMENTO));

        allenatori.add(new Allenatore(new Utente("Francesco", "Filippi", "fra.filippi@gmail.com", Ruolo.ALLENATORE, 5,"francesco"), Qualifica.FISR2, 35));
        allenatori.add(new Allenatore(new Utente("Floriana", "Foglietta", "flo.foglietta@gmail.com", Ruolo.ALLENATORE, 6, "floriana"), Qualifica.FISR1, 40));
        allenatori.add(new Allenatore(new Utente("Daniele", "Giovannini", "dan.giovannini@gmail.com", Ruolo.ALLENATORE, 7, "daniele"), Qualifica.FISR2, 35));
        allenatori.add(new Allenatore(new Utente("Flavio", "Rizzo", "fla.rizzo@gmail.com", Ruolo.ALLENATORE, 8, "flavio"), Qualifica.FISR3,50));
        allenatori.add(new Allenatore(new Utente("Marcus", "Pagliari", "mar.pagliati@gmail.com", Ruolo.ALLENATORE, 9, "marcus"), Qualifica.FISR3,60));

        lezioni.add(new Lezione(1, pisteDiPattinaggio.get(0), allenatori.get(0), LocalDate.of(2026, Month.JULY, 10),LocalTime.of(16,30), 60, 35));
        lezioni.add(new Lezione(2, pisteDiPattinaggio.get(1), allenatori.get(1), LocalDate.of(2026, Month.JULY, 16),LocalTime.of(15,0), 120, 80));
        lezioni.add(new Lezione(3, pisteDiPattinaggio.get(2), allenatori.get(2), LocalDate.of(2026, Month.JULY, 17),LocalTime.of(17,30), 60, 35));
        lezioni.add(new Lezione(4, pisteDiPattinaggio.get(3), allenatori.get(3), LocalDate.of(2026, Month.JULY, 19),LocalTime.of(18,0), 120, 100));
        lezioni.add(new Lezione(5, pisteDiPattinaggio.get(4), allenatori.get(4), LocalDate.of(2026, Month.JULY, 20),LocalTime.of(16,0), 60, 60));
    }

    @Override
    public List<Lezione> selezionaLezioni(LocalDate data, LocalTime oraInizio, String regione) {

        lezioniFiltrate = new ArrayList<>();


        for (Lezione lezione: lezioni){
            if (lezione.getData().isEqual(data) && lezione.getOraInizio().isAfter(oraInizio.minusSeconds(1)) && lezione.getOraInizio().isBefore(oraInizio.plusHours(2).plusSeconds(1))) {
                lezioniFiltrate.add(lezione);
            }
        }


        return lezioniFiltrate;

    }

    @Override
    public void aggiornastato(int idLezione, StatoPrenotazione statoPrenotazione) {
        for (Prenotazione prenotazione: prenotazioni) {
            if ((prenotazione.getLezione().getId() == idLezione)) {
                prenotazione.setStatoPrenotazione(statoPrenotazione);
            }
        }

    }

    @Override
    public void associaAtleta(Prenotazione prenotazione) {
        for (Lezione lezione: lezioni){
            if(prenotazione.getLezione().getId() == lezione.getId()){
                Atleta atleta = prenotazione.getAtleta();
                prenotazioni.add(new Prenotazione(lezione, atleta, StatoPrenotazione.RICHIESTA));

                lezioni.remove(lezione);
                break;
            }
        }
    }

    @Override
    public List<Prenotazione> prendiLezioniRichiesteAllenatore(Utente utente) {
        List<Prenotazione> prenotazioniRichieste = new ArrayList<>();

        for(Prenotazione prenotazione: prenotazioni){
            if(prenotazione.getLezione().getAllenatore().getIdUtente() == utente.getIdUtente() && prenotazione.getStatoPrenotazione().equals(StatoPrenotazione.RICHIESTA)){
                prenotazioniRichieste.add(prenotazione);
            }
        }
        return prenotazioniRichieste;
    }

    @Override
    public List<Prenotazione> prendiLezioniConfermate(Utente utente) {
        return new ArrayList<>();
    }


}
