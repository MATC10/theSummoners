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
import org.thesummoners.model.Trainer;
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

    ObservableList <Pokemon> listTeamIntermediary = FXCollections.observableArrayList();



    private Parent root;
    private Scene scene;
    private Stage stage;

    //ESTO ES PARA QUE FUNCIONE EL ROW
    private static final DataFormat SERIALIZED_MIME_TYPE = new DataFormat("application/x-java-serialized-object");

    public void initialize(){
        //LLAMAMOS AL MÉTODO QUE INSERTA EN LA LISTA listTeamIntermediary LOS POKÉMON DE pokemonTeam
        Trainer.getTrainer().pokemonTeamArrayToList(listTeamIntermediary);

        //PONEMOS NOMBRE A LAS COLUMNAS DE tvPcBill Y ASOCIAMOS LA TABLA A LA LISTA
        tcName.setCellValueFactory(tf -> new SimpleStringProperty(tf.getValue().getDisplayName()));
        tcLevel.setCellValueFactory(tf -> new SimpleStringProperty("" + tf.getValue().getLevel()));
        tvPcBill.getColumns().clear();
        tvPcBill.getColumns().addAll(tcName,tcLevel);
        tvPcBill.getItems().addAll( Trainer.getTrainer().getPokemonPcBill());






        //PONEMOS NOMBRE A LAS COLUMNAS DE tvPokemonTeam Y ASOCIAMOS LA TABLA A LA LISTA
        tcNameTeamPokemon.setCellValueFactory(tf -> new SimpleStringProperty(tf.getValue().getDisplayName()));
        tcLevelTeamPokemon.setCellValueFactory(tf -> new SimpleStringProperty("" + tf.getValue().getLevel()));
        tvPokemonTeam.getColumns().clear();
        tvPokemonTeam.getColumns().addAll(tcNameTeamPokemon,tcLevelTeamPokemon);
        tvPokemonTeam.getItems().addAll(listTeamIntermediary);
/*
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
*/
            /*
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

*/







/*
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

    */
    }

    @FXML
    void toPcBill() {
        //TODO REVISAR POSIBLES BUGS
        btnToPcBill.setOnMouseClicked(event -> {
            //SOLAMENTE PODEMOS PASAR POKEMON HASTA UN MÁXIMO DE 6 AL EQUIPO POKÉMON
            if (listTeamIntermediary.size() > 1) {
                if (event.getClickCount() == 1) {
                    Pokemon selectedPokemon = tvPokemonTeam.getSelectionModel().getSelectedItem();
                    // AGREGA EL POKÉMON SELECCIONADO A LA LISTA NUEVA
                    Trainer.getTrainer().getPokemonPcBill().add(selectedPokemon);
                    // ACTUALIZA LA VISTA DE LA TABLEVIEW
                    tvPcBill.setItems( Trainer.getTrainer().getPokemonPcBill());
                    // ELIMINA EL POKÉMON SELECCIONADO DEL PC DE BILL
                    tvPokemonTeam.getItems().remove(selectedPokemon);
                    System.out.println(listTeamIntermediary.size());
                }
            }
        });
    }

    @FXML
    void toPokemonTeam() {
        //TODO REVISAR POSIBLES BUGS
        btnToPokemonTeam.setOnMouseClicked(event -> {
            //SOLAMENTE PODEMOS PASAR POKEMON HASTA UN MÁXIMO DE 6 AL EQUIPO POKÉMON
            if (listTeamIntermediary.size() < 6) {
            if (event.getClickCount() == 1) {
                Pokemon selectedPokemon = tvPcBill.getSelectionModel().getSelectedItem();
                    // AGREGA EL POKÉMON SELECCIONADO A LA LISTA NUEVA
                listTeamIntermediary.add(selectedPokemon);
                    // ACTUALIZA LA VISTA DE LA TABLEVIEW
                    tvPokemonTeam.setItems(listTeamIntermediary);
                    // ELIMINA EL POKÉMON SELECCIONADO DEL PC DE BILL
                    tvPcBill.getItems().remove(selectedPokemon);
                    Trainer.getTrainer().pokemonListToPokemonTeam(listTeamIntermediary);
                }
            }
        });
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
