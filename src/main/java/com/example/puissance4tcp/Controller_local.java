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

public class Controller_local {

    Board board = new Board();

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


    @FXML
    void OnClickPane(ActionEvent event) {
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