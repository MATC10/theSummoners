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
import org.thesummoners.model.Enemy;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;

public class WantsToFight {
    @FXML
    private Button btnFight;

    @FXML
    private ImageView imgEnemy;

    @FXML
    private Label lblWantsToFight;
    private Parent root;
    private Scene scene;
    private Stage stage;
    Random aleatorio = new Random();

    @FXML
    public void initialize(){
        int arrayValor = aleatorio.nextInt(10);
        Enemy.enemyArray[0] = new Enemy("Pescador", "doc/images/pescador.png");
        Enemy.enemyArray[1] = new Enemy("Entre.guay", "doc/images/entreGuay.png");
        Enemy.enemyArray[2] = new Enemy("Marinero", "doc/images/marinero.png");
        Enemy.enemyArray[3] = new Enemy("Caza bichos", "doc/images/cazaBichos.png");
        Enemy.enemyArray[4] = new Enemy("Pokemaniaco", "doc/images/pokemaniaco.png");
        Enemy.enemyArray[5] = new Enemy("Científico loco", "doc/images/cientifico.png");
        Enemy.enemyArray[6] = new Enemy("Calvo con cresta", "doc/images/calvo.png");
        Enemy.enemyArray[7] = new Enemy("Súper nerd", "doc/images/superNerd.png");
        Enemy.enemyArray[8] = new Enemy("Pokecolector", "doc/images/pokecolector.png");
        Enemy.enemyArray[9] = new Enemy("Malabarista", "doc/images/malabarista.png");


        File file = new File(Enemy.enemyArray[arrayValor].getImage());
        Image image = new Image(file.toURI().toString());
        imgEnemy.setImage(image);

        lblWantsToFight.setText("¡" + Enemy.enemyArray[arrayValor].getName() + " quiere luchar!");
    }


    @FXML
    void toFight(ActionEvent event) throws IOException {
        //CAMBIAR MAINWINDOW POR TOFIGHT CUANDO HAGA LA OTRA VENTANA DE FIGHT
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }


}
