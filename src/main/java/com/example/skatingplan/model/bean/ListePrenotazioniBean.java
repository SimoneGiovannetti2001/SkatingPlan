package com.example.skatingplan.model.bean;


import java.util.List;

public class ListePrenotazioniBean {

    private List<PrenotazioneBean> prenotazioniRichieste;
    private List<PrenotazioneBean> prenotazioniConfermate;


    public ListePrenotazioniBean(List<PrenotazioneBean> prenotazioniConfermate, List<PrenotazioneBean> prenotazioniRichieste) {
          this.prenotazioniConfermate = prenotazioniConfermate;
          this.prenotazioniRichieste = prenotazioniRichieste;
    }

    public List<PrenotazioneBean> getPrenotazioniConfermate() {
        return prenotazioniConfermate;
    }
    public void setPrenotazioniConfermate(List<PrenotazioneBean> prenotazioniConfermate) {
        this.prenotazioniConfermate = prenotazioniConfermate;
    }

    public List<PrenotazioneBean> getPrenotazioniRichieste() {
        return prenotazioniRichieste;
    }
    public void setPrenotazioniRichieste(List<PrenotazioneBean> prenotazioniRichieste) {
        this.prenotazioniRichieste = prenotazioniRichieste;
    }
}
