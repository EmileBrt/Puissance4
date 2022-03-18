package com.example.puissance4tcp;

import com.example.board.Grille;

import java.beans.PropertyChangeSupport;
import java.util.ArrayList;

public class Joueur implements joueur.IJoueur {

    /**
     * Support du mécanisme Observable/Observer
     */
    private PropertyChangeSupport pcSupport;

    public int num;
    int hauteur;
    int longueur;
    Grille grille = new Grille(hauteur,longueur);

    public Joueur(int num) {
        pcSupport = new PropertyChangeSupport(this);
        this.num=num;
    }



    public PropertyChangeSupport getPropertyChangeSupport() {
        return pcSupport;
    }

    public void jouer(int colonne){

        pcSupport.firePropertyChange("colonne",null,colonne);

    }

    @Override
    public void jouer() {

    }
}

