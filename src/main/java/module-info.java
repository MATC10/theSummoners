module theSummoners {
    requires javafx.fxml;
    requires javafx.controls;

    opens org.thesummoners.model;
    opens org.thesummoners.controller;
    opens org.thesummoners.model.movement;
}
