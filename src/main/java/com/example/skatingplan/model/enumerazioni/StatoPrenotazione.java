package com.example.skatingplan.model.enumerazioni;

public enum StatoPrenotazione {
    RICHIESTA(1),
    CONFERMATA(2),
    ANNULLATA(3),
    PAGATA(4);

    private final int id;
    private StatoPrenotazione(int id){
        this.id = id;
    }
    public static StatoPrenotazione fromInt(int id){
        for(StatoPrenotazione type: values()){
            if (type.getId() == id){
                return type;
            }
        }
        return null;
    }

    public int getId(){
        return this.id;
    }
}
