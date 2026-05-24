package com.example.skatingplan.utili;


import com.example.skatingplan.eccezioni.DatabaseNonRaggiungibileException;
import com.example.skatingplan.model.enumerazioni.Role;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
    private static Connection connection;

    private ConnectionFactory() {
        //non deve essere istanziata
    }

    public static void init()
            throws SQLException, IOException, DatabaseNonRaggiungibileException {

        try (InputStream input =
                     new FileInputStream("src/main/jdbc/db.properties")) {

            Properties properties = new Properties();
            properties.load(input);

            String url = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty("LOGIN_USER");
            String pass = properties.getProperty("LOGIN_PASS");

            connection = DriverManager.getConnection(url, user, pass);

        } catch (IOException | SQLException e) {
            throw new DatabaseNonRaggiungibileException("Database non raggiungibile");
        }
    }

    public static Connection getConnection() {
        return connection;
    }


    public static void changeRole(Role role) throws DatabaseNonRaggiungibileException {


        try (InputStream input = new FileInputStream("src/main/jdbc/db.properties")) {
            Properties properties = new Properties();
            properties.load(input);

            String connectionUrl = properties.getProperty("CONNECTION_URL");
            String user = properties.getProperty(role.name() + "_USER");
            String pass = properties.getProperty(role.name() + "_PASS");

            connection.close();

            connection = DriverManager.getConnection(connectionUrl, user,pass);

        } catch (IOException | SQLException e) {
            throw new DatabaseNonRaggiungibileException("Errore di comunicazione con il database, riprovare in seguito", e);
        }
    }

}
