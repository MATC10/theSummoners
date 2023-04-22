package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

import static org.thesummoners.model.trainer.Trainer.getTrainer;

public class PokemonStats {

    @FXML
    private Button btn1;

    @FXML
    private Button btn2;

    @FXML
    private Button btn3;

    @FXML
    private Button btn4;

    @FXML
    private Button btn5;

    @FXML
    private Button btn6;

    @FXML
    private Button btnBack;

    @FXML
    private Label lbl1;

    private Parent root;
    private Scene scene;
    private Stage stage;


    public void initialize(){
        if(getTrainer().getPokemonTeam()[0] != null){
            btn1.setText(getTrainer().getPokemonTeam()[0].getDisplayName());
        }
        else btn1.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[1] != null){
            btn2.setText(getTrainer().getPokemonTeam()[1].getDisplayName());
        }
        else btn2.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[2] != null){
            btn3.setText(getTrainer().getPokemonTeam()[2].getDisplayName());
        }
        else btn3.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[3] != null){
            btn4.setText(getTrainer().getPokemonTeam()[3].getDisplayName());
        }
        else btn4.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[4] != null){
            btn5.setText(getTrainer().getPokemonTeam()[4].getDisplayName());
        }
        else btn5.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[5] != null){
            btn6.setText(getTrainer().getPokemonTeam()[5].getDisplayName());
        }
        else btn6.setText("No Pokémon");
    }

    @FXML
    void pokemonStats1(ActionEvent event) {

    }

    @FXML
    void pokemonStats2(ActionEvent event) {

    }

    @FXML
    void pokemonStats3(ActionEvent event) {

    }

    @FXML
    void pokemonStats4(ActionEvent event) {

    }

    @FXML
    void pokemonStats5(ActionEvent event) {

    }

    @FXML
    void pokemonStats6(ActionEvent event) {

    }

    @FXML
    void toMainWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}