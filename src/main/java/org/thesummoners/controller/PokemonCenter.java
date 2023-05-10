package org.thesummoners.controller;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.util.Objects;

public class PokemonCenter {

    @FXML
    private Button toMainMenu;

    @FXML
    private Button btnText;

    @FXML
    private Button btnHp;

    @FXML
    private TableColumn<Pokemon, Integer> tcHp;

    @FXML
    private TableColumn<Pokemon, String> tcName;

    @FXML
    private TableView<Pokemon> tvPokemonTeam;
    private Parent root;
    private Scene scene;
    private Stage stage;

    ObservableList<Pokemon> listTeamIntermediary = FXCollections.observableArrayList();

    public void initialize() {
        Trainer.getTrainer().pokemonTeamArrayToList(listTeamIntermediary);
        //CONFIGURAMOS LAS COLUMNAS DE LA TABLEVIEW
        tcName.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDisplayName()));
        tcHp.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getHp()).asObject());

        // METEMOS LA OBSERVABLELIST EN LA TABLEVIEW
        tvPokemonTeam.setItems(listTeamIntermediary);

        //PASAMOS LOS POKEMON DE LA LISTA AL EQUIPO POKEMON
        Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);

    }

    @FXML
    public void toHp() throws CloneNotSupportedException {

        // LLAMAMOS AL MÉTODO PARA CURAR A LOS POKEMON
        Trainer.getTrainer().centrePokemonHeal();

        // ACTUALIZAMOS LA LISTA
        listTeamIntermediary.clear();
        Trainer.getTrainer().pokemonTeamArrayToList(listTeamIntermediary);

        // ACTUALIZAMOS LA TABLEVIEW
        tvPokemonTeam.setItems(listTeamIntermediary);

        btnText.setText("Tus Pokémon se han curado y están listos para luchar");
    }

    @FXML
    public void toMainMenu(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
        listTeamIntermediary.clear();
    }
}
