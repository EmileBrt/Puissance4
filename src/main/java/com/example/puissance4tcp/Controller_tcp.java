package com.example.puissance4tcp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class Controller_tcp extends ControllerABC{

    JoueurTCP monJoueur ;

    private int n_joueur;
    private  int n_port;
    private  String s_ipadress;

    @FXML
    private ChoiceBox<String> JoueurChoice;
    private String[] Player = {"Player One","Player Two"};
    public void initialize() {
        JoueurChoice.getItems().addAll(Player);
    }

    @FXML
    private TextField ipadress;

    @FXML
    private TextField port;

    @FXML
    void connect(ActionEvent event) {
        if(JoueurChoice.getValue() == "Player One"){
            n_joueur = 1;
        }
        if(JoueurChoice.getValue() == "Player Two"){
            n_joueur = 2;
        }
        n_port = Integer.parseInt(port.getText());
        s_ipadress = ipadress.getText();
        System.out.printf("Joueur numero : %d \nServeur : %s \n port : %d",n_joueur,s_ipadress,n_port);
        //monJoueur = new JoueurTCP(1,"localhost", 6666 );
        monJoueur = new JoueurTCP(n_joueur,s_ipadress,n_port );
    }




    @FXML
    void OnClickPane(ActionEvent event) {
        /**
         * Récupération de la colonne selectionnée
         */
        Node node = (Node) event.getTarget();
        String col;
        try{
            col = node.getProperties().get("gridpane-column").toString();
        }
        catch (Exception ignored){col = "0";}

        /**
         * Envoie au serveur du numéro du joueur et la colonne
         */

        String response = monJoueur.transmettreChaine(String.valueOf(n_joueur)+" "+col);
        System.out.println("Reponse serveur");
        System.out.println(response);


        /**
         * Affichage de message si victoire ou coup non jouable
         */
        if(response == "Ce n'est pas à toi de jouer"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Ce n'est pas à toi de jouer");
            alert.showAndWait();
        }
        if(response == "Le coup n'est pas jouable"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Attention");
            alert.setHeaderText(null);
            alert.setContentText("Le coup choisi n'est pas jouable");
            alert.showAndWait();
        }
        if(response == "Vous avez gagné"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Felicitation");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez gagné");
            alert.showAndWait();
        }


        /**
         * On récupère la réponse du serveur qui est "numéro_colonne numéro_ligne"
         * Puis on le joue dans l'interface graphique
         */
        try {
            int n_col;
            int n_row;
            // On met à jour l'interface graphique

            String[] parts = response.split(" ");
            n_col = Integer.parseInt(parts[1]);
            n_row = Integer.parseInt(parts[2]);

            Put_On_Grid(n_col,n_row,n_joueur);
        }
        catch(Exception e) {
            System.out.println("Pas d'envoi au serveur");
        }


        /**
         * Récupération du coup du 2ème joueur
         */
        String response_update = monJoueur.transmettreChaine("update");
        if(response_update == "Vous avez perdu"){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Dommage");
            alert.setHeaderText(null);
            alert.setContentText("Vous avez perdu");
            alert.showAndWait();
        }

        /**
         * On joue le coup du deuxième joueur dans notre IHM
         */
        try {
            int n_col;
            int n_row;
            // On met à jour l'interface graphique

            String[] parts = response_update.split(" ");
            n_col = Integer.parseInt(parts[1]);
            n_row = Integer.parseInt(parts[2]);

            Put_On_Grid(n_col,n_row,3 - n_joueur);
        }
        catch(Exception e) {
            System.out.println("Pas d'envoi au serveur");
        }
    }
}
