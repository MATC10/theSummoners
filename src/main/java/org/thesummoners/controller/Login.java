package org.thesummoners.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.thesummoners.bd.MySQLConnection;
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Objects;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblConnectedOrNot;
    @FXML
    private Hyperlink hlRegister;

    private Parent root;
    private Scene scene;
    private Stage stage;


    @FXML
    public void login(ActionEvent event) throws IOException {
        //Si el el usuario es el mismo que el nombre del Trainer registrado anteriormente y que la contraseña del
        //Trainer, entonces puede acceder al MainWindow

        if(txtUser.getText().equals(Trainer.getTrainer().getName()) && txtPass.getText().equals(Trainer.getTrainer().getPassword())){
            lblStatus.setText("Conectado");
            lblStatus.setTextFill(Color.GREEN);

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProfessorOak.fxml")));
            scene = new Scene(root, 600, 400);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
            }
        else lblConnectedOrNot.setText("Usuario o contraseña incorrectos");
    }

    public void hlRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Register.fxml")));
        scene = new Scene(root, 400, 440);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pokedex.setPokedex((ObservableList<Pokemon>) PokemonCRUD.readPokemon());
    }
}
