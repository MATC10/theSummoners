package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;


import java.io.IOException;
import java.util.Objects;

public class ChoosePokemon {
    @FXML
    private Button btnPikachu;
    @FXML
    private Button btnBulbasaur;
    @FXML
    private Button btnSquirtle;
    @FXML
    private Button btnCharmander;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void toMainWindowPikachu(ActionEvent event) throws IOException {
        //EL MÉTODO changeDisplayName() ES PARA AÑADIR EL VALOR AL ATRIBUTO displayName
        Trainer.getTrainer().getPokemonTeam()[0] = new Pokemon("Pikachu", 1);
        //AÑADIMOS SUS IMAGENES
        Trainer.getTrainer().getPokemonTeam()[0].setImage("doc/images/Pikachu.png");
        Trainer.getTrainer().getPokemonTeam()[0].setImageBack("doc/images/spritesback/3a-b__025__xy.gif");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void toMainWindowBulbasaur(ActionEvent event) throws IOException {
        Trainer.getTrainer().getPokemonTeam()[0] = new Pokemon("Bulbasaur", 1);
        //AÑADIMOS SUS IMAGENES
        Trainer.getTrainer().getPokemonTeam()[0].setImage("doc/images/Bulbasaur.png");
        Trainer.getTrainer().getPokemonTeam()[0].setImageBack("doc/images/spritesback/3a-b__001__xy.gif");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainWindowSquirtle(ActionEvent event) throws IOException {
        Trainer.getTrainer().getPokemonTeam()[0] = new Pokemon("Squirtle", 1);
        //AÑADIMOS SUS IMAGENES
        Trainer.getTrainer().getPokemonTeam()[0].setImage("doc/images/Squirtle.png");
        Trainer.getTrainer().getPokemonTeam()[0].setImageBack("doc/images/spritesback/3a-b__007__xy.gif");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainWindowCharmander(ActionEvent event) throws IOException {
        Trainer.getTrainer().getPokemonTeam()[0] = new Pokemon("Charmander", 1);
        //AÑADIMOS SUS IMAGENES
        Trainer.getTrainer().getPokemonTeam()[0].setImage("doc/images/Charmander.png");
        Trainer.getTrainer().getPokemonTeam()[0].setImageBack("doc/images/spritesback/3a-b__004__xy.gif");

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
