package org.thesummoners.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DataFormat;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.stage.Stage;
import org.thesummoners.model.pokemon.Bulbasaur;
import org.thesummoners.model.pokemon.Pikachu;
import org.thesummoners.model.pokemon.Pokemon;
import org.thesummoners.model.pokemon.PokemonInitialize;

import java.io.IOException;
import java.util.Objects;

public class DragPokemonIntoTeam {

    @FXML
    private Button btnToPcBill;

    @FXML
    private Button btnToPokemonTeam;

    @FXML
    private Button btnMainWindow;

    @FXML
    private Label lblPcBill;

    @FXML
    private Label lblPokemonTeam;

    @FXML
    private TableView<Pokemon> tvPcBill;

    @FXML
    private TableColumn<Pokemon, String> tcName;

    @FXML
    private TableColumn<Pokemon, String> tcLevel;

    @FXML
    private TableView<Pokemon> tvPokemonTeam;

    @FXML
    private TableColumn<Pokemon, String> tcNameTeamPokemon;

    @FXML
    private TableColumn<Pokemon, String> tcLevelTeamPokemon;



    private Parent root;
    private Scene scene;
    private Stage stage;

    //ESTO ES PARA QUE FUNCIONE EL ROW
    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

    public void initialize(){

        ObservableList <Pokemon> pokemonPcBill = FXCollections.observableArrayList();
        pokemonPcBill.addAll( new Pokemon("Bulbasaur", 4));

        tcName.setCellValueFactory(tf -> new SimpleStringProperty(tf.getValue().getDisplayName()));
        tcLevel.setCellValueFactory(tf -> new SimpleStringProperty("" + tf.getValue().getLevel()));

        tvPcBill.getColumns().addAll(tcName,tcLevel);
        tvPcBill.getItems().addAll(pokemonPcBill);



        tvPcBill.setRowFactory(tv -> {
                    TableRow<Pokemon> row = new TableRow<>();

                    row.setOnDragDetected(event -> {
                        if (!row.isEmpty()) {
                            Integer index = row.getIndex();
                            Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                            db.setDragView(row.snapshot(null, null));
                            ClipboardContent cc = new ClipboardContent();
                            cc.put(SERIALIZED_MIME_TYPE, index);
                            db.setContent(cc);
                            event.consume();
                        }
                    });

                    row.setOnDragOver(event -> {
                        Dragboard db = event.getDragboard();
                        if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                            if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                                event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                                event.consume();
                            }
                        }
                    });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    Pokemon draggedPokemon = tvPcBill.getItems().remove(draggedIndex);

                    int dropIndex ;

                    if (row.isEmpty()) {
                        dropIndex = tvPcBill.getItems().size() ;
                    } else {
                        dropIndex = row.getIndex();
                    }

                    tvPcBill.getItems().add(dropIndex, draggedPokemon);

                    event.setDropCompleted(true);
                    tvPcBill.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row ;
        });








        ObservableList <Pokemon> pokemonTeamPrueba = FXCollections.observableArrayList();
        pokemonTeamPrueba.addAll( new Pokemon("Pikachu", 100));

        tcNameTeamPokemon.setCellValueFactory(tf -> new SimpleStringProperty(tf.getValue().getDisplayName()));
        tcLevelTeamPokemon.setCellValueFactory(tf -> new SimpleStringProperty("" + tf.getValue().getLevel()));

        tvPokemonTeam.getColumns().addAll(tcNameTeamPokemon,tcLevelTeamPokemon);
        tvPokemonTeam.getItems().addAll(pokemonTeamPrueba);

        tvPokemonTeam.setRowFactory(tv -> {
            TableRow<Pokemon> row = new TableRow<>();

            row.setOnDragDetected(event -> {
                if (!row.isEmpty()) {
                    Integer index = row.getIndex();
                    Dragboard db = row.startDragAndDrop(TransferMode.MOVE);
                    db.setDragView(row.snapshot(null, null));
                    ClipboardContent cc = new ClipboardContent();
                    cc.put(SERIALIZED_MIME_TYPE, index);
                    db.setContent(cc);
                    event.consume();
                }
            });

            row.setOnDragOver(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    if (row.getIndex() != ((Integer)db.getContent(SERIALIZED_MIME_TYPE)).intValue()) {
                        event.acceptTransferModes(TransferMode.COPY_OR_MOVE);
                        event.consume();
                    }
                }
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                if (db.hasContent(SERIALIZED_MIME_TYPE)) {
                    int draggedIndex = (Integer) db.getContent(SERIALIZED_MIME_TYPE);
                    Pokemon draggedPokemon = tvPokemonTeam.getItems().remove(draggedIndex);

                    int dropIndex ;

                    if (row.isEmpty()) {
                        dropIndex = tvPokemonTeam.getItems().size() ;
                    } else {
                        dropIndex = row.getIndex();
                    }

                    tvPokemonTeam.getItems().add(dropIndex, draggedPokemon);

                    event.setDropCompleted(true);
                    tvPokemonTeam.getSelectionModel().select(dropIndex);
                    event.consume();
                }
            });

            return row ;
        });
    }

    @FXML
    void toPcBill(ActionEvent event) {

    }

    @FXML
    void toPokemonTeam(ActionEvent event) {

    }

    @FXML
    void toMainWindow(ActionEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/fxml/MainWindow.fxml")));
        scene = new Scene(root, 400, 440);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setTitle("TheSummoners");
        stage.setScene(scene);
        stage.show();
    }

}
