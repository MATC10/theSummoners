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
    @FXML
    private Pokemon pokemon;


    //ESTA VENTANA SALDRÁ CUANDO UN POKÉMON LLEGUE A NIVEL DE APRENDER UN ATAQUE.

    private Pokemon pikachu = new Pokemon("Pikachu");
    private AttackMovement bombaLodo = new AttackMovement ("Bomba Lodo", 5, Type.NORMAL);
    private AttackMovement ataqueIgneo = new AttackMovement ("Ataque Igneo", 5, Type.FIRE);



    @FXML
    public void initialize(){
        if(pikachu.LearnedMovement(0) != null){
            btnMove1.setText(pikachu.LearnedMovement(0).getName());
            pikachu.setLevel(5);
        }
        if(pikachu.LearnedMovement(1) != null){
            btnMove2.setText(pikachu.LearnedMovement(1).getName());
        }
        if(pikachu.LearnedMovement(2) != null){
            btnMove3.setText(pikachu.LearnedMovement(2).getName());
        }
        if(pikachu.LearnedMovement(3) != null){
            btnMove4.setText(pikachu.LearnedMovement(3).getName());
        }
        //INDICAMOS QUÉ ATAQUE QUIERE APRENDER, HAY QUE QUITAR PIKACHU Y QUE APAREZCA EL POKEMON CON EL QUE ESTEMOS
        //COMBATIENDO
        lblNewMove.setText(pikachu.getMovementLevel().get(pikachu.getLevel()).getName());
    }
    @FXML
    public void setMove1() {
        pikachu.assignMovement(0);
        btnMove1.setText(pikachu.LearnedMovement(0).getName());
        //AQUÍ TIENE QUE SALIR UNA VENTANA CON !ENHORABUENA! TU POKEMON HA APRENDENDIDO *EL ATAQUE*
       // Y LUEGO QUE SE CIERRE ESTA VENTANA Y LA OTRA
    }


    @FXML
    public void setMove2() {
        pikachu.assignMovement(1);
        btnMove1.setText(pikachu.LearnedMovement(1).getName());
    }
    @FXML
    public void setMove3() {
        pikachu.assignMovement(2);
        btnMove1.setText(pikachu.LearnedMovement(2).getName());
    }
    @FXML
    public void setMove4() {
        pikachu.assignMovement(3);
        btnMove1.setText(pikachu.LearnedMovement(3).getName());

    }

    @FXML
    public void setNoMove() {
        //AQUÍ TE SALES DE ESTA VENTANA Y VUELVES A LA ANTERIOR
    }

}
