module com.example.puissance4tcp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;
    requires java.desktop;


    opens com.example.puissance4tcp to javafx.fxml;
    exports com.example.puissance4tcp;
    exports com.example.server;
    opens com.example.server to javafx.fxml;
}