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
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;

public class PokemonStats {
    @FXML
    private Label lblHP;
    @FXML
    private Label lblAttack;
    @FXML
    private Label lblDefense;
    @FXML
    private Label lblSpecialAttack;
    @FXML
    private Label lblSpecialDefense;
    @FXML
    private Label lblSpeed;
    @FXML
    private Label lblStatsPokemonName;
    @FXML
    private ImageView imgPokemonStats;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void initialize(){
        lblHP.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getHp()));
        lblAttack.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getAttackPower()));
        lblDefense.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getDefense()));
        lblSpecialAttack.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpecialAttack()));
        lblSpecialDefense.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpecialDefense()));
        lblSpeed.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpeed()));
        Trainer.getTrainer().pokemonCub[0].changeDisplayName();
        lblStatsPokemonName.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName());

        File file = new File(Trainer.getTrainer().pokemonCub[0].getImage());
        Image image = new Image(file.toURI().toString());
        imgPokemonStats.setImage(image);

    }



}
