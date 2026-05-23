package com.example.skatingplan.model.dao.fs;

import com.example.skatingplan.eccezioni.CredenzialiErrateException;

import com.example.skatingplan.model.Utente;
import com.example.skatingplan.model.dao.LoginDAO;
import com.example.skatingplan.model.enumerazioni.Role;

import java.io.*;

public class FSLoginDAO implements LoginDAO {
    @Override
    public Utente login(String user, String passw) throws CredenzialiErrateException{
        File file = new File("src/main/resources/com/example/skatingplan/FileSystem/Utenti.csv");
        String str;


        Utente utente = null;

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            while((str = br.readLine()) != null){
                String[] tokens = str.split(",");
                if(tokens[0].toLowerCase().equals(user) && tokens[5].equals(passw)){
                    utente = new Utente(tokens[0], tokens[1], tokens[2], Role.valueOf(tokens[3]), Integer.parseInt(tokens[4]), tokens[5]);
                }
            }
            if(utente == null){
                throw new CredenzialiErrateException("Utente o password errati");
            }

            return utente;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
