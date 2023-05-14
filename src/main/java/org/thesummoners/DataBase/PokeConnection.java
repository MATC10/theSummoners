package org.thesummoners.DataBase;

import org.thesummoners.model.Main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;

public class PokeConnection {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/pokemon";
        String usuario = "root";
        String password = "";
        String consulta = "SELECT * FROM pokedex";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, usuario, password);
            System.out.println("Conectado");
        }
        catch (SQLException e) {
            System.out.println("Error");
        }
        catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
