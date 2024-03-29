package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.Logger;
import org.thesummoners.model.movement.Movement;
import org.thesummoners.model.movement.MovementInitializer;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Enemy;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.trainer.Turns;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Random;


public class Fight {
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
    private Button toMainWindow;

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
    private ImageView imgPokeball1Trainer;

    @FXML
    private ImageView imgPokeball2Trainer;

    @FXML
    private ImageView imgPokeball3Trainer;

    @FXML
    private ImageView imgPokeball4Trainer;

    @FXML
    private ImageView imgPokeball5Trainer;

    @FXML
    private ImageView imgPokeball6Trainer;

    @FXML
    private Label lblHpEnemy;

    @FXML
    private Label lblHpTrainer;

    @FXML
    private Label lblDisplayPkEnemy;

    @FXML
    private Label lblDisplayPkTrainer;

    @FXML
    private ListView <String> lvFight;

    @FXML
    private Label lblLevelTrainer;

    @FXML
    private Label lblHpMaxTrainer;

    @FXML
    private Label lblLevelEnemy;
    @FXML
    private ImageView imgBackground;

    @FXML
    private Label lblHpMaxEnemy;
    @FXML
    private Label lblStateTrainer;
    @FXML
    private Label lblStateEnemy;
    Random random = new Random();

    private Parent root;
    private Scene scene;
    private Stage stage;


    private Movement movement;



    @FXML
    public void initialize() throws CloneNotSupportedException, InterruptedException {
        File file2 = new File("doc/images/otherimages/battlegrass.png");
        Image image2 = new Image(file2.toURI().toString());
        imgBackground.setImage(image2);
        //LOGGER
        try (Logger logger = new Logger()) {
            logger.log("¡Has iniciado un combate Pokémon!");
        }
        btnMove5.setDisable(true);

        toMainWindow.setDisable(false);
        //SACAMOS EL PRIMER POKEMON DE AMBOS EQUIPOS
        Trainer.getTrainer().setPokemon1(Trainer.getTrainer().getPokemonTeam()[0]);
        Enemy.getEnemy().setPokemon2(Enemy.getEnemy().pokemonIntoTeam()[0]);

        Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);

         Enemy.getEnemy().changePokemonInFightEnemy(lblDisplayPkEnemy,  lblHpEnemy,  lblHpMaxEnemy,  lblLevelEnemy,  imgEnemy,  lblStateEnemy,
                btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow,  imgPokeball1,  imgPokeball2,  imgPokeball3, btnMove5);
        Trainer.getTrainer().changePokemonInFightTrainer(lblDisplayPkTrainer,lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer,
                imgTrainerPokemon, lblStateTrainer,  imgPokeball1Trainer,  imgPokeball2Trainer,
                imgPokeball3Trainer, imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer,
                btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow);

        //SI isCurrentTurn ES FALSE, EL ENEMIGO EMPIEZA ATACANDO
        if(Trainer.getTrainer().getPokemonTeam()[0].getSpeed() < Enemy.getEnemy().getEnemyTeam()[0].getSpeed()) {

            Trainer.getTrainer().getSentencesTextFight().add(Enemy.getEnemy().getPokemon2().getDisplayName() + " comienza atacando");
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy,  lblHpEnemy,  lblHpMaxEnemy,  lblLevelEnemy,  imgEnemy,  lblStateEnemy,
                    btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow,  imgPokeball1,  imgPokeball2,  imgPokeball3,
                    imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                    imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer, btnMove5);
            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                    imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);
        }
        else  Trainer.getTrainer().getSentencesTextFight().add(Trainer.getTrainer().getPokemon1().getDisplayName() + " comienza atacando");



        btnMove1.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[0].getName());
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1] != null) btnMove2.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1].getName());
        else btnMove2.setText("Sin movimiento");
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2] != null) btnMove3.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2].getName());
        else btnMove3.setText("Sin movimiento");
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3] != null) btnMove4.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3].getName());
        else btnMove4.setText("Sin movimiento");

        lvFight.setItems(Trainer.getTrainer().getSentencesTextFight());

    }

    @FXML
    public void onMove1() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[0] != null){
            btnMove1.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[0].getName());
            movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[0];
            Trainer.getTrainer().changeLabelsInFight( lblDisplayPkTrainer,  lblHpTrainer,   lblHpMaxTrainer,   lblLevelTrainer,
                    imgTrainerPokemon,  lblStateTrainer,
                    imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                    imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);

            Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[0],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy,  lblHpEnemy,  lblHpMaxEnemy,  lblLevelEnemy,  imgEnemy,  lblStateEnemy,
                    btnMove1,  btnMove2,  btnMove3,  btnMove4,  toMainWindow,  imgPokeball1,  imgPokeball2,  imgPokeball3,
                    imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                    imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer, btnMove5);


            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer,  imgPokeball2Trainer,  imgPokeball3Trainer,
                    imgPokeball4Trainer,  imgPokeball5Trainer,  imgPokeball6Trainer);
            Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy);



        }

    }

    @FXML
    public void onMove2() throws InterruptedException, CloneNotSupportedException {
        if (Trainer.getTrainer().getPokemon1().getLearnedMovement()[1] != null) {
            btnMove2.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[1].getName());
            movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[1];

            Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[1],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);

            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer);
            Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy);


        }
    }

    @FXML
    public void onMove3() throws InterruptedException, CloneNotSupportedException {

        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2] != null) {
            btnMove3.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[2].getName());
            movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[2];

            Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[2],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);

            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer);
            Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy);



        }
    }

    @FXML
    public void onMove4() throws InterruptedException, CloneNotSupportedException {
        if(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3] != null) {
            btnMove4.setText(Trainer.getTrainer().getPokemon1().getLearnedMovement()[3].getName());
            movement = Trainer.getTrainer().getPokemon1().getLearnedMovement()[3];

            Trainer.getTrainer().fight(Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1().getLearnedMovement()[3],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);
            Enemy.getEnemy().fight(Enemy.getEnemy().getPokemon2(), Trainer.getTrainer().getPokemon1(), Enemy.getEnemy().getPokemon2().getLearnedMovement()[random.nextInt(4)],
                    lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy,
                    btnMove1, btnMove2, btnMove3, btnMove4, toMainWindow, imgPokeball1, imgPokeball2, imgPokeball3,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer, btnMove5);

            //CAMBIAMOS LOS LABELS Y LAS IMAGENES
            Trainer.getTrainer().changeLabelsInFight(lblDisplayPkTrainer, lblHpTrainer, lblHpMaxTrainer, lblLevelTrainer, imgTrainerPokemon, lblStateTrainer,
                    imgPokeball1Trainer, imgPokeball2Trainer, imgPokeball3Trainer,
                    imgPokeball4Trainer, imgPokeball5Trainer, imgPokeball6Trainer);
            Enemy.getEnemy().changeLabelsInFight(lblDisplayPkEnemy, lblHpEnemy, lblHpMaxEnemy, lblLevelEnemy, imgEnemy, lblStateEnemy);



        }
    }

    @FXML
    public void onMove5(ActionEvent event) throws IOException {

        //BORRAMOS TODOS LOS REGISTROS
        PokemonCRUD.deleteAllPokemon();
        //AÑADIMOS LOS POKEMON DE NUESTRO ARRAY A LA BBDD
        PokemonCRUD.insertTrainerPokemonTeam(Trainer.getTrainer().getPokemonTeam());
        //AÑADIMOS POS POKEMON DE NUESTRO PCBILL A LA BBDD
        PokemonCRUD.insertPokemonPcBill(Trainer.getTrainer().getPokemonPcBill());

        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/LearningMovement.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void toMainWindow(ActionEvent event) throws IOException, CloneNotSupportedException {
        //QUITAMOS EL POKEMON SELECCIONADO PARA UNA POSIBLE SUBIDA DE NIVEL
        Trainer.getTrainer().pokemonCub[0] = null;
        //AL SALIR DE LA VENTANA SE CAMBIAN LOS POKEMON DEL ENEMIGO Y SE REINICIA LA OBSERVABLELIST
        Enemy.getEnemy().pokemonIntoTeam();
        Trainer.getTrainer().getSentencesTextFight().clear();




        //BORRAMOS TODOS LOS REGISTROS
        PokemonCRUD.deleteAllPokemon();
        //AÑADIMOS LOS POKEMON DE NUESTRO ARRAY A LA BBDD
        PokemonCRUD.insertTrainerPokemonTeam(Trainer.getTrainer().getPokemonTeam());
        //AÑADIMOS POS POKEMON DE NUESTRO PCBILL A LA BBDD
        PokemonCRUD.insertPokemonPcBill(Trainer.getTrainer().getPokemonPcBill());

        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);





        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}