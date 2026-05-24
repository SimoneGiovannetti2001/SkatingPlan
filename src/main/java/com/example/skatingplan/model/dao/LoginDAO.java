package com.example.skatingplan.model.dao;


import com.example.skatingplan.eccezioni.CredenzialiErrateException;
import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.eccezioni.FSNonEsistenteException;
import com.example.skatingplan.eccezioni.FSOperazioneExcpetion;
import com.example.skatingplan.model.Utente;

public interface LoginDAO {
    Utente login(String user, String passw) throws CredenzialiErrateException, DatabaseNonRaggiungibileException, FSNonEsistenteException, FSOperazioneExcpetion;
}
