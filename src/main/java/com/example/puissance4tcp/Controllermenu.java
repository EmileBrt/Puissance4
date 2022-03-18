package com.example.puissance4tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class Controllermenu {

    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    void GoToLocalGame(ActionEvent event) throws IOException {
        System.out.println("GO TO LOCAL");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("puissance4_view_LOCAL.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void GoToAI(ActionEvent event) throws IOException {
        System.out.println("GO TO AI");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("puissance4_view_AI.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void GoToTCP(ActionEvent event) throws IOException {
        System.out.println("GO TO TCP");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("puissance4_view_TCP.fxml"));
        root = loader.load();
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
}
