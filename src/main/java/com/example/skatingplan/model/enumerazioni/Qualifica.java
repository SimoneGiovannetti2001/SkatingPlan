package com.example.skatingplan.model.enumerazioni;

public enum Qualifica {
    FISR1(1),
    FISR2(2),
    FISR3(3);

    private final int id;

    private Qualifica(int id){
        this.id = id;
    }

    public static Qualifica fromInt(int id){
        for(Qualifica type: values()){
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
