package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.thesummoners.model.Trainer;


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
    private Label lblNickPkTrainer;

    @FXML
    private Label lblTextFight;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void firstPokemonTeam(){
        //EL COMBATE EMPIEZA CON EL PRIMER POKÉMON EQUIPADO
        //EL JUEGO TIENE QUE SABER CUÁL ES EL PRIMER POKÉMON EQUIPADO
        //EN CONSTRUCCIÓN
        if(Trainer.getTrainer().getPokemonTeam()[0] != null){

        }
    }

    @FXML
    public void initialize(){
        //PONEMOS EL NOMBRE DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
        //EN CONSTRUCCIÓN


        lblNickPkTrainer.setText(Trainer.getTrainer().getPokemonTeam()[0].getNickName());
    }

    @FXML
    public void onMove1(ActionEvent event) {

    }

    @FXML
    public void onMove2(ActionEvent event) {

    }

    @FXML
    public void onMove3(ActionEvent event) {

    }

    @FXML
    public void onMove4(ActionEvent event) {

    }

    @FXML
    public void onChangePokemonFight(ActionEvent event){

    }
}
