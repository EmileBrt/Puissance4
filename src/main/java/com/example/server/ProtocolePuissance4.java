package com.example.server;

import com.example.board.Board;
import com.example.puissance4tcp.IContext;
import com.example.puissance4tcp.IProtocole;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;



public class ProtocolePuissance4 implements IProtocole {

    Board board;
    int previous_row;
    int previous_col;


    public  ProtocolePuissance4 (){
        this.board = new Board();
    }

    public void execute(IContext c , InputStream unInput , OutputStream unOutput ) {

        String inputReq;
        BufferedReader is = new BufferedReader(new InputStreamReader(
                unInput));
        PrintStream os = new PrintStream(unOutput);

        /**
         * Tant que personne n'a gagné le serveur continue de répondre au requête
         */
        while (board.Win() == 0){
            try {
                String valeurExpediee = "";

                if ((inputReq = is.readLine()) != null) {
                    System.out.println(" Ordre Recu " + inputReq);
                    String chaines[] = inputReq.split(" ");
                    if(chaines[1] =="update"){
                        valeurExpediee = String.valueOf(previous_col) + " " + String.valueOf(previous_row);
                    }
                    else if(chaines[1] != String.valueOf(board.To_Play)){
                        valeurExpediee = "Ce n'est pas à toi de jouer";
                    }
                    else if(board.Playable(Integer.parseInt(chaines[2])) == Boolean.FALSE){
                        valeurExpediee = "Le coup n'est pas jouable";
                    }
                    else {
                        previous_col = Integer.parseInt(chaines[2]);
                        previous_row = board.Next_Row(previous_col);
                        board.Play_Piece(previous_col,Integer.parseInt(chaines[1]));
                        valeurExpediee = String.valueOf(previous_col) + " " + String.valueOf(previous_row);
                    }

                    System.out.println(" Reponse serveur "	+ valeurExpediee);
                    os.println(valeurExpediee);
                }


            } catch ( Exception e) {
                System.out.println(" Pb d'exception ");
            }

        }
    }
}