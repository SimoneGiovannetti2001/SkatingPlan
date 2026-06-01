package com.example.skatingplan.model.bean;

import com.example.skatingplan.model.Prenotazione;

import java.util.List;

public class ListePrenotazioniBean {

    private List<Prenotazione> prenotazioniRichieste;
    private List<Prenotazione> prenotazioniConfermate;


    public ListePrenotazioniBean(List<Prenotazione> prenotazioniConfermate, List<Prenotazione> prenotazioniRichieste) {
          this.prenotazioniConfermate = prenotazioniConfermate;
          this.prenotazioniRichieste = prenotazioniRichieste;
    }

    public List<Prenotazione> getPrenotazioniConfermate() {
        return prenotazioniConfermate;
    }
    public void setPrenotazioniConfermate(List<Prenotazione> prenotazioniConfermate) {
        this.prenotazioniConfermate = prenotazioniConfermate;
    }

    public List<Prenotazione> getPrenotazioniRichieste() {
        return prenotazioniRichieste;
    }
    public void setPrenotazioniRichieste(List<Prenotazione> prenotazioniRichieste) {
        this.prenotazioniRichieste = prenotazioniRichieste;
    }
}
