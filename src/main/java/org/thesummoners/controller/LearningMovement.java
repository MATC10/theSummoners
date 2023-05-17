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
import org.thesummoners.model.movement.AttackMovement;
import org.thesummoners.model.movement.MovementInitializer;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LearningMovement {



        @FXML
        private Button btnMove1;

        @FXML
        private Button btnMove2;

        @FXML
        private Button btnMove3;

        @FXML
        private Button btnMove4;

        @FXML
        private Button btnNoMove;

        @FXML
        private Label lblNewMove;

        @FXML
        private Label lblText;

    private Parent root;
    private Scene scene;
    private Stage stage;




    @FXML
    public void initialize() throws CloneNotSupportedException {

        btnMove1.setText( Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
        btnMove2.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[1].getName());
        btnMove3.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[2].getName());
        btnMove4.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[3].getName());
        lblNewMove.setText(MovementInitializer.movementLevelIntoHash().get(Trainer.getTrainer().pokemonCub[0].getLevel()).getName());
    }
    @FXML
    void setMove1(ActionEvent event) {
        Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0] =
                MovementInitializer.movementLevelIntoHash().get(Trainer.getTrainer().pokemonCub[0].getLevel());
        btnMove1.setDisable(true);
        btnMove2.setDisable(true);
        btnMove3.setDisable(true);
        btnMove4.setDisable(true);
        lblText.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName() + " ha aprendido " +
                Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
    }


    @FXML
    void setMove2(ActionEvent event) {
        Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[1] =
                MovementInitializer.movementLevelIntoHash().get(Trainer.getTrainer().pokemonCub[0].getLevel());
        btnMove1.setDisable(true);
        btnMove2.setDisable(true);
        btnMove3.setDisable(true);
        btnMove4.setDisable(true);
        lblText.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName() + " ha aprendido " +
                Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[1].getName());
    }
    @FXML
    void setMove3(ActionEvent event) {
        Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[2] =
                MovementInitializer.movementLevelIntoHash().get(Trainer.getTrainer().pokemonCub[0].getLevel());
        btnMove1.setDisable(true);
        btnMove2.setDisable(true);
        btnMove3.setDisable(true);
        btnMove4.setDisable(true);
        lblText.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName() + " ha aprendido " +
                Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[2].getName());
    }

    @FXML
    void setMove4(ActionEvent event) {
        Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[3] =
                MovementInitializer.movementLevelIntoHash().get(Trainer.getTrainer().pokemonCub[0].getLevel());
        btnMove1.setDisable(true);
        btnMove2.setDisable(true);
        btnMove3.setDisable(true);
        btnMove4.setDisable(true);
        lblText.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName() + " ha aprendido " +
                Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[3].getName());
    }

    @FXML
    public void toMainWindow(ActionEvent event) throws IOException {


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
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
