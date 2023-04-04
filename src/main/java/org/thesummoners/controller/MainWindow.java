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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.thesummoners.model.Trainer;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


public class MainWindow {
    @FXML
    private Button btcCatch;

    @FXML
    private Button btnBattle;

    @FXML
    private Button btnBreeding;

    @FXML
    private Button btnPCBill;

    @FXML
    private Button btnShop;

    @FXML
    private Button btnTeam;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    void toDragPokemonIntoBox(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/DragPokemonIntoBox.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
