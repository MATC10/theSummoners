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
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.movement.MovementInitializer;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

import static org.thesummoners.model.trainer.Trainer.getTrainer;

public class Train {

    @FXML
    private Button btnLevel;

    @FXML
    private Button btnP1;

    @FXML
    private Button btnP2;

    @FXML
    private Button btnP3;

    @FXML
    private Button btnP4;

    @FXML
    private Button btnP5;

    @FXML
    private Button btnP6;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnLearnMove;

    @FXML
    private Label lblLevel;

    @FXML
    private Label lblPrice;

    @FXML
    private Label lblWhoTrain;

    @FXML
    private Label lblActualLevel;

    @FXML
    private Label lblPokedollars;

    @FXML
    private Label lblText;

    private Parent root;
    private Scene scene;
    private Stage stage;

    Pokemon p = null;

    public void initialize(){
        btnLearnMove.setDisable(true);
        if(getTrainer().getPokemonTeam()[0] != null){
            btnP1.setText(getTrainer().getPokemonTeam()[0].getDisplayName());
        }
        else btnP1.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[1] != null){
            btnP2.setText(getTrainer().getPokemonTeam()[1].getDisplayName());
        }
        else btnP2.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[2] != null){
            btnP3.setText(getTrainer().getPokemonTeam()[2].getDisplayName());
        }
        else btnP3.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[3] != null){
            btnP4.setText(getTrainer().getPokemonTeam()[3].getDisplayName());
        }
        else btnP4.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[4] != null){
            btnP5.setText(getTrainer().getPokemonTeam()[4].getDisplayName());
        }
        else btnP5.setText("No Pokémon");

        if(getTrainer().getPokemonTeam()[5] != null){
            btnP6.setText(getTrainer().getPokemonTeam()[5].getDisplayName());
        }
        else btnP6.setText("No Pokémon");

        lblPokedollars.setText("Pokedollar disponibles: " + getTrainer().getPokedollar());

    }


    @FXML
    void setLevelPok(ActionEvent event) throws CloneNotSupportedException {
        if(p != null){
            getTrainer().train(p, lblActualLevel, lblPrice, lblPokedollars, lblLevel);
            //APRENDE LOS ATAQUES HASTA NIVEL 13 QUE TE MANDA A LA VENTANA DE APRENDER MOVIMIENTOS
            p.learnMoveInTrainWindow( lblText,  btnLearnMove,  btnP1,  btnP2,
                    btnP3,  btnP4,  btnP5,  btnP6,
                    btnLevel,  btnBack);
        }
        else lblText.setText("¡Selecciona un Pokémon!");


    }

    @FXML
    void toTrain1() {
        p = getTrainer().getPokemonTeam()[0];
        lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[0].getDisplayName());
        lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[0].getLevel());
        lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[0].getLevel() * 20);
    }

    @FXML
    void toTrain2(ActionEvent event) {
        if(getTrainer().getPokemonTeam()[1] != null){
            p = getTrainer().getPokemonTeam()[1];
            lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[1].getDisplayName());
            lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[1].getLevel());
            lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[1].getLevel() * 20);
        }
        else {
            //p SE PONE NULL PARA ASEGURAR QUE NO HAYA ERRORES AL PULSAR DONDE NO HAY POKÉMON TRAS PULSAR
            //DONDE SÍ HAY POKÉMON
            p = null;
            lblWhoTrain.setText("Ningún Pokémon seleccionado");
        }
    }

    @FXML
    void toTrain3(ActionEvent event) {
        if(getTrainer().getPokemonTeam()[2] != null){
            p = getTrainer().getPokemonTeam()[2];
            lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[2].getDisplayName());
            lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[2].getLevel());
            lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[2].getLevel() * 20);
        }
        else {
            p = null;
            lblWhoTrain.setText("Ningún Pokémon seleccionado");
        }
    }

    @FXML
    void toTrain4(ActionEvent event) {
        if(getTrainer().getPokemonTeam()[3] != null){
            p = getTrainer().getPokemonTeam()[3];
            lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[3].getDisplayName());
            lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[3].getLevel());
            lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[3].getLevel() * 20);
        }
        else {
            p = null;
            lblWhoTrain.setText("Ningún Pokémon seleccionado");
        }
    }

    @FXML
    void toTrain5(ActionEvent event) {
        if(getTrainer().getPokemonTeam()[4] != null){
            p = getTrainer().getPokemonTeam()[4];
            lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[4].getDisplayName());
            lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[4].getLevel());
            lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[4].getLevel() * 20);
        }
        else {
            p = null;
            lblWhoTrain.setText("Ningún Pokémon seleccionado");
        }
    }

    @FXML
    void toTrain6(ActionEvent event) {
        if(getTrainer().getPokemonTeam()[5] != null){
            p = getTrainer().getPokemonTeam()[5];
            lblWhoTrain.setText("Vas a entrenar a " + getTrainer().getPokemonTeam()[5].getDisplayName());
            lblActualLevel.setText("Nivel actual: " + getTrainer().getPokemonTeam()[5].getLevel());
            lblPrice.setText("Precio: " + getTrainer().getPokemonTeam()[5].getLevel() * 20);
        }
        else {
            p = null;
            lblWhoTrain.setText("Ningún Pokémon seleccionado");
        }
    }

    @FXML
    void toLearningMovement(ActionEvent event) throws IOException {


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

        this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/LearningMovement.fxml")));
        this.scene = new Scene(this.root, 600.0, 400.0);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.stage.setTitle("TheSummoners");
        this.stage.setScene(scene);
        this.stage.show();
    }
    @FXML
    void onBackToMenu (ActionEvent event) throws IOException {
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



        this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/MainWindow.fxml")));
        this.scene = new Scene(this.root, 600.0, 400.0);
        this.stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.stage.setTitle("TheSummoners");
        this.stage.setScene(scene);
        this.stage.show();
    }
}
