package org.thesummoners.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.DataFormat;
import javafx.stage.Stage;
import org.thesummoners.model.objeto.Objeto;
import org.thesummoners.model.objeto.ObjetoInitializer;
import org.thesummoners.model.trainer.Trainer;

public class Shop {
    @FXML
    private Button btnBuyObjeto;
    @FXML
    private Button btnBuyPokeball;
    @FXML
    private Button btnMainMenu;
    @FXML
    private Label lblPokeballs;
    @FXML
    private Label lblPokedollars;
    @FXML
    private Label lblbuyOrNot;
    @FXML
    private TableColumn<Objeto, String> tcPrice;
    @FXML
    private TableColumn<Objeto, String> tcName;
    @FXML
    private TableColumn<Objeto, String> tcNameBackPack;
    @FXML
    private TableView<Objeto> tvBackPack;
    @FXML
    private TableView<Objeto> tvObjeto;
    private Parent root;
    private Scene scene;
    private Stage stage;




    public void initialize() {
        tcName.setCellValueFactory((tf -> new SimpleStringProperty(tf.getValue().getName())));

        tcPrice.setCellValueFactory((tf-> new SimpleStringProperty("500")));
        tvObjeto.getColumns().clear();
        tvObjeto.getColumns().addAll(tcName, tcPrice);
        tvObjeto.getItems().addAll(ObjetoInitializer.objetoList());
        tcNameBackPack.setCellValueFactory(new PropertyValueFactory("name"));
        tvBackPack.getColumns().clear();
        tvBackPack.getColumns().add(tcNameBackPack);
        tvBackPack.setItems(Trainer.getBackPack());




        //MOSTRAMOS LAS POKEBALL Y POKEDOLLARS
        lblPokeballs.setText("Pokeball disponibles " + Trainer.getTrainer().getPokeball());
        lblPokedollars.setText("Pokedollar disponibles " + Trainer.getTrainer().getPokedollar());
    }

    @FXML
    void onBuyObjeto() {
        Trainer.getTrainer().objetoShop(btnBuyObjeto, tvObjeto, tvBackPack, lblPokedollars, lblbuyOrNot);
    }

    @FXML
    void onBuyPokeball() {
        Trainer.getTrainer().pokeballShop(lblPokeballs, lblPokedollars, lblbuyOrNot);
    }

    @FXML
    void onMainMenu(ActionEvent event) throws IOException {
        this.root = FXMLLoader.load(Objects.requireNonNull(this.getClass().getResource("/fxml/MainWindow.fxml")));
        this.scene = new Scene(this.root, 600.0, 400.0);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.setTitle("TheSummoners");
        this.stage.setScene(scene);
        this.stage.show();

    }
}
