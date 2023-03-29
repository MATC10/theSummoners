package org.thesummoners.controller;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.thesummoners.model.AttackMovement;
import org.thesummoners.model.Pokemon;
import org.thesummoners.model.Type;

import java.util.Arrays;

public class LearningMovement {
    @FXML
    private TextField txtNewMove;
    @FXML
    private TextField txtMove1;
    @FXML
    private TextField txtMove2;
    @FXML
    private TextField txtMove3;
    @FXML
    private TextField txtMove4;
    @FXML
    private Button btnNoMove;
    @FXML
    private Button btnMove1;
    @FXML
    private Button btnMove2;
    @FXML
    private Button btnMove3;
    @FXML
    private Button btnMove4;

    private Parent root;

    private Scene scene;

    private Stage stage;

    private Pokemon pokemon = new Pokemon("Pikachu");
    private AttackMovement ataque1 = new AttackMovement ("Bomba Lodo", 5, Type.NORMAL);
    private AttackMovement ataque2 = new AttackMovement ("Pistola Agua", 5, Type.NORMAL);


    @FXML
    public void initialize(){
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
    }
    @FXML
    public void setMove1() {
        pokemon.assignMovement1(ataque2);
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
    }




    @FXML
    public void setNoMove() {

    }
    @FXML
    public void setMove2() {

    }
    @FXML
    public void setMove3() {

    }
    @FXML
    public void setMove4() {

    }


}
