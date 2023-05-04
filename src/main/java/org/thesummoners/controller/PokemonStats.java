package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import java.util.TreeMap;

public class PokemonStats {
    @FXML
    private Label lblHP;
    @FXML
    private Label lblAttack;
    @FXML
    private Label lblDefense;
    @FXML
    private Label lblSpecialAttack;
    @FXML
    private Label lblSpecialDefense;
    @FXML
    private Label lblSpeed;
    @FXML
    private Label lblMovement1;
    @FXML
    private Label lblMovement2;
    @FXML
    private Label lblMovement3;
    @FXML
    private Label lblMovement4;
    @FXML
    private Label lblObjeto;

    @FXML
    private Label lblStatsPokemonName;
    @FXML
    private ImageView imgPokemonStats;
    @FXML
    private Button btnMainWindow;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void initialize() {
        if (Trainer.getTrainer().pokemonCub[0] != null) {
            lblHP.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getHp()));
            lblAttack.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getAttackPower()));
            lblDefense.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getDefense()));
            lblSpecialAttack.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpecialAttack()));
            lblSpecialDefense.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpecialDefense()));
            lblSpeed.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getSpeed()));
            Trainer.getTrainer().pokemonCub[0].changeDisplayName();
            lblStatsPokemonName.setText(Trainer.getTrainer().pokemonCub[0].getDisplayName());

            File file = new File(Trainer.getTrainer().pokemonCub[0].getImage());
            Image image = new Image(file.toURI().toString());
            imgPokemonStats.setImage(image);
            //COMPRUEBA QUE TENGA OBJETO
            if (Trainer.getTrainer().pokemonCub[0].getObjeto() != null)
                lblObjeto.setText(String.valueOf(Trainer.getTrainer().pokemonCub[0].getObjeto()));
            else
                lblObjeto.setText("No tiene ningún objeto");

            //COMPRUEBA SI TIENE MOVIMIENTOS
            if (Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0] != null)
                lblMovement1.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
            else
                lblMovement1.setText("Movimiento sin apender");
            if (Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[1] != null)
                lblMovement2.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
            else
                lblMovement2.setText("Movimiento sin apender");
            if (Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[2] != null)
                lblMovement3.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
            else
                lblMovement3.setText("Movimiento sin apender");
            if (Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[3] != null)
                lblMovement4.setText(Trainer.getTrainer().pokemonCub[0].getLearnedMovement()[0].getName());
            else
                lblMovement4.setText("Movimiento sin apender");

        }
    }
    @FXML
    void toMainWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }


}
