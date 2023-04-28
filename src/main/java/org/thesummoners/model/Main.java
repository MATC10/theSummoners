package org.thesummoners.model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.sql.*;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml")));
        Scene scene = new Scene(root, 400, 440);
        stage.setTitle("Helloooo!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/pokemon";

        String usuario = "root";

        String password = "";

        String consulta = "SELECT * FROM pokedex";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(url, usuario, password);


            System.out.println("Conectado");

        } catch (SQLException e) {

            System.out.println("Error");

        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);

        }



        launch();
    }
}
