package com.example.board;


import java.beans.PropertyChangeSupport;

public class Board {
    public Grille grille;
    public int To_Play;
    private Object NullPointerException;

    public Board(){
        /**
         * Le joueur numeroté 1 commence toujours la partie
         *
         * La grille est fixé à la taille du jeu originel 6x7
         */
        this.To_Play = 1;
        this.grille = new Grille(6,7);
    }

    public String toString(){
        /**
         * Ceux-ci est une métode facultative
         *
         * Elle nous a permis de tester nos logiques métiers avant la création de notre interface graphique
         */
        return this.grille.toString();
    }

    /**
     * Si un Joueur joue alors que ce n'est pas son tour,
     *celui-ci n'est pas pris en compte est un message est affiche en terminale.
     *Joue la piece dans matrice de la variable grille.
     */
    public void Play_Piece(int colonne,int player){
        if(player == this.To_Play){
            for(int i = 0; i < this.grille.hauteur;i++){
                if(this.grille.matrice[this.grille.hauteur - i - 1][colonne] == null){
                    this.grille.matrice[this.grille.hauteur - i - 1][colonne] = new Piece(player);
                    break;
                }
            }
            this.To_Play = 3 - this.To_Play; // Changement de Joueur && fonction vérifiant f(1)=2 & f(2) = 1 Thanks Math;
        }
        else {
            System.out.println("Not Yout time to Play CHEATER!");
        }
    }

    public Boolean Playable(int colonne){
        /**
         * @return Boolean True si le coup est jouable (il reste une place dans la colonne) False sinon
         */
        int cmp = 0;
        for(int i= 0 ; i < this.grille.hauteur; i ++){
            if(this.grille.matrice[i][colonne] != NullPointerException){
                cmp += 1;
            }
        }
        if(cmp == this.grille.hauteur){
            return Boolean.FALSE;
        }
        else {
            return Boolean.TRUE;
        }
    }

    public int Next_Row(int colonne){
        /**
         * @return le nombre de pièce dans une colonne
         */
        int res = 0;
        for(int i= this.grille.hauteur - 1 ; i != 0 ; i --){
            if(this.grille.matrice[i][colonne] == null){
                res = i;
                break;
            }
        }
        return res ;
    }

    public int Win(){
        /**
         * Les conditions de victoires ne sont pas encore optimales
         * Je n'ai pas réussi à les faire fonctionner parfaitement car j'ai rencontré des problèmes avec JUnit
         * @return True 1 si le joueur 1 a gagné, 2 si le joueur 2 a gagné, 0 sinon
         */
        // horizontale
        for(int i = 0;i < this.grille.hauteur ; i ++){
            int cpt_1 = 0;
            int cpt_2 = 0;
            for(int j = 0; j < this.grille.longueur; j++){
                if(this.grille.matrice[i][j] == null){
                    cpt_1 = 0;
                    cpt_2 = 0;
                }
                else if(this.grille.matrice[i][j].joueur == 1){
                    cpt_1 += 1;
                }
                else if(this.grille.matrice[i][j].joueur == 2){
                    cpt_2 += 1;
                }
                if(cpt_1 >= 4){
                    return  1;
                }
                if(cpt_2 >= 4){
                    return  2;
                }
            }
        }

        // Vertical
        for(int i = 0;i < this.grille.longueur ; i ++){
            int cpt_1 = 0;
            int cpt_2 = 0;
            for(int j = 0; j < this.grille.hauteur; j++){
                if(this.grille.matrice[j][i] == null){
                    cpt_1 = 0;
                    cpt_2 = 0;
                }
                else if(this.grille.matrice[j][i].joueur == 1){
                    cpt_1 += 1;
                }
                else if(this.grille.matrice[j][i].joueur == 2){
                    cpt_2 += 1;
                }
                if(cpt_1 >= 4){
                    return  1;
                }
                if(cpt_2 >= 4){
                    return  2;
                }
            }
        }

        /**
         * Les conditions de diagonale ne fonctionnnet pas correctement actuellement
         */

        // Diagonale - > \
        for(int i = 0;i < this.grille.longueur - this.grille.hauteur ; i ++){
            int cpt_1 = 0;
            int cpt_2 = 0;
            for(int j = 0; j < this.grille.hauteur; j++){
                if(this.grille.matrice[i+j][i+j] == null){
                    cpt_1 = 0;
                    cpt_2 = 0;
                }
                else if(this.grille.matrice[i+j][i+j].joueur == 1){
                    cpt_1 += 1;
                }
                else if(this.grille.matrice[i+j][i+j].joueur == 2){
                    cpt_2 += 1;
                }
                if(cpt_1 >= 4){
                    return  1;
                }
                if(cpt_2 >= 4){
                    return  2;
                }
            }
        }

        // Diagonale - > /
        for(int i = this.grille.hauteur;i < this.grille.longueur ; i ++){
            int cpt_1 = 0;
            int cpt_2 = 0;
            for(int j = 0; j < this.grille.hauteur; j++){
                if(this.grille.matrice[j][i-j] == null){
                    cpt_1 = 0;
                    cpt_2 = 0;
                }
                else if(this.grille.matrice[j][i-j].joueur == 1){
                    cpt_1 += 1;
                }
                else if(this.grille.matrice[j][i-j].joueur == 2){
                    cpt_2 += 1;
                }
                if(cpt_1 >= 4){
                    return  1;
                }
                if(cpt_2 >= 4){
                    return  2;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Board board = new Board();
        System.out.println(board);
        board.Play_Piece(1,1);
        board.Play_Piece(2,2);
        System.out.println(board);
        System.out.println(board.Win());

    }

}
