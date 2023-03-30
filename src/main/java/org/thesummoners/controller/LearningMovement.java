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
    private Button btnNoMove;
    @FXML
    private Button btnMove1;
    @FXML
    private Button btnMove2;
    @FXML
    private Button btnMove3;
    @FXML
    private Button btnMove4;
    @FXML
    private Label lblNewMove;


    private Pokemon pokemon = new Pokemon("Pikachu");
    private AttackMovement ataque1 = new AttackMovement ("Bomba Lodo", 5, Type.NORMAL);
    private AttackMovement ataque2 = new AttackMovement ("Pistola Agua", 5, Type.NORMAL);


    @FXML
    public void initialize(){
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
        lblNewMove.setText(ataque2.getName());
    }
    @FXML
    public void setMove1() {
        pokemon.assignMovement1(ataque2);
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
        //AQUÍ TIENE QUE SALIR UNA VENTANA CON !ENHORABUENA! TU POKEMON HA APRENDENDIDO *EL ATAQUE*
       // Y LUEGO QUE SE CIERRE ESTA VENTANA Y LA OTRA
    }


    @FXML
    public void setMove2() {
        pokemon.assignMovement1(ataque2);
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
    }
    @FXML
    public void setMove3() {
        pokemon.assignMovement1(ataque2);
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
    }
    @FXML
    public void setMove4() {
        pokemon.assignMovement1(ataque2);
        btnMove1.setText(pokemon.getLearnedMovement1().getName());
    }

    @FXML
    public void setNoMove() {
        //AQUÍ TE SALES DE ESTA VENTANA Y VUELVES A LA ANTERIOR
    }

}
