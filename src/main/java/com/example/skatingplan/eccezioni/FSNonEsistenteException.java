package com.example.skatingplan.eccezioni;

import java.io.Serial;

public class FSNonEsistenteException extends Exception{

    @Serial
    private static final long serialVersionUID = 3L;

    public FSNonEsistenteException(String message, Throwable cause) {
        super(message, cause);
    }

}
