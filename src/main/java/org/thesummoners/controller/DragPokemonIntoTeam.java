package org.thesummoners.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.pokemon.Pokemon;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;

public class DragPokemonIntoTeam {

    @FXML
    private Button btnToPcBill;

    @FXML
    private Button btnToPokemonTeam;

    @FXML
    private Button btnMainWindow;

    @FXML
    private Label lblPcBill;

    @FXML
    private Label lblPokemonTeam;

    @FXML
    private ListView<Pokemon> lvPcBill;

    @FXML
    private ListView<Pokemon> lvPokemonTeam;

    ObservableList<Pokemon> listTeamIntermediary = FXCollections.observableArrayList();

    private Parent root;
    private Scene scene;
    private Stage stage;

    public void initialize() {

        for(Pokemon p : Trainer.getTrainer().getPokemonTeam()) p = null;
        //TRAIGO LOS POKEMON DEL EQUIPO, SI LOS HUBIERA
        LinkedList<Pokemon> listaPokemon =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonTeam();
        for(int i = 0; i < Trainer.getTrainer().getPokemonTeam().length && i < listaPokemon.size(); i++)
            Trainer.getTrainer().getPokemonTeam()[i] = listaPokemon.get(i);

        //TRAIGO LOS POKEMON DEL PC, SI LOS HUBIERA
        Trainer.getTrainer().getPokemonPcBill().clear();
        LinkedList<Pokemon> miListaPc =  (LinkedList<Pokemon>) PokemonCRUD.readPokemonPcBill();
        Trainer.getTrainer().getPokemonPcBill().addAll(miListaPc);


        //LLAMAMOS AL MÉTODO QUE INSERTA EN LA LISTA listTeamIntermediary LOS POKÉMON DE pokemonTeam
        Trainer.getTrainer().pokemonTeamArrayToList(listTeamIntermediary);

        // ASOCIAMOS LA LISTA DE POKÉMON DE pcBill al ListView
        lvPcBill.setItems(Trainer.getTrainer().getPokemonPcBill());

        // ASOCIAMOS LA LISTA INTERMEDIA DE POKÉMON AL ListView
        lvPokemonTeam.setItems(listTeamIntermediary);
    }

    @FXML
    void toPcBill() {
        Pokemon selectedPokemon = lvPokemonTeam.getSelectionModel().getSelectedItem();
        if (listTeamIntermediary.size() > 1 && selectedPokemon != null) {
            // AGREGA EL POKÉMON SELECCIONADO A LA LISTA DE pcBill
            Trainer.getTrainer().getPokemonPcBill().add(selectedPokemon);
            // ELIMINA EL POKÉMON SELECCIONADO DE LA LISTA INTERMEDIA
            listTeamIntermediary.remove(selectedPokemon);
        }
    }

    @FXML
    void toPokemonTeam() {
        Pokemon selectedPokemon = lvPcBill.getSelectionModel().getSelectedItem();
        if (listTeamIntermediary.size() < 6 && selectedPokemon != null) {
            // AGREGA EL POKÉMON SELECCIONADO A LA LISTA INTERMEDIA
            listTeamIntermediary.add(selectedPokemon);
            // ELIMINA EL POKÉMON SELECCIONADO DE LA LISTA DE pcBill
            Trainer.getTrainer().getPokemonPcBill().remove(selectedPokemon);
        }
    }

    @FXML
    void toMainWindow(ActionEvent event) throws IOException {
        //BORRAMOS TODOS LOS REGISTROS
        PokemonCRUD.deleteAllPokemon();
        //AÑADIMOS LOS POKEMONS A NUESTRO ARRAY POKEMON
        Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);
        //AÑADIMOS LOS POKEMON DE NUESTRO ARRAY A LA BBDD
        PokemonCRUD.insertTrainerPokemonTeam(Trainer.getTrainer().getPokemonTeam());
        //AÑADIMOS POS POKEMON DE NUESTRO PCBILL A LA BBDD
        PokemonCRUD.insertPokemonPcBill(Trainer.getTrainer().getPokemonPcBill());

        listTeamIntermediary.clear();

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