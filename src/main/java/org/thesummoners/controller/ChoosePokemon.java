package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.pokemon.*;
import org.thesummoners.model.trainer.Trainer;


import java.io.IOException;
import java.util.Objects;

import static org.thesummoners.bd.PokemonCRUD.insertTrainerPokemon;

public class ChoosePokemon {
    @FXML
    private Button btnPikachu;
    @FXML
    private Button btnBulbasaur;
    @FXML
    private Button btnSquirtle;
    @FXML
    private Button btnCharmander;
    private Parent root;
    private Scene scene;
    private Stage stage;
    Pokemon p;

    @FXML
    public void toMainWindowPikachu(ActionEvent event) throws IOException, CloneNotSupportedException {

        p = new Pokemon("Pikachu", 25, "doc/images/Pikachu.png", "doc/images/spritesback/3a-b__025__xy.gif",135,1, 55,50,40,50,90, 150, Type.ELECTRIC, Type.NOTHING, State.ALIVE, Sex.F, 0).clone();
        if(Trainer.getTrainer().numberBoundTeamFree() < 6) {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            insertTrainerPokemon(p, 1);
        }
        else{
            //SI NO HAY HUECO...
            Trainer.pokemonPcBill.add(p);
            insertTrainerPokemon(p, 2);
        }
        PokemonCRUD.readPokemonTeam();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void toMainWindowBulbasaur(ActionEvent event) throws IOException, CloneNotSupportedException {
        p = new Pokemon("Bulbasaur", 1, "doc/images/Bulbasaur.png", "doc/images/spritesback/3a-b__001__xy.gif",145,1, 49,65,49,65,45, 150, Type.GRASS, Type.POISON, State.ALIVE, Sex.M, 0).clone();
        if(Trainer.getTrainer().numberBoundTeamFree() < 6) {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            insertTrainerPokemon(p, 1);
        }
        else{
            //SI NO HAY HUECO...
            Trainer.pokemonPcBill.add(p);
            insertTrainerPokemon(p, 2);
        }
        PokemonCRUD.readPokemonTeam();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainWindowSquirtle(ActionEvent event) throws IOException, CloneNotSupportedException {
        p = new Pokemon("Squirtle", 7, "doc/images/Squirtle.png", "doc/images/spritesback/3a-b__007__xy.gif",144,1, 48,50,65,64,43, 150, Type.WATER, Type.NOTHING, State.ALIVE, Sex.F, 0).clone();

        if(Trainer.getTrainer().numberBoundTeamFree() < 6) {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            insertTrainerPokemon(p, 1);
        }
        else{
            //SI NO HAY HUECO...
            Trainer.pokemonPcBill.add(p);
            insertTrainerPokemon(p, 2);
        }
        PokemonCRUD.readPokemonTeam();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainWindowCharmander(ActionEvent event) throws IOException, CloneNotSupportedException {
      //TODO SOLUCIONAR PARA QUE LOS POKEMON SE METAN EN EL ESPACIO DEL TEAM QUE TOCA
        //TODO CREO QUE ES MEJOR HACER UN DELETE Y UN INSERT, O DIRECTAMENTE PONER EL NUEVO POKENON EN EL BOUND QUE TOQUE O EN EL PCBILL SI NO CABE
        p = new Pokemon("Charmander", 4, "doc/images/Charmander.png", "doc/images/spritesback/3a-b__004__xy.gif",139,1, 52,60,43,50,65, 150, Type.WATER, Type.NOTHING, State.ALIVE, Sex.F, 0).clone();
        if(Trainer.getTrainer().numberBoundTeamFree() < 6) {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            insertTrainerPokemon(p, 1);
        }
        else{
            //SI NO HAY HUECO...
            Trainer.pokemonPcBill.add(p);
            insertTrainerPokemon(p, 2);
        }


        PokemonCRUD.readPokemonTeam();

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
