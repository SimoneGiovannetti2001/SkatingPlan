package com.example.skatingplan.eccezioni;

public class DatabaseNonRaggiungibileException extends Exception {

    public DatabaseNonRaggiungibileException(String message){
        super(message);
    }

    public DatabaseNonRaggiungibileException(String message, Throwable cause){
        super(message, cause);
    }

}
