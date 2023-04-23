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
    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat(new String[]{"application/x-java-serialized-object"});

    public Shop() {
    }

    public void initialize() {
        this.tcName.setCellValueFactory((tf) -> {
            return new SimpleStringProperty(((Objeto)tf.getValue()).getName());
        });
        this.tcPrice.setCellValueFactory((tf) -> {
            return new SimpleStringProperty("1000");
        });
        this.tvObjeto.getColumns().clear();
        this.tvObjeto.getColumns().addAll(new TableColumn[]{this.tcName, this.tcPrice});
        this.tvObjeto.getItems().addAll(ObjetoInitializer.objetoList());
        this.tcNameBackPack.setCellValueFactory(new PropertyValueFactory("name"));
        this.tvBackPack.getColumns().clear();
        this.tvBackPack.getColumns().add(this.tcNameBackPack);
        this.tvBackPack.setItems(Trainer.getBackPack());
    }

    @FXML
    void onBuyObjeto() {
        Trainer.getTrainer().ObjetoShop(this.btnBuyObjeto, this.tvObjeto, this.tvBackPack);
    }

    @FXML
    void onBuyPokeball() {
    }

    @FXML
    void onMainMenu(ActionEvent event) throws IOException {
        this.root = (Parent)FXMLLoader.load((URL)Objects.requireNonNull(this.getClass().getResource("/fxml/MainWindow.fxml")));
        this.scene = new Scene(this.root, 600.0, 400.0);
        this.stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        this.stage.setTitle("TheSummoners");
        this.stage.setScene(this.scene);
        this.stage.show();
    }
}
