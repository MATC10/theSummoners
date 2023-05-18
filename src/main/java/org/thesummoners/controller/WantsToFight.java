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
import javafx.stage.Stage;
import org.thesummoners.model.trainer.Enemy;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class WantsToFight {

    @FXML
    private ImageView imgEnemy;

    @FXML
    private Label lblWantsToFight;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void initialize() throws CloneNotSupportedException {

        Enemy.WantsToFightEnemy(imgEnemy, lblWantsToFight);
    }


    @FXML
    void toFight(ActionEvent event) throws IOException {
        //CAMBIAR MAINWINDOW POR TOFIGHT CUANDO HAGA LA OTRA VENTANA DE FIGHT
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Fight.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }


}
