package com.example.skatingplan.utili;

import com.example.skatingplan.model.dao.DAOFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaGui;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;


public class FactoryConfig {

    private static DAOFactory daoFactory;

    public static void impostaFactory(DAOFactory newdaoFactory) {
        daoFactory = newdaoFactory;
    }
    public static DAOFactory getDaoFactory(){
        return daoFactory;
    }
}
