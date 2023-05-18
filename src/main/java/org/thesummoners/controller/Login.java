package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.thesummoners.DataBase.PokemonCRUD;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class Login {
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
    public void Login(ActionEvent event) throws IOException {
        if (txtUser.getText().equals(Trainer.getTrainer().getName()) && txtPass.getText().equals(Trainer.getTrainer().getPassword())) {
            lblStatus.setText("Conectado");
            lblStatus.setTextFill(Color.GREEN);

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ProfessorOak.fxml")));
            scene = new Scene(root, 600, 400);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
        } else lblConnectedOrNot.setText("Usuario o Contrasena Incorrectos ");
    }

    public void hlRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Register.fxml")));
        scene = new Scene(root, 540, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

   /* public void initialize() throws CloneNotSupportedException {
//TRAIGO LOS POKEMON DE LA POKEDEX
        LinkedList<Pokemon> miLista = (LinkedList<Pokemon>) PokemonCRUD.readPokemon();
        for (Pokemon p : miLista) {
            Pokedex.getPokedex().add(p);
        }


        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> miListaTeam = (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for (int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < miListaTeam.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = miListaTeam.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc = (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

    }*/
}
