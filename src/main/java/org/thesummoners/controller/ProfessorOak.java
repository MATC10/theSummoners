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
import javafx.stage.Stage;
import org.thesummoners.model.trainer.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ProfessorOak {
    @FXML
    private ImageView imgProfesorOak;
    @FXML
    private Label lblProfesorOak;
    @FXML
    private Button btnNext;

    private int counter;
    private Parent root;
    private Scene scene;
    private Stage stage;

    @FXML
    public void initialize(){
    //LA PRIMERA VEZ QUE SE INICIE EL JUEGO SALDRÁ UNA IMAGEN Y UN TEXTO DEL PROFESOR OAK
    if(counter == 0){
        counter++;
        File file = new File("doc/images/Profesor_Oak.png");
        Image image = new Image(file.toURI().toString());
        imgProfesorOak.setImage(image);

        lblProfesorOak.setText("¡Hola " + Trainer.getTrainer().getName() + "! \n" +
                "¡Perdona por la espera! ¡Estás en el mundo de los Pokémon! \n" +
                "Me llamo Oak. Este mundo está habitado por unas criaturas \n" +
                "llamadas Pokémon. " +
                "La gente y los Pokémon conviven \n" +
                "ayudándose unos a otros. " +
                "Algunos juegan con los Pokémon, \n" +
                "otros luchan con ellos. \n" +
                "" +
                "Pero aún hay muchas cosas que no sabemos. \n" +
                "Tu propia historia Pokémon está a punto de empezar. \n" +
                "¡Te espera un mundo de sueños y aventuras con Pokémon! \n" +
                "¡Vamos! ¡Nos vemos!");
    }

    }
    @FXML
    public void toPokeball(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Pokeball.fxml")));
        scene = new Scene(root, 600, 400);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }
}
