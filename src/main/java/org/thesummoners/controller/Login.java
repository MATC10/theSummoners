package org.thesummoners.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.thesummoners.model.Trainer;

import java.io.IOException;
import java.util.Objects;

public class Login {
    @FXML
    private TextField txtUser;
    @FXML
    private TextField txtPass;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblStatus;
    @FXML
    private Label lblConnectedOrNot;
    @FXML
    private Hyperlink hlRegister;

    private Parent root;
    private Scene scene;
    private Stage stage;


    @FXML
    public void Login(ActionEvent event) throws IOException {
        //Si el el usuario es el mismo que el nombre del Trainer registrado anteriormente y que la contraseña del
        //Trainer, entonces puede acceder al MainWindow

        if(txtUser.getText().equals(Trainer.getTrainer().getName()) && txtPass.getText().equals(Trainer.getTrainer().getPassword())){
            lblStatus.setText("Conectado");
            lblStatus.setTextFill(Color.GREEN);

            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
            scene = new Scene(root, 600, 400);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
            }
        else lblConnectedOrNot.setText("Usuario o contraseña incorrectos");
    }

    public void hlRegister(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/Register.fxml")));
        scene = new Scene(root, 400, 440);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }



}
