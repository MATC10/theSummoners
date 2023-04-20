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
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

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
    private Label lblText;
    Pokemon venusaur = new Pokemon("Venusaur", 1);

    private Parent root;
    private Scene scene;
    private Stage stage;

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
    void onTryCatchPokemon(MouseEvent event) {
        //EN EL PARÁMETRO LE TENEMOS QUE METER UN POKEMON DE LA LISTA DE POKEMON DE LA POKEDEX
        //TODO HAY QUE CAMBIAR EL TEXTO MOSTRADO Y ADAPTARLO AL POKEMON QUE TOQUE
        //TODO HAY QUE COMPROBAR QUE LA MECÁNICA DE CAPTURA FUNCIONE

        if(Trainer.getTrainer().capture(venusaur)){
            lblText.setText("¡Has capturado a Venusaur, enhorabuena!");
        }
        else lblText.setText("No capturado!");
    }
}
