package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.dao.dbms.DBMSFactory;
import com.example.skatingplan.model.dao.demo.DEMOFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;

public class CreatoreFactory {
    private CreatoreFactory() {
        /* This utility class should not be instantiated */
    }

    public static DAOFactory creaFactory(ModalitaPersistenza tipoFactory){
        return switch (tipoFactory){
            case DEMO -> new DEMOFactory();
            case DBMS -> new DBMSFactory();
            case FILESYSTEM -> null;
        };
    }
}
