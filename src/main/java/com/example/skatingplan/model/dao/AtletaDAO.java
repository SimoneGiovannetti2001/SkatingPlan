package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.Atleta;
import com.example.skatingplan.model.enumerazioni.Livello;


public interface AtletaDAO {

    Livello recuperaProfiloAtleta(int idUtente);
}
