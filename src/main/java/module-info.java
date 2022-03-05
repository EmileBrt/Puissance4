module com.example.puissance4tcp {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;
    requires junit;


    opens com.example.puissance4tcp to javafx.fxml;
    exports com.example.puissance4tcp;
}