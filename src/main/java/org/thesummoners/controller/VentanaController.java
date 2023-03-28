package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import org.thesummoners.model.Pokemon;

public class VentanaController {
    @FXML
    private Button btnCrear;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNivel;
    @FXML
    private Label lblNombre;
    @FXML
    private Label lblNivel;

    //ESTO NO SE HACE AQUÍ
    private final Pokemon pokemon = new Pokemon();
    @FXML
    public void setPokemonProperties(){
        pokemon.setNombre(txtNombre.getText());
        txtNivel.setText(pokemon.getNombre());

    }

    @FXML
    public void setPokemonNivel(ActionEvent actionEvent) {
    }
    @FXML
    public void setPokemonNombre(ActionEvent actionEvent) {
    }
    @FXML
    public void onNombrePuesto(MouseEvent mouseEvent) {
    }
    @FXML
    public void onNivelPuesto(MouseEvent mouseEvent) {
    }
}
