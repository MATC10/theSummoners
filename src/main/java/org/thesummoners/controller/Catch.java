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
import org.thesummoners.model.pokemon.*;
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

    @FXML
    private Label lblLevel;

    private Parent root;
    private Scene scene;
    private Stage stage;
    private Pokemon p;

    @FXML
    void initialize() throws CloneNotSupportedException {
        //AQUÍ HABRÁ UN POKEMON ALEATORIO

        File file = new File("doc/images/Pokeball.png");
        Image image = new Image(file.toURI().toString());
        imgPokeball.setImage(image);

        //FIXME AQUÍ CAMBIAR LA FOTO DEL POKEMON SEGÚN EL POKEMON QUE SEA

        Random random = new Random();
        //CLONAMOS EN p EL NUEVO POKEMON
        p = Pokedex.getPokedex().get(random.nextInt(Pokedex.getPokedex().size())).clone();

        //EL POKEMON CAPTURADO SERÁ DEL MISMO NIVEL QUE EL PRIMER POKÉMON DE NUESTRO EQUIPO
        p.adaptStatsToLevel(Trainer.getTrainer().getPokemonTeam()[0].getLevel(), p);

        File file2 = new File(p.getImage());
        Image image2 = new Image(file2.toURI().toString());
        imgPokemon.setImage(image2);

        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().pokeballCount());
        lblLevel.setText("Level: " +p.getLevel());

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

        Trainer.getTrainer().capture(p, lblText, lblPokeballs);


    }
}