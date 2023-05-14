module theSummoners {
    requires javafx.fxml;
    requires javafx.controls;
    requires java.sql;
    requires mysql.connector.j;

    opens org.thesummoners.model;
    opens org.thesummoners.controller;
    opens org.thesummoners.model.movement;
    opens org.thesummoners.model.objeto;
    opens org.thesummoners.model.pokemon;
    opens org.thesummoners.model.trainer;
}
