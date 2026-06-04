package com.example.skatingplan.controllergcli.viewcli;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.System.*;

public class LoginViewCLI {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(in));

    private LoginViewCLI() {
        //Questa classe non dovrebbe essere inizializzata mai
    }

    public static String chiediNomeUtente() throws IOException {
        out.println("Inserire nome utente: ");
        return reader.readLine();
    }

    public static String chiediPassUtente() throws IOException {
        out.println("Inserire password: ");
        return reader.readLine();
    }

    public static boolean chiediSeRiloggare() throws IOException {
        while (true) {
            out.println("Si vuole rieffettuare il login? (si/no)");

            String input = reader.readLine();

            if (input == null) continue;

            switch (input.trim().toLowerCase()) {
                case "si" -> {
                    return true;
                }
                case "no" -> {
                    return false;
                }
                default -> out.println("Input non valido. Scrivere 'si' o 'no'.");
            }
        }
    }

}
