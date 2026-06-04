package com.example.skatingplan.model.enumerazioni;



public enum Ruolo {
    ATLETA(1),
    ALLENATORE(2),
    MANAGER(3),
    LOGIN(4);


    private final int id;

    private Ruolo(int id) {
        this.id = id;
    }

    public static Ruolo fromInt(int id) {
        for (Ruolo type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        return null;
    }

    public int getId() {
        return id;
    }
}
