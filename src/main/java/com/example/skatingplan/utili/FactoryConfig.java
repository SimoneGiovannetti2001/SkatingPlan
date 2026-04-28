package com.example.skatingplan.utili;

import com.example.skatingplan.model.dao.DAOFactory;



public class FactoryConfig {
    private FactoryConfig() {
        /* This utility class should not be instantiated */
    }


    private static DAOFactory daoFactory;

    public static void impostaFactory(DAOFactory newdaoFactory) {
        daoFactory = newdaoFactory;
    }
    public static DAOFactory getDaoFactory(){
        return daoFactory;
    }
}
