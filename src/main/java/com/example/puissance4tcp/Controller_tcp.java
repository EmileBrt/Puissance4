package com.example.puissance4tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_tcp {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    void Menu(ActionEvent event) throws IOException {
        System.out.println("GO TO LOCAL");

        root = FXMLLoader.load(getClass().getResource("puissance4_menu.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void OnClickGridRow(MouseEvent event) {
        System.out.println("Bonjour");

    }

    @FXML
    void Play_TCP(ActionEvent event) {
        System.out.println("Bonjour");

    }

}

