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
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class Fight {
    @FXML
    private Button btnChangePokemonFight;
    @FXML
    private Button btnMove1;

    @FXML
    private Button btnMove2;

    @FXML
    private Button btnMove3;

    @FXML
    private Button btnMove4;

    @FXML
    private Button btnMove5;

    @FXML
    private Button btnChange;

    @FXML
    private Button prueba;

    @FXML
    private ImageView imgEnemy;

    @FXML
    private ImageView imgPokeball1;

    @FXML
    private ImageView imgPokeball2;

    @FXML
    private ImageView imgPokeball3;

    @FXML
    private ImageView imgTrainerPokemon;

    @FXML
    private Label lblHpEnemy;

    @FXML
    private Label lblHpTrainer;

    @FXML
    private Label lblNamePkEnemy;

    @FXML
    private Label lblDisplayPkTrainer;

    @FXML
    private Label lblTextFight;
    private Parent root;
    private Scene scene;
    private Stage stage;
    private Turns turn;

    public Pokemon firstPokemonTeam(){
        //EL COMBATE EMPIEZA CON EL PRIMER POKÉMON EQUIPADO
        //EL JUEGO TIENE QUE SABER CUÁL ES EL PRIMER POKÉMON EQUIPADO
        //ESTE MÉTODO DEVUELVE EL PRIMER POKEMON DEL EQUIPO
        if(Trainer.getTrainer().getPokemonTeam()[0] != null){
            return Trainer.getTrainer().getPokemonTeam()[0];
        }
        else if(Trainer.getTrainer().getPokemonTeam()[1] != null){
            return Trainer.getTrainer().getPokemonTeam()[1];
        }
        else if(Trainer.getTrainer().getPokemonTeam()[2] != null){
            return Trainer.getTrainer().getPokemonTeam()[2];
        }
        else if(Trainer.getTrainer().getPokemonTeam()[3] != null){
            return Trainer.getTrainer().getPokemonTeam()[3];
        }
        else if(Trainer.getTrainer().getPokemonTeam()[4] != null){
            return Trainer.getTrainer().getPokemonTeam()[4];
        }
        else return Trainer.getTrainer().getPokemonTeam()[5];

    }

    @FXML
    public void initialize(){
        //PONEMOS EL NOMBRE DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
        lblDisplayPkTrainer.setText(firstPokemonTeam().getDisplayName());
        //EN CONSTRUCCIÓN
        lblHpTrainer.setText(Integer.toString(firstPokemonTeam().getHp()));
        //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
        File file = new File(firstPokemonTeam().getImageBack());
        Image image = new Image(file.toURI().toString());
        imgTrainerPokemon.setImage(image);

        turn.calculateFirstTurn();
    }

    @FXML
    public void onMove1() {

    }

    @FXML
    public void onMove2() {

    }

    @FXML
    public void onMove3() {

    }

    @FXML
    public void onMove4() {

    }

    @FXML
    public void onMove5() {

    }

    @FXML
    public void onChangePokemonFight(){

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