package org.thesummoners.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Pokeball {
    @FXML
    private ImageView imgPokeball;
    @FXML
    private ImageView imgBrillo;
    @FXML
    private ImageView imgBackground;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void initialize(){
        File file = new File("doc/images/Pokeball.png");
        Image image = new Image(file.toURI().toString());
        imgPokeball.setImage(image);

        File file1 = new File("doc/images/otherimages/brillo-removebg-preview.png");
        Image image1 = new Image(file1.toURI().toString());
        imgBrillo.setImage(image1);

        File file2 = new File("doc/images/otherimages/TheSummonersfondo.png");
        Image image2 = new Image(file2.toURI().toString());
        imgBackground.setImage(image2);
    }

    //EL PARÁMETRO DE LAS IMAGEVIEW PARA LOS MÉTODOS MOUSE DE SCENEBUILDER ES MouseEvent event Y NO ActionEvent event
    @FXML
    public void toChoosePokemon(MouseEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosePokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
