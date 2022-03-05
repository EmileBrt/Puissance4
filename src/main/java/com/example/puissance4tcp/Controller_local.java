package com.example.puissance4tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller_local {

    private Stage stage;
    private Scene scene;
    private Parent root ;

    @FXML
    public GridPane grid;


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
    void OnClickPane(MouseEvent event) throws IOException {
        System.out.println("Clicked ON");
        Display_Piece(0,0);
    }

    void Display_Piece(int i,int j) throws IOException {
        Image red = new Image("C:\\Users\\Emile\\IdeaProjects\\Puissance4\\src\\main\\resources\\com\\example\\puissance4tcp\\red.png");
        ImageView redView = new ImageView(red);
        grid.add(redView,i,j);

    }


}

