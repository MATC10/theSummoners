package org.thesummoners.model;
import org.thesummoners.DataBase.MySQLConnection;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;
import static javafx.application.Application.launch;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml")));
        Scene scene = new Scene(root, 540, 410);
        stage.setTitle("Helloooo!");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws SQLException {
        MySQLConnection mySQLConnection = new MySQLConnection();
        System.out.println("Connectado");
        launch();
    }

}
