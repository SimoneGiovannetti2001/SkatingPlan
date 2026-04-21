package com.example.skatingplan.model.enumerazioni;

public enum TipoPavimento {
    CEMENTO(1),
    RESINA(2),
    PARQUET(3);

    private final int id;

    private TipoPavimento(int id){
        this.id = id;
    }

    public static TipoPavimento fromInt(int id){
        for(TipoPavimento type: values()){
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
