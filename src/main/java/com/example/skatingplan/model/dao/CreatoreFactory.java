package com.example.skatingplan.model.dao;

import com.example.skatingplan.model.dao.DBMS.DBMSFactory;
import com.example.skatingplan.model.dao.DEMO.DEMOFactory;
import com.example.skatingplan.model.enumerazioni.ModalitaPersistenza;

public class CreatoreFactory {
    public static DAOFactory creaFactory(ModalitaPersistenza tipoFactory){
        return switch (tipoFactory){
            case DEMO -> new DEMOFactory();
            case DBMS -> new DBMSFactory();
            case FILESYSTEM -> null;
        };
    }
}
