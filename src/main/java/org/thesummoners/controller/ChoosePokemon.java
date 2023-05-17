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
import java.util.LinkedList;
import java.util.List;
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
        p = PokemonCRUD.readPokemonSpecify("Pikachu");
        Trainer.getTrainer().setPokemon1(p);
        System.out.println(Trainer.getTrainer().getPokemonTeam()[5].getName());
        if(Trainer.getTrainer().getPokemonTeam()[5] != null) {
            PokemonCRUD.insertTrainerPokemon(p, 2);
        }
        else {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
           // Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
           PokemonCRUD.insertTrainerPokemon(p, 1);
        }

        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void toMainWindowBulbasaur(ActionEvent event) throws IOException, CloneNotSupportedException {
        p = PokemonCRUD.readPokemonSpecify("Bulbasaur");
        Trainer.getTrainer().setPokemon1(p);

        if(Trainer.getTrainer().getPokemonTeam()[5] != null) {
            PokemonCRUD.insertTrainerPokemon(p, 2);
        }
        else {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            // Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            PokemonCRUD.insertTrainerPokemon(p, 1);
        }

        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toMainWindowSquirtle(ActionEvent event) throws IOException, CloneNotSupportedException {

        p = PokemonCRUD.readPokemonSpecify("Squirtle");
        Trainer.getTrainer().setPokemon1(p);

        if(Trainer.getTrainer().getPokemonTeam()[5] != null) {
            PokemonCRUD.insertTrainerPokemon(p, 2);
        }
        else {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            // Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            PokemonCRUD.insertTrainerPokemon(p, 1);
        }

        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
            Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);

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
        p = PokemonCRUD.readPokemonSpecify("Charmander");
        Trainer.getTrainer().setPokemon1(p);

        if(Trainer.getTrainer().getPokemonTeam()[5] != null) {
            PokemonCRUD.insertTrainerPokemon(p, 2);
        }
        else {
            //INTRODUCIMOS EL POKEMON EN EL HUECO DE NUESTRO EQUIPO
            // Trainer.getTrainer().getPokemonTeam()[Trainer.getTrainer().numberBoundTeamFree()] = p;
            PokemonCRUD.insertTrainerPokemon(p, 1);
        }
        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;

        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);


        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);



        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/ChoosedPokemon.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
