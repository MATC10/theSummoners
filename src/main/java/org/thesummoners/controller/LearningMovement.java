package org.thesummoners.controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import org.thesummoners.model.movement.AttackMovement;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.Sex;
import org.thesummoners.model.pokemon.State;
import org.thesummoners.model.pokemon.Type;
import org.thesummoners.model.trainer.Trainer;

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
    private Label lblText;
    @FXML
    private Pokemon pokemon;


    //ESTA VENTANA SALDRÁ CUANDO UN POKÉMON LLEGUE A NIVEL DE APRENDER UN ATAQUE.

    private Pokemon pikachu = new Pokemon("Pikachu", 25, "doc/images/Pikachu.png", "doc/images/spritesback/3a-b__025__xy.gif",135,1, 55,50,40,50,90, 150, Type.ELECTRIC, null, State.ALIVE, Sex.F, 0, null);
    private AttackMovement bombaLodo = new AttackMovement ("Bomba Lodo", 5, Type.NORMAL);
    private AttackMovement ataqueIgneo = new AttackMovement ("Ataque Igneo", 5, Type.FIRE);

    public LearningMovement() throws CloneNotSupportedException {
    }


    @FXML
    public void initialize() throws CloneNotSupportedException {

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
    public void toMainWindow() {
        //AQUÍ TE SALES DE ESTA VENTANA Y VUELVES A LA ANTERIOR
    }


}
