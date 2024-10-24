module com{
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires eu.hansolo.medusa;

    opens com to javafx.fxml;
    exports com;
}