package com.example.skatingplan.eccezioni;

import java.io.Serial;

public class InputIllegaleException extends  Exception{

    @Serial
    private static final long serialVersionUID = 4L;

    public InputIllegaleException(String message) {
        super(message);
    }

    public InputIllegaleException(String message, Throwable cause) {
        super(message, cause);
    }
}
