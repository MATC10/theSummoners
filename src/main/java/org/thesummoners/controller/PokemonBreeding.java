package org.thesummoners.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.thesummoners.model.Objeto;
import org.thesummoners.model.Pokemon;
import org.thesummoners.model.Trainer;

import java.util.LinkedList;
import java.util.List;

import static org.thesummoners.model.Trainer.getTrainer;
public class PokemonBreeding {
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Label lbl1;

   //CREO VARIOS POKEMON Y AL ENTRENADOR PARA PROBAR
    private Pokemon pokemon1 = new Pokemon("Bulbasaur", 1);
    private Pokemon pokemon2 = new Pokemon("Pikachu", 1);
    private Pokemon pokemon3 = new Pokemon("Blastoise", 1);
    private Pokemon pokemon4 = new Pokemon("Venusaur", 1);
    private Pokemon pokemon5 = new Pokemon("Voltorb", 1);
    private Pokemon pokemon6 = new Pokemon("Mewtwo", 1);
    private  Pokemon [] pokemonTeam = new Pokemon[6];
    private List<Pokemon> pokemonBox = new LinkedList<>();
    private List<Objeto> backPack = new LinkedList<>();


    public void initialize(){
        Trainer.getTrainer().setName("MATC10");
        Trainer.getTrainer().setPokemonTeam(pokemonTeam);
        Trainer.getTrainer().setPokemonBox(pokemonBox);
        Trainer.getTrainer().setPokedollar(1000);
        pokemonTeam[0] = pokemon1;
        pokemonTeam[1] = pokemon2;
        pokemonTeam[2] = pokemon3;
        pokemonTeam[3] = pokemon4;
        pokemonTeam[4] = pokemon5;
        pokemonTeam[5] = pokemon6;
        btn1.setText(pokemonTeam[0].getName());
        btn2.setText(pokemonTeam[1].getName());
        btn3.setText(pokemonTeam[2].getName());
        btn4.setText(pokemonTeam[3].getName());
        btn5.setText(pokemonTeam[4].getName());
        btn6.setText(pokemonTeam[5].getName());
    }

    @FXML
    public void pokemonBreeding1(){

    }
}
