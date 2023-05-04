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
    @FXML
    private CheckBox chk1;
    @FXML
    private CheckBox chk2;
    @FXML
    private CheckBox chk3;
    @FXML
    private CheckBox chk4;
    @FXML
    private CheckBox chk5;
    @FXML
    private CheckBox chk6;
    /*@FXML
    private ImageView imgPokemonBreed1;
    @FXML
    private ImageView imgPokemonBreed2;*/
    private Scene scene;
    private Parent root;
    private Stage stage;
    //TODO PONER QUE TIENE QUE HABER AL MENOS UN CARÁCTER PARA CONFIRMAR MOTE

    public void initialize(){
        if(getTrainer().getPokemonTeam()[0] != null){
            chk1.setText(getTrainer().getPokemonTeam()[0].getDisplayName());
        }
        else {
            chk1.setText("No Pokémon");
            chk1.setDisable(true);
        }
        if(getTrainer().getPokemonTeam()[1] != null){
            chk2.setText(getTrainer().getPokemonTeam()[1].getDisplayName());
        }
        else {
            chk2.setText("No Pokémon");
            chk2.setDisable(true);
        }

        if(getTrainer().getPokemonTeam()[2] != null){
            chk3.setText(getTrainer().getPokemonTeam()[2].getDisplayName());
        }
        else {
            chk3.setText("No Pokémon");
            chk3.setDisable(true);
        }

        if(getTrainer().getPokemonTeam()[3] != null){
            chk4.setText(getTrainer().getPokemonTeam()[3].getDisplayName());
        }
        else {
            chk4.setText("No Pokémon");
            chk4.setDisable(true);
        }

        if(getTrainer().getPokemonTeam()[4] != null){
            chk5.setText(getTrainer().getPokemonTeam()[4].getDisplayName());
        }
        else {
            chk5.setText("No Pokémon");
            chk5.setDisable(true);
        }

        if(getTrainer().getPokemonTeam()[5] != null){
            chk6.setText(getTrainer().getPokemonTeam()[5].getDisplayName());
        }
        else {
            chk6.setText("No Pokémon");
            chk6.setDisable(true);
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

        if(chk1.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[0];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[0];
                chk2.setDisable(true);
                chk3.setDisable(true);
                chk4.setDisable(true);
                chk5.setDisable(true);
                chk6.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk2.setDisable(false);
                chk3.setDisable(false);
                chk4.setDisable(false);
                chk5.setDisable(false);
                chk6.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }


        /*File file = new File(Trainer.getTrainer().getPokemonTeam()[0].getImage());
        Image image = new Image(file.toURI().toString());
        imgPokemonBreed2.setImage(image);
        */
    }
    @FXML
    public void pokemonBreeding2(){
        Trainer.getTrainer().pokemonBreeding(1);
        if(chk2.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[1];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[1];
                chk1.setDisable(true);
                chk3.setDisable(true);
                chk4.setDisable(true);
                chk5.setDisable(true);
                chk6.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk1.setDisable(false);
                chk3.setDisable(false);
                chk4.setDisable(false);
                chk5.setDisable(false);
                chk6.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }
        /*if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            chk1.setDisable(true);
            chk3.setDisable(true);
            chk4.setDisable(true);
            chk5.setDisable(true);
            chk6.setDisable(true);
        }*/
    }
    @FXML
    public void pokemonBreeding3(){
        Trainer.getTrainer().pokemonBreeding(2);
        if(chk3.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[2];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[2];
                chk1.setDisable(true);
                chk2.setDisable(true);
                chk4.setDisable(true);
                chk5.setDisable(true);
                chk6.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk1.setDisable(false);
                chk2.setDisable(false);
                chk4.setDisable(false);
                chk5.setDisable(false);
                chk6.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }
        /*if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            chk1.setDisable(true);
            chk2.setDisable(true);
            chk4.setDisable(true);
            chk5.setDisable(true);
            chk6.setDisable(true);
        }*/
    }
    @FXML
    public void pokemonBreeding4(){
        Trainer.getTrainer().pokemonBreeding(3);
        if(chk4.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[3];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[3];
                chk1.setDisable(true);
                chk2.setDisable(true);
                chk3.setDisable(true);
                chk5.setDisable(true);
                chk6.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk1.setDisable(false);
                chk2.setDisable(false);
                chk3.setDisable(false);
                chk5.setDisable(false);
                chk6.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }
        /*if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            chk1.setDisable(true);
            chk3.setDisable(true);
            chk2.setDisable(true);
            chk5.setDisable(true);
            chk6.setDisable(true);
        }*/
    }
    @FXML
    public void pokemonBreeding5(){
        Trainer.getTrainer().pokemonBreeding(4);
        if(chk5.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[4];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[4];
                chk1.setDisable(true);
                chk2.setDisable(true);
                chk4.setDisable(true);
                chk3.setDisable(true);
                chk6.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk1.setDisable(false);
                chk2.setDisable(false);
                chk4.setDisable(false);
                chk3.setDisable(false);
                chk6.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }
        /*if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            chk1.setDisable(true);
            chk3.setDisable(true);
            chk4.setDisable(true);
            chk2.setDisable(true);
            chk6.setDisable(true);
        }*/
    }
    @FXML
    public void pokemonBreeding6() {
        Trainer.getTrainer().pokemonBreeding(5);
        if(chk6.isSelected()){
            if(Trainer.getTrainer().getPokemonToBreed()[0] == null)
                Trainer.getTrainer().getPokemonToBreed()[0] = Trainer.getTrainer().getPokemonTeam()[5];
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = Trainer.getTrainer().getPokemonTeam()[5];
                chk1.setDisable(true);
                chk2.setDisable(true);
                chk4.setDisable(true);
                chk3.setDisable(true);
                chk5.setDisable(true);
            }
        }
        else {
            if (Trainer.getTrainer().getPokemonToBreed()[1] != null) {
                Trainer.getTrainer().getPokemonToBreed()[1] = null;
                chk1.setDisable(false);
                chk2.setDisable(false);
                chk4.setDisable(false);
                chk3.setDisable(false);
                chk5.setDisable(false);
            }
            else if (Trainer.getTrainer().getPokemonToBreed()[0] != null)
                Trainer.getTrainer().getPokemonToBreed()[0] = null;
        }
        /*if (Trainer.getTrainer().getPokemonToBreed()[0] != null && Trainer.getTrainer().getPokemonToBreed()[1] != null) {
            btnPay.setDisable(false);
            chk1.setDisable(true);
            chk3.setDisable(true);
            chk4.setDisable(true);
            chk5.setDisable(true);
            chk2.setDisable(true);
        }*/
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
    public void pokemonBreedConfirmNickname(ActionEvent event) throws IOException{
        Trainer.getTrainer().BreedingConfirmNickname(txtMote.getText());
        btnConfirmMote.setDisable(true);
        txtMote.setText(""); //Esto es una marranada pero no se como quito el texto obviando el txtMote.deleteText();
        txtMote.setDisable(true);
        btnNoMote.setDisable(true);
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonStats.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
