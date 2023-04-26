package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static org.thesummoners.model.trainer.Trainer.getTrainer;

public class PokemonBreeding {
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
    private Button btnPay;
    @FXML
    private Button btnMenuPokemonBreeding;
    @FXML
    private Label lblMote;
    @FXML
    private TextField txtMote;
    @FXML
    private Button btnConfirmMote;
    @FXML
    private Label lblPokedollars;
    @FXML
    private Button btnNoMote;
    private Scene scene;
    private Parent root;
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
        lblPokedollars.setText("Pokedollar disponibles " + Trainer.getTrainer().getPokedollar());

        btnPay.setDisable(true);
        txtMote.setDisable(true);
        btnConfirmMote.setDisable(true);
        btnNoMote.setDisable(true);


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
    @FXML
    public void pokemonBreeding1(){
        Trainer.getTrainer().pokemonBreeding(0);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreeding2(){
        Trainer.getTrainer().pokemonBreeding(1);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreeding3(){
        Trainer.getTrainer().pokemonBreeding(2);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreeding4(){
        Trainer.getTrainer().pokemonBreeding(3);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreeding5(){
        Trainer.getTrainer().pokemonBreeding(4);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreeding6() {
        Trainer.getTrainer().pokemonBreeding(5);
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
        }
    }
    @FXML
    public void pokemonBreedPay(){
        Trainer.getTrainer().setPokedollar(getTrainer().getPokedollar() - 500);
        Trainer.getTrainer().BreedingPay();
        btnPay.setDisable(true);
        txtMote.setDisable(false);
        btnConfirmMote.setDisable(false);
        btnNoMote.setDisable(false);

    }

    @FXML
    public void pokemonBreedConfirmNickname(){
        Trainer.getTrainer().BreedingConfirmNickname(lblMote.getText());
        btnConfirmMote.setDisable(true);
        txtMote.setText("ㅤ");
        txtMote.setDisable(true);
        btnNoMote.setDisable(true);
    }
    @FXML
    public void pokemonBreedCancelNickname(){
        txtMote.setDisable(true);
        btnConfirmMote.setDisable(true);
        btnNoMote.setDisable(true);
    }
}
