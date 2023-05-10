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
import org.thesummoners.model.trainer.Trainer;
import org.thesummoners.model.pokemon.Pokemon;

import java.io.IOException;
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
        Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);
        listTeamIntermediary.clear();
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 400, 440);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}