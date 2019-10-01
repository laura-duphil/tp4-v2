/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bowling;

import bowling.MultiPlayerGame;

/**
 *
 * @author pedago
 */
public class Multijoueur implements MultiPlayerGame {
    
    private int scoreCourant =0;
    private int indiceJoueurCourant;
    private int nbJoueurs ;
    private String[] tabJoueurs ;  //tableau contenant le nom des joueurs
    private int numTour ;
    private int numBoule ;
    
    @Override
    public String startNewGame(String[] playerName) throws Exception {
        nbJoueurs = playerName.length;
        
        tabJoueurs = playerName ;
        if (nbJoueurs == 0)
            throw new Exception("Il faut qu'il y ai au moins un joueur.");
        
        String nomJoueur = playerName[0];
        numTour = 1;
        numBoule = 1;
        
        indiceJoueurCourant = 1 ;
        String phraseAAfficher = "Prochain tir : joueur " + nomJoueur + ", tour n° " + numTour + ", boule n° " + numBoule;
        numBoule++;
        return phraseAAfficher;
    }

    @Override
    public String lancer(int nombreDeQuillesAbattues) throws Exception {
        if (nombreDeQuillesAbattues < 0 || nombreDeQuillesAbattues > 10)
            throw new Exception("Nombre de quilles incohérent.");
        
        if (indiceJoueurCourant+1 >= nbJoueurs) {
            // on est au dernier joueur donc on passe au premier
            indiceJoueurCourant = 0;
        }
                
        String phraseAAfficher = "Prochain tir : joueur " + tabJoueurs[indiceJoueurCourant] + ", tour n° " + numTour + ", boule n° " + numBoule;
        if (numBoule%2 == 0) {
            //pair donc 2e boule
            numTour++;
            numBoule = 1;
        } else {
            numBoule = 2;
        }      
        return phraseAAfficher;
    }

    @Override
    public int scoreFor(String playerName) throws Exception {
        return scoreCourant ;
    }
    
}
