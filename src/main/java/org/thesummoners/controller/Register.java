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

public class Register {
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private ImageView imgPurple;
    @FXML
    private TextField txtPass2;
    @FXML
    private Label lblErrorRegister;
    @FXML
    private Button btnRegister;
    @FXML
    private Hyperlink hlLogin;
    @FXML
    private ImageView imgSummonersLogo;

    private Parent root;
    private Scene scene;
    private Stage stage;


    public void initialize() {
        File file = new File("doc/images/otherimages/TheSummonersfondo.png");
        Image image = new Image(file.toURI().toString());
        imgPurple.setImage(image);

        File file1 = new File("doc/images/otherimages/TheSummoners_logo.png");
        Image image1 = new Image(file1.toURI().toString());
        imgSummonersLogo.setImage(image1);
    }

    /**
     *     Si la contraseña 1 y 2 coinciden y el usuario no es null, se procede al registro y se vuelve al login
     *     Y se guardan estas credenciales en los atributos del Trainer.
     */
    @FXML
    public void onRegister(ActionEvent event) throws IOException {

        if(txtPass.getText().equals(txtPass2.getText()) && txtUser.getText().length() != 0){
            Trainer.getTrainer().setName(txtUser.getText());
            Trainer.getTrainer().setPassword(txtPass.getText());

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml")));
            scene = new Scene(root, 515, 412);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
        }
        else lblErrorRegister.setText("Las contraseñas introducidas no coincide, vuélvalo a intentar");
    }

    //Se vuelve al login si ya estás registrado
    @FXML
    public void toLogin(ActionEvent event) throws IOException {

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Login.fxml")));
            scene = new Scene(root, 515, 412);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();

    }


}
