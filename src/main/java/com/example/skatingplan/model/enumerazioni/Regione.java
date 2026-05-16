package com.example.skatingplan.model.enumerazioni;

public enum Regione {
    ABRUZZO(1),
    BASILICATA(2),
    CALABRIA(3),
    CAMPANIA(4),
    EMILIA_ROMAGNA(5),
    FRIULI_VENEZIA_GIULIA(6),
    LAZIO(7),
    LIGURIA(8),
    LOMBARDIA(9),
    MARCHE(10),
    MOLISE(11),
    PIEMONTE(12),
    PUGLIA(13),
    SARDEGNA(14),
    SICILIA(15),
    TOSCANA(16),
    TRENTINO_ALTO_ADIGE(17),
    UMBRIA(18),
    VALLE_D_AOSTA(19),
    VENETO(20);

    private final int id;

    private Regione(int id){
        this.id = id;
    }

    public static Regione fromInt(int id){
        for(Regione type: values()){
            if (type.getId() == id){
                return type;
            }
        }
        return null;
    }

    public int getId(){
        return this.id;
    }


    @Override
    public String toString() {
        String[] parole = name().toLowerCase().split("_");
        StringBuilder risultato = new StringBuilder();

        for (String parola : parole) {
            risultato.append(Character.toUpperCase(parola.charAt(0)))
                    .append(parola.substring(1))
                    .append(" ");
        }

        return risultato.toString().trim();
    }
}
