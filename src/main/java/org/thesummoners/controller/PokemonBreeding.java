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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static org.thesummoners.model.trainer.Trainer.getTrainer;

public class PokemonBreeding {
    @FXML
    private ImageView imgPokemon1;
    @FXML
    private ImageView imgPokemon2;
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
    private Button btnNoMote;
    @FXML
    private Label lblPokedollars;
    /*@FXML
    private ImageView imgPokemonBreed1;
    @FXML
    private ImageView imgPokemonBreed2;*/
    private Scene scene;
    private Parent root;
    private Stage stage;


    public void initialize() {

        if (getTrainer().getPokemonTeam()[0] != null) {
            if (getTrainer().getPokemonTeam()[0].getLevel() >= 5) {
                btn1.setText(getTrainer().getPokemonTeam()[0].getDisplayName());
                btn1.setDisable(false);
            }
            else {
                btn1.setText(getTrainer().getPokemonTeam()[0].getDisplayName());
                btn1.setDisable(true);
            }
        } else {
            btn1.setText("No Pokémon");
            btn1.setDisable(true);
        }
        if (getTrainer().getPokemonTeam()[1] != null) {
            if (getTrainer().getPokemonTeam()[1].getLevel() >= 5) {
                btn2.setText(getTrainer().getPokemonTeam()[1].getDisplayName());
                btn2.setDisable(false);
            }
            else {
                btn2.setText(getTrainer().getPokemonTeam()[1].getDisplayName());
                btn2.setDisable(true);
            }
        } else {
            btn2.setText("No Pokémon");
            btn2.setDisable(true);
        }

        if (getTrainer().getPokemonTeam()[2] != null) {
            if (getTrainer().getPokemonTeam()[2].getLevel() >= 5) {
                btn3.setText(getTrainer().getPokemonTeam()[2].getDisplayName());
                btn3.setDisable(false);
            }
            else {
                btn3.setText(getTrainer().getPokemonTeam()[2].getDisplayName());
                btn3.setDisable(true);
            }
        } else {
            btn3.setText("No Pokémon");
            btn3.setDisable(true);
        }

        if (getTrainer().getPokemonTeam()[3] != null) {
            if (getTrainer().getPokemonTeam()[3].getLevel() >= 5) {
                btn4.setText(getTrainer().getPokemonTeam()[3].getDisplayName());
                btn4.setDisable(false);
            }
            else {
                btn4.setText(getTrainer().getPokemonTeam()[3].getDisplayName());
                btn4.setDisable(true);
            }
        } else {
            btn4.setText("No Pokémon");
            btn4.setDisable(true);
        }

        if (getTrainer().getPokemonTeam()[4] != null) {
            if (getTrainer().getPokemonTeam()[4].getLevel() >= 5) {
                btn5.setText(getTrainer().getPokemonTeam()[4].getDisplayName());
                btn5.setDisable(false);
            }
            else {
                btn5.setText(getTrainer().getPokemonTeam()[4].getDisplayName());
                btn5.setDisable(true);
            }
        } else {
            btn5.setText("No Pokémon");
            btn5.setDisable(true);
        }

        if (getTrainer().getPokemonTeam()[5] != null) {
            if (getTrainer().getPokemonTeam()[5].getLevel() >= 5) {
                btn6.setText(getTrainer().getPokemonTeam()[5].getDisplayName());
                btn6.setDisable(false);
            }
            else {
                btn6.setText(getTrainer().getPokemonTeam()[5].getDisplayName());
                btn6.setDisable(true);
            }
        } else {
            btn6.setText("No Pokémon");
            btn6.setDisable(true);
        }
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
        Trainer.getTrainer().getPokemonToBreed()[0] = null;
        Trainer.getTrainer().getPokemonToBreed()[1] = null;
    }
    @FXML
    void toPokemonStats(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonStats.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void pokemonBreeding1(){
        Trainer.getTrainer().pokemonBreeding(0);
        if(imgPokemon1.getImage() == null){ //MUESTRA A LOS POKEMON CUANDO LOS CLICAS
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }

        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn2.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn5.setDisable(true);
            btn6.setDisable(true);

        }
    }
    @FXML
    public void pokemonBreeding2() {
        Trainer.getTrainer().pokemonBreeding(1);
        if(imgPokemon1.getImage() == null){
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn1.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn5.setDisable(true);
            btn6.setDisable(true);
        }
    }
    @FXML
    public void pokemonBreeding3(){
        Trainer.getTrainer().pokemonBreeding(2);
        //COMPRUEBA SI SE HA SELECCIONADO A TRAVÉS DE LAS IMÁGENES
        if(imgPokemon1.getImage() == null){
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }
        //HABILITA EL BOTÓN DE PAGAR Y DESABILITA LOS DEMÁS
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn1.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn2.setDisable(true);
            btn6.setDisable(true);
        }
    }
    @FXML
    public void pokemonBreeding4(){
        Trainer.getTrainer().pokemonBreeding(3);
        if(imgPokemon1.getImage() == null){
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn1.setDisable(true);
            btn3.setDisable(true);
            btn5.setDisable(true);
            btn2.setDisable(true);
            btn6.setDisable(true);
        }
    }
    @FXML
    public void pokemonBreeding5(){
        Trainer.getTrainer().pokemonBreeding(4);
        if(imgPokemon1.getImage() == null){
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn1.setDisable(true);
            btn3.setDisable(true);
            btn5.setDisable(true);
            btn2.setDisable(true);
            btn6.setDisable(true);
        }
    }
    @FXML
    public void pokemonBreeding6() {
        Trainer.getTrainer().pokemonBreeding(5);
        if(imgPokemon1.getImage() == null){
            if(Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                File file = new File(getTrainer().pokemonToBreed[0].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
            else {
                File file = new File(getTrainer().pokemonToBreed[1].getImage());
                Image image = new Image(file.toURI().toString());
                imgPokemon1.setImage(image);
            }
        }
        else{
            File file = new File(getTrainer().pokemonToBreed[1].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemon2.setImage(image);
        }
        if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            btn1.setDisable(true);
            btn3.setDisable(true);
            btn4.setDisable(true);
            btn2.setDisable(true);
            btn5.setDisable(true);
        }
    }
    @FXML
    public void pokemonBreedPay() throws CloneNotSupportedException {
        Trainer.getTrainer().setPokedollar(getTrainer().getPokedollar() - 500);
        Trainer.getTrainer().BreedingPay();
        lblPokedollars.setText("Pokedollars: " + getTrainer().getPokedollar());
        btnPay.setDisable(true);
        txtMote.setDisable(false);
        btnConfirmMote.setDisable(false);
        btnNoMote.setDisable(false);
        Trainer.getTrainer().getPokemonToBreed()[0].setFertility(Trainer.getTrainer().getPokemonToBreed()[0].getFertility() - 1);
        Trainer.getTrainer().getPokemonToBreed()[1].setFertility(Trainer.getTrainer().getPokemonToBreed()[1].getFertility() - 1);
        Trainer.getTrainer().getPokemonToBreed()[0] = null;
        Trainer.getTrainer().getPokemonToBreed()[1] = null;
    }

    @FXML
    public void pokemonBreedConfirmNickname(ActionEvent event) throws IOException {
        if (txtMote.getText().isEmpty()){
            //Trainer.getTrainer().BreedingConfirmNickname(getTrainer().getPokemonCub()[0].getName());
            Trainer.getTrainer().getPokemonCub()[0].setNickName(getTrainer().getPokemonCub()[0].getName());
            Trainer.getTrainer().getPokemonCub()[0].changeDisplayName();
        }
        else {
            //Trainer.getTrainer().BreedingConfirmNickname(txtMote.getText());
            Trainer.getTrainer().getPokemonCub()[0].setNickName(txtMote.getText());
            Trainer.getTrainer().getPokemonCub()[0].changeDisplayName();
        }
        btnConfirmMote.setDisable(true);
        txtMote.setText("");
        txtMote.setDisable(true);
        btnNoMote.setDisable(true);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonStats.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()) .getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void pokemonBreedCancelNickname(ActionEvent event) throws IOException {
        txtMote.setDisable(true);
        btnConfirmMote.setDisable(true);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonStats.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}
