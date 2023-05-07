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
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Enemy;
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

    @FXML
    private Label lblLevelTrainer;

    @FXML
    private Label lblLevelEnemy;

    private Parent root;
    private Scene scene;
    private Stage stage;

    private Turns turn;
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Movement movement;



    @FXML
    public void initialize(){
        //SACAMOS EL PRIMER POKEMON DE AMBOS EQUIPOS
        pokemon1 = Trainer.getTrainer().getPokemonTeam()[0];
        pokemon2 = Enemy.getEnemyTeam()[0];

        Turns turn = new Turns();

        //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
        lblDisplayPkTrainer.setText(pokemon1.getDisplayName());
        lblHpTrainer.setText(Integer.toString(pokemon1.getHp()));
        lblLevelTrainer.setText(Integer.toString(pokemon1.getLevel()));

        //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL ENEMIGO EN EL LABEL CORRESPONDIENTE
        lblDisplayPkTrainer.setText(pokemon2.getDisplayName());
        lblHpTrainer.setText(Integer.toString(pokemon2.getHp()));
        lblLevelTrainer.setText(Integer.toString(pokemon2.getLevel()));

        //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
        File file = new File(pokemon1.getImageBack());
        Image image = new Image(file.toURI().toString());
        imgTrainerPokemon.setImage(image);

        turn.calculateFirstTurn();

    }

    @FXML
    public void onMove1() throws InterruptedException, CloneNotSupportedException {
        movement = pokemon1.getLearnedMovement()[0];
//TODO EL ENTRENADOR DEBE TENER UN MÉTODO PARA SELECCIONAR POKEMON O CAMBIAR POKEMON
        Trainer.getTrainer().fight(pokemon1, pokemon2, movement, turn,lblTextFight);
        //TODO CREAR UN IF PARA IDENTIFICAR CUÁNDO A UNO DE LOS DOS SE LE HAN DEBILITADO TODOS LOS POKEMON
        //TODO DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO


    }

    @FXML
    public void onMove2() throws InterruptedException, CloneNotSupportedException {
        movement = pokemon1.getLearnedMovement()[1];
        Trainer.getTrainer().fight(pokemon1, pokemon2, movement, turn,lblTextFight);
    }

    @FXML
    public void onMove3() throws InterruptedException, CloneNotSupportedException {
        movement = pokemon1.getLearnedMovement()[2];
        Trainer.getTrainer().fight(pokemon1, pokemon2, movement, turn,lblTextFight);
    }

    @FXML
    public void onMove4() throws InterruptedException, CloneNotSupportedException {
        movement = pokemon1.getLearnedMovement()[3];
        Trainer.getTrainer().fight(pokemon1, pokemon2, movement, turn,lblTextFight);
    }

    @FXML
    public void onMove5() {

    }

    @FXML
    public void onChangePokemonFight(){

    }

    @FXML
    void toMainWindow(ActionEvent event) throws IOException {

        //TODO SI UN POKEMON ESTÁ DEBILITADO O CON UN ESTADO DA IGUAL
        //DEBE IR AL CENTRO POKEMON PARA RECUPERARSE

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}