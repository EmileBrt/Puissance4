package com.example.puissance4tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.Objects;

public class controller {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    void GoToAI(ActionEvent event) throws IOException {
        System.out.println("GO TO AI");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("puissance4_view_AI.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void GoToLocalGame(ActionEvent event) throws IOException {
        System.out.println("GO TO LOCAL");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("puissance4_view_LOCAL.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void GoToTCP(ActionEvent event) throws IOException {
        System.out.println("GO TO TCP");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("puissance4_view_TCP.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void Menu(ActionEvent event) throws IOException {
        System.out.println("GO TO MENU");
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("puissance4_menu.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void OnClickGridRow(MouseEvent event) {
        Pane pane = (Pane) event.getSource();
        System.out.println("Bonjour");
        System.out.println(pane.getBoundsInParent());
        System.out.println(pane.getBoundsInLocal());
    }

    @FXML
    void Play_AI(ActionEvent event) {
        System.out.println("Not Coded Yet");
    }

    @FXML
    void Play_Local(ActionEvent event) {
        System.out.println("Not Coded Yet");
    }

    @FXML
    void Play_Tcp(ActionEvent event) {
        System.out.println("Not Coded Yet");
    }

}
