package com.example.skatingplan.eccezioni;

import java.io.Serial;

public class DatabaseNonRaggiungibileException extends Exception {

    @Serial
    private static final long serialVersionUID = 2L;

    public DatabaseNonRaggiungibileException(String message){
        super(message);
    }

    public DatabaseNonRaggiungibileException(String message, Throwable cause){
        super(message, cause);
    }

}
