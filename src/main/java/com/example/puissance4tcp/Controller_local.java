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
import java.io.InputStream;
import java.util.Objects;

public class Controller_local {

    @FXML
    private GridPane grid;

    @FXML
    void Menu(ActionEvent event) throws IOException {
        System.out.println("GO TO LOCAL");
        Parent root = FXMLLoader.load(getClass().getResource("puissance4_menu.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void OnClickPane(ActionEvent event) {
        System.out.println("Clicked On");
        Node node = (Node) event.getTarget();
        System.out.println(node.getProperties().get("gridpane-column"));
    }

    void Put_On_Grid(int i, int j, int joueur){
        InputStream input;
        if(joueur == 1){
            input = getClass().getResourceAsStream("JJP4.png");
        }
        else {
            input = getClass().getResourceAsStream("JRP4.png");
        }
        Image image = new Image(input, 50, 50,false,true);
        ImageView imv = new ImageView(image);
        grid.add(imv,i,j,1,1);
    }
}