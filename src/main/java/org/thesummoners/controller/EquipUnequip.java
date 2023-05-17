package org.thesummoners.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.thesummoners.bd.PokemonCRUD;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Objects;


public class EquipUnequip {

    @FXML
    private Button btnEquip;

    @FXML
    private Button btnMainMenu;

    @FXML
    private Button btnUnequip;

    @FXML
    private Label lblDisplayName;

    @FXML
    private Label lblNameObjeto;

    @FXML
    private Label lblText;

    @FXML
    private ListView<Objeto> lvObjeto;

    @FXML
    private ListView<Pokemon> lvPokemonTeam;

    private Parent root;
    private Scene scene;
    private Stage stage;

    ObservableList<Pokemon> listTeamIntermediary = FXCollections.observableArrayList();

    public void initialize() {
        listTeamIntermediary.clear();
        //LLAMAMOS AL MÉTODO QUE INSERTA EN LA LISTA listTeamIntermediary LOS POKÉMON DE pokemonTeam
        Trainer.getTrainer().pokemonTeamArrayToList(listTeamIntermediary);

        // ASOCIAMOS LA LISTA DE POKEMON al ListView
        lvPokemonTeam.setItems(listTeamIntermediary);

        // ASOCIAMOS LA LISTA DE MOCHILA DE OBJETOS A LA ListView
        lvObjeto.setItems(Trainer.getTrainer().getBackPack());



        //AGREGADO LISTENER A POKEMONTEAM
        lvPokemonTeam.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lblDisplayName.setText("Pokémon seleccionado: " + newValue.getDisplayName());
            }
        });

        //AGREGADO LISTENER A OBJETOS
        lvObjeto.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                lblNameObjeto.setText("Objeto seleccionado: " + newValue.getName());
            }
        });
    }

    @FXML
    void toEquip(ActionEvent event) throws CloneNotSupportedException {
        Pokemon selectedPokemon = lvPokemonTeam.getSelectionModel().getSelectedItem();
        Objeto selectedObjeto = lvObjeto.getSelectionModel().getSelectedItem();
        if(selectedPokemon != null || selectedPokemon != null){
            if (selectedPokemon != null && selectedObjeto != null && selectedPokemon.getObjeto() == null) {
                selectedPokemon.setObjetoImproveStats(selectedObjeto);
                Trainer.getTrainer().getBackPack().remove(selectedObjeto);
                Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);
                lblNameObjeto.setText("");
                lblDisplayName.setText("");
                lblText.setText("Has equipado a " + selectedPokemon.getDisplayName() + " con " + selectedPokemon.getObjeto().getName());
            }
            else if(selectedPokemon.getObjeto() != null){
                lblText.setText(selectedPokemon.getDisplayName() + " ya tiene equipado " + selectedPokemon.getObjeto().getName());
            }
        }
    }


    @FXML
    void toUnequip(ActionEvent event) throws CloneNotSupportedException {

        Pokemon selectedPokemon = lvPokemonTeam.getSelectionModel().getSelectedItem();
        if(selectedPokemon != null || selectedPokemon != null){
            if (selectedPokemon != null && selectedPokemon.getObjeto() != null) {
                Trainer.getTrainer().getBackPack().add(selectedPokemon.getObjeto());
                selectedPokemon.setObjetoImproveStats(null);
                Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);
                lblNameObjeto.setText("");
                lblDisplayName.setText("");
                lblText.setText("Has quitado el objeto a " + selectedPokemon.getDisplayName());
            }
            else if(selectedPokemon != null && selectedPokemon.getObjeto() == null){
                lblText.setText(selectedPokemon.getDisplayName() + " no tiene ningún objeto equipado");
            }
        }
    }

    @FXML
    void toMainMenu(ActionEvent event) throws IOException {
        listTeamIntermediary.clear();




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
