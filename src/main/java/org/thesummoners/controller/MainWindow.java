package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;


public class MainWindow {
    @FXML
    private Button btnCatch;

    @FXML
    private Button btnBattle;

    @FXML
    private Button btnBreeding;

    @FXML
    private Button btnPCBill;
    @FXML
    private ImageView imgSummonersLogo;
    @FXML
    private ImageView imgBackground;

    @FXML
    private Button btnPokemonCenter;

    @FXML
    private Button btnShop;

    @FXML
    private Button btnTeam;

    @FXML
    private Button btnEquipUnequip;

    @FXML
    private Label lblText;

    @FXML
    private Button btnTrain;
    private Parent root;
    private Scene scene;
    private Stage stage;
    @FXML
    public void initialize(){
        File file = new File("doc/images/otherimages/TheSummoners_logo.png");
        Image image = new Image(file.toURI().toString());
        imgSummonersLogo.setImage(image);

        File file1 = new File("doc/images/otherimages/TheSummonersfondo.png");
        Image image1 = new Image(file1.toURI().toString());
        imgBackground.setImage(image1);
    }

    @FXML
    void toDragPokemonIntoBox(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/DragPokemonIntoTeam.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void toWantsToFight(ActionEvent event) throws IOException {
        //COMPROBAMOS QUE HAYA POKEMONS EN EL EQUIPO
        if(Trainer.getTrainer().pokemonAliveInTeam()){
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/WantsToFight.fxml")));
            scene = new Scene(root, 600, 400);
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
        }
        else lblText.setText("No tienes ningún Pokémon disponible. ¡Ve al centro Pokémon!");


    }

    @FXML
    void onCatchPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Catch.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onPokemonStats(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonTeam.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void toBreedPokemon(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonBreeding.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onMainWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Shop.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void onTrain(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Train.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toPokemonCenter(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/PokemonCenter.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void toEquipUnequip(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/EquipUnequip.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}
