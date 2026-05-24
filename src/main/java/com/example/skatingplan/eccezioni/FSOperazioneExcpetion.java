package com.example.skatingplan.eccezioni;

import java.io.Serial;

public class FSOperazioneExcpetion extends Exception{

    @Serial
    private static final long serialVersionUID = 4L;

    public FSOperazioneExcpetion(String message, Throwable cause) {
        super(message, cause);
    }
}
