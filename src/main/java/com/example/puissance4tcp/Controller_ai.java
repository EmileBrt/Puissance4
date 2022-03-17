package com.example.puissance4tcp;
import com.example.board.Board;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;

import java.util.concurrent.TimeUnit;

public class Controller_ai extends ControllerABC{

    Board board = new Board();

    @FXML
    void OnClickPane(ActionEvent event) throws InterruptedException {
        System.out.println("Clicked On");

        Node node = (Node) event.getTarget();
        int col = 0;
        try{
            col = Integer.parseInt(node.getProperties().get("gridpane-column").toString());
        }
        catch (Exception ignored){}
        System.out.printf("Colonne %d Ligne %d%n",col,board.Next_Row(col));

        if(board.Playable(col) == Boolean.TRUE){
            Put_On_Grid(col,board.Next_Row(col), board.To_Play);
            board.Play_Piece(col,board.To_Play);
        }
        else {
            System.out.println("Le Colonne est pleine");
        }

        TimeUnit.MILLISECONDS.sleep(200);
        int rd = (int)(Math.random() * 7);
        while(board.Playable(rd) != Boolean.TRUE){
            rd = (int)(Math.random() * 7);
        }
        Put_On_Grid(rd,board.Next_Row(rd), board.To_Play);
        board.Play_Piece(rd,board.To_Play);
        TimeUnit.MILLISECONDS.sleep(200);


        if(board.Win() != 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Partie Terminée");
            alert.setHeaderText(null);
            alert.setContentText(
                    String.format("Le joueur %d a remporté la partie,\n pour rejouer, retourner à l'écran d'acceuil",board.Win())
            );
            alert.showAndWait();
        }
    }
}