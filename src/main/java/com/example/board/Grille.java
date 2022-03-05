package com.example.board;

public class Grille{
    public int hauteur;
    public int longueur;
    public Piece[][] matrice;

    public Grille(int hauteur, int longueur) {
        this.hauteur = hauteur;
        this.longueur = longueur;
        this.matrice = new Piece[this.hauteur][this.longueur];
    }

    public String toString(){
        StringBuilder S = new StringBuilder();

        for (int i =0; i < this.hauteur;i++){

            for (int j =0; j < this.longueur;j++) {


                if(this.matrice[i][j] != null){
                    S.append(this.matrice[i][j].toString());
                }
                else {
                    S.append(" . ");
                }

            }
            S.append("\n");
        }
        return S.toString();
    }

}