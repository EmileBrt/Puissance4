package com.example.puissance4tcp;

import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_local {
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
    void OnClickPane(MouseEvent event) {
        System.out.println("Clicked ON");
    }

}

