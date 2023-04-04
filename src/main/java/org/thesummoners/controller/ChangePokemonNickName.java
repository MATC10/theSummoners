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
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import org.thesummoners.model.Pokemon;
import org.thesummoners.model.Trainer;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
public class ChangePokemonNickName {
    @FXML
    private TextField txtNickName;
    @FXML
    private Label lblVerify;
    @FXML
    private Button btnConfirm;
    @FXML
    private ImageView imgPokemon;
    private Parent root;
    private Scene scene;
    private Stage stage;


    @FXML
    public void initialize(){
        File file = new File("doc/images/" + Trainer.getTrainer().getPokemonTeam()[0].getName() + ".png");
        Image image = new Image(file.toURI().toString());
        imgPokemon.setImage(image);
    }

    @FXML
    public void toConfirm (ActionEvent event) throws IOException{
        //SI EL NICK NO ES ADECUADO SE MODIFICA EL LABEL TRAS DAR A CONFIRMAR
        //SI EL NICK ES CORRECTO PASA A LA MainWindow TRAS DAR A CONFIRMAR
        //esto es una prueba
        if(txtNickName.getText().equals("error")){
            lblVerify.setText("El mote que has elegido no es adecuado");
            lblVerify.setTextFill(Color.RED);
        }
        else{
            root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
            scene = new Scene(root, 600, 400);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setTitle("TheSummoners");
            stage.setScene(scene);
            stage.show();
        }

    }
}
