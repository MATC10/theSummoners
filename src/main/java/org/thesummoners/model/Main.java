package org.thesummoners.model;
import org.thesummoners.DataBase.PokeConnection;
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
        Scene scene = new Scene(root, 400, 440);
        stage.setTitle("Helloooo!");
        stage.setScene(scene);
        stage.show();
    }
    //PokeConnection pokeConnection = new PokeConnection();
    public static void main(String[] args) throws SQLException {
        PokeConnection pokeConnection = new PokeConnection();
        launch();
    }

    /*void launch() {
    }*/

}
