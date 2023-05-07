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
    private Label lblDisplayPkEnemy;

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

    private Movement movement;



    @FXML
    public void initialize() throws CloneNotSupportedException {
        //SACAMOS EL PRIMER POKEMON DE AMBOS EQUIPOS
        Trainer.getTrainer().setPokemon1(Trainer.getTrainer().getPokemonTeam()[0]);
        Enemy.getEnemy().setPokemon2(Enemy.getEnemy().pokemonIntoTeam()[0]);

        Turns turn = new Turns();

        //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL TEAM EN EL LABEL CORRESPONDIENTE
        lblDisplayPkTrainer.setText(Trainer.getTrainer().getPokemon1().getDisplayName());
        lblHpTrainer.setText("Vida: " + Trainer.getTrainer().getPokemon1().getHp());
        lblLevelTrainer.setText("Nivale: " + Trainer.getTrainer().getPokemon1().getLevel());
        //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM
        File file = new File(Trainer.getTrainer().getPokemon1().getImageBack());
        Image image = new Image(file.toURI().toString());
        imgTrainerPokemon.setImage(image);

        //PONEMOS EL NOMBRE, LEVEL Y HP DEL PRIMER POKÉMON DEL ENEMIGO EN EL LABEL CORRESPONDIENTE
        lblDisplayPkEnemy.setText(Enemy.getEnemy().getPokemon2().getDisplayName());
        lblHpEnemy.setText("Vida: " + Enemy.getEnemy().getPokemon2().getHp());
        lblLevelEnemy.setText("Nivel: " + Enemy.getEnemy().getPokemon2().getLevel());
        //PONEMOS LA IMAGEN DEL PRIMER POKÉMON DEL TEAM ENEMIGO

        File file2 = new File(Enemy.getEnemy().getPokemon2().getImage());
        Image image2 = new Image(file2.toURI().toString());
        imgEnemy.setImage(image2);



        turn.calculateFirstTurn();

//TODO TODO ESTO PASARLO AL MÉTODO QUE HAGA LA MECÁNICA DEL NUEVO POKEMON QUE ENTRA A COMBATIR
        btnMove1.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[0].getName());
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1] != null) btnMove2.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1].getName());
        else btnMove2.setText("Sin movimiento");
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2] != null) btnMove3.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2].getName());
        else btnMove3.setText("Sin movimiento");
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3] != null) btnMove4.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3].getName());
        else btnMove4.setText("Sin movimiento");


    }

    @FXML
    public void onMove1() throws InterruptedException, CloneNotSupportedException {
        btnMove1.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[0].getName());

        movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[0];
//TODO EL ENTRENADOR DEBE TENER UN MÉTODO PARA SELECCIONAR POKEMON O CAMBIAR POKEMON
        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), movement, turn,lblTextFight);
        //TODO CREAR UN IF PARA IDENTIFICAR CUÁNDO A UNO DE LOS DOS SE LE HAN DEBILITADO TODOS LOS POKEMON
        //TODO DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO


    }

    @FXML
    public void onMove2() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1] != null) btnMove2.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1].getName());
        else btnMove2.setText("Sin movimiento");


        movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[1];
        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), movement, turn,lblTextFight);
    }

    @FXML
    public void onMove3() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2] != null) btnMove3.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2].getName());
        else btnMove3.setText("Sin movimiento");

        movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[2];
        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), movement, turn,lblTextFight);
    }

    @FXML
    public void onMove4() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3] != null) btnMove4.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3].getName());
        else btnMove4.setText("Sin movimiento");

        movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[3];
        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), movement, turn,lblTextFight);
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