package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.movement.MovementInitializer;
import org.thesummoners.model.pokemon.Pokedex;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class Catch {

    @FXML
    private Button btnBack;

    @FXML
    private ImageView imgPokeball;

    @FXML
    private ImageView imgPokemon;

    @FXML
    private Label lblNamePokemon;

    @FXML
    private Label lblPokeballs;

    @FXML
    private Label lblText;
    private Label lblLevel;
    Pokemon venusaur = new Pokemon("Venusaur", 1);

    private Parent root;
    private Scene scene;
    private Stage stage;
    private Pokemon p;

    @FXML
    void initialize()  {
        //AQUÍ HABRÁ UN POKEMON ALEATORIO

        File file = new File("doc/images/Pokeball.png");
        Image image = new Image(file.toURI().toString());
        imgPokeball.setImage(image);

        //AQUÍ CAMBIAR LA FOTO DEL POKEMON SEGÚN EL POKEMON QUE SEA

        File file2 = new File("doc/images/venusaur.png");
        Image image2 = new Image(file2.toURI().toString());
        imgPokemon.setImage(image2);

        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().pokeballCount());
        
    }
    @FXML
    void onBackToMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void onTryCatchPokemon(MouseEvent event) throws CloneNotSupportedException {
        //EN EL PARÁMETRO LE TENEMOS QUE METER UN POKEMON DE LA LISTA DE POKEMON DE LA POKEDEX
        //TODO HAY QUE CAMBIAR EL TEXTO MOSTRADO Y ADAPTARLO AL POKEMON QUE TOQUE
        //TODO HAY QUE COMPROBAR QUE LA MECÁNICA DE CAPTURA FUNCIONE

        Trainer.getTrainer().capture(venusaur, lblText, lblPokeballs);
    }
    @FXML
    void onChangePokemon(MouseEvent event) throws CloneNotSupportedException {

        Random random = new Random();
        //AQUÍ HABRÁ UN POKEMON ALEATORIO

        //FIXME AQUÍ CAMBIAR LA FOTO DEL POKEMON SEGÚN EL POKEMON QUE SEA


        //CLONAMOS EN p EL NUEVO POKEMON
        p = (Pokemon) Pokedex.getPokedex().get(random.nextInt(Pokedex.getPokedex().size())).clone();

        //EL POKEMON CAPTURADO SERÁ DEL MISMO NIVEL QUE EL PRIMER POKÉMON DE NUESTRO EQUIPO
        p.adaptStatsToLevel(Trainer.getTrainer().getPokemonTeam()[0].getLevel(), p);

        //SE ADAPTAN LOS MOVIMIENTOS DEL POKÉMON SEGÚN EL NIVEL
        if(p.getLevel() >= 10){
            p.getLearnedMovement()[1] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+1);
            p.getLearnedMovement()[2] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+11);
            p.getLearnedMovement()[3] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+21);
        }
        else if(p.getLevel() >= 7){
            p.getLearnedMovement()[1] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+1);
            p.getLearnedMovement()[2] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+11);
        }
        else if(p.getLevel() >= 4)
            p.getLearnedMovement()[1] = (Movement) MovementInitializer.movementListFull().get(random.nextInt(10)+1);

        File file = new File(p.getImage());
        Image image = new Image(file.toURI().toString());
        imgPokemon.setImage(image);

        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().pokeballCount());
        lblLevel.setText("Level: " +p.getLevel());
        lblNamePokemon.setText("Nombre: " + p.getName());
    }
}