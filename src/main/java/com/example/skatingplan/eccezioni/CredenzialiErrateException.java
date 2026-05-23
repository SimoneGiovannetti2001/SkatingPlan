package com.example.skatingplan.eccezioni;

import java.io.Serial;

public class CredenzialiErrateException extends Exception{

    @Serial
    private static final long serialVersionUID = 1L;

    public CredenzialiErrateException(String message){
        super(message);
    }

}
