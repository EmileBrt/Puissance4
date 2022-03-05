package com.example.board;

public class Piece {
    public int joueur; /*1 pour joueur 1 (rouge) et 2 pour joueur 2 (jaune)*/

    // Constructeur null
    public Piece(int joueur){
        this.joueur = joueur;
    }

    public String toString(){
        String S = new String();
        if(this.joueur == 1){
            S =  " x ";
        }
        if(this.joueur == 2){
            S =  " o ";
        }
        return S;
    }
}
