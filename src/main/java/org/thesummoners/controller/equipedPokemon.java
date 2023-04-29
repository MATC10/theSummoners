package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class equipedPokemon {

    private VBox vbox;
    private MenuBar menuBar;
    private Label equiparObjeto;
    private Button atras;
    private Button adelante;
    private Button Equipar;
    private Button Desequipar;


    FXMLLoader loader = new FXMLLoader(getClass().getResource("equipedPokemon.fxml"));
    ScrollPane scrollPane = (ScrollPane) loader.load();

    public equipedPokemon() throws IOException {
    }


    @FXML
        void DesequiparButton(ActionEvent event) {
        }
        @FXML
        void EquiparButton(ActionEvent event) {
        }
        @FXML
        void VolverButton(ActionEvent event) {
        }
        @FXML
        void adelanteButton(ActionEvent event){
        }
        public void selectObject () {
        VBox vBox = new VBox();
        for (int i = 1; i <= 5; i++){
            Label label = new Label("Label" + i);
            vBox.getChildren().add(label);
        }
        ScrollPane scrollPane = new ScrollPane();
        Scene scene = new Scene(scrollPane);
    }

}
