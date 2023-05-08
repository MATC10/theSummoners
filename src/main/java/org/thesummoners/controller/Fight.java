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
import java.util.Random;


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
    private Label lblHpMaxTrainer;

    @FXML
    private Label lblLevelEnemy;

    @FXML
    private Label lblHpMaxEnemy;

    private Parent root;
    private Scene scene;
    private Stage stage;


    private Movement movement;



    @FXML
    public void initialize() throws CloneNotSupportedException, InterruptedException {
        Random random = new Random();
        //SACAMOS EL PRIMER POKEMON DE AMBOS EQUIPOS
        Trainer.getTrainer().setPokemon1(Trainer.getTrainer().getPokemonTeam()[0]);
        Enemy.getEnemy().setPokemon2(Enemy.getEnemy().pokemonIntoTeam()[0]);

        //CAMBIAMOS LOS LABELS Y LAS IMAGENES
        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
        Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);



        //SI isCurrentTurn ES FALSE, EL ENEMIGO EMPIEZA ATACANDO
        if(Trainer.getTrainer().getPokemonTeam()[0].getSpeed() < Enemy.getEnemy().getEnemyTeam()[0].getSpeed()) {
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)], lblTextFight );
            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
            Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);
        }
        else  lblTextFight.setText(Trainer.getTrainer().getPokemon1().getDisplayName() + " comienza atacando");


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
        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[0],lblTextFight);
        //TODO CREAR UN IF PARA IDENTIFICAR CUÁNDO A UNO DE LOS DOS SE LE HAN DEBILITADO TODOS LOS POKEMON
        //TODO DESPUÉS DEL MÉTODO FIGHT HACEMOS COMPROBACIÓN DE POKEMON VIVOS Y SE SACA OTRO SI ESTÁ DEBILITADO

//CAMBIAMOS LOS LABELS Y LAS IMAGENES
        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
        Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);

    }

    @FXML
    public void onMove2() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1] != null) btnMove2.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1].getName());
        else btnMove2.setText("Sin movimiento");


        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[1],lblTextFight);

        //CAMBIAMOS LOS LABELS Y LAS IMAGENES
        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
        Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);

    }

    @FXML
    public void onMove3() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2] != null) btnMove3.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2].getName());
        else btnMove3.setText("Sin movimiento");

        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[2],lblTextFight);


        //CAMBIAMOS LOS LABELS Y LAS IMAGENES
        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
        Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);

    }

    @FXML
    public void onMove4() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3] != null) btnMove4.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3].getName());
        else btnMove4.setText("Sin movimiento");

        Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[3], lblTextFight);

        //CAMBIAMOS LOS LABELS Y LAS IMAGENES
        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon);
        Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy);

    }

    @FXML
    public void onMove5() {

    }

    @FXML
    public void onChangePokemonFight(){

    }

    @FXML
    void toMainWindow(ActionEvent event) throws IOException, CloneNotSupportedException {
        //AL SALIR DE LA VENTANA SE CAMBIAN LOS POKEMON DEL ENEMIGO
        Enemy.getEnemy().pokemonIntoTeam();
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