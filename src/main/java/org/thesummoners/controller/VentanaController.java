package org.thesummoners.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class VentanaController {
    @FXML
    private Button btnCrear;
    @FXML
    private TextField textNombre;
    @FXML
    private TextField textNivel;

    @FXML
    public void setPokemonProperties(){
        String nombre =  textNombre.getText();
        int nivel = Integer.parseInt(textNivel.getText());
    }
}
