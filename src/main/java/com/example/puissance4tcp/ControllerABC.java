package com.example.puissance4tcp;

import com.example.board.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

public class ControllerABC {
    @FXML
    private GridPane grid;

    @FXML
    void Menu(ActionEvent event) throws IOException {
        System.out.println("GO TO LOCAL");
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("puissance4_menu.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    void Put_On_Grid(int i, int j, int joueur){
        InputStream input;
        if(joueur == 1){
            input = getClass().getResourceAsStream("JJP4.png");
        }
        else {
            input = getClass().getResourceAsStream("JRP4.png");
        }
        Image image = new Image(input, 48, 48,false,true);
        ImageView imv = new ImageView(image);
        grid.add(imv,i,j,1,1);
    }
}
