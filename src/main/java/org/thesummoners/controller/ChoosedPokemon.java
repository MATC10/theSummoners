package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.thesummoners.model.Pokemon;
import org.thesummoners.model.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
public class ChoosedPokemon {
    @FXML
    private Label lblTittle;
    @FXML
    private ImageView imgPokemon;
    @FXML
    private Button btnYes;
    @FXML
    private Button btnNo;
    private Parent root;
    private Scene scene;
    private Stage stage;



    @FXML
    public void initialize(){
        lblTittle.setText("¡Buena elección! tu Pokémon es " + Trainer.getTrainer().getPokemonTeam()[0].getName());
        File file = new File(Trainer.getTrainer().getPokemonTeam()[0].getImage());
        Image image = new Image(file.toURI().toString());
        imgPokemon.setImage(image);
    }

    @FXML
    public void toChangeNickName(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChangePokemonNickName.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toContinue(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }




}
