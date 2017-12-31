package model;

import java.util.ArrayList;
import java.util.List;


public class Joueur {
    
    private String pseudo;
	private int score = 0;
    private boolean peutJouer = true;
    private boolean peutFinir = false;
    private List<Carte> main = new ArrayList<Carte> ();
    
	public Joueur(String pseudo) {
    	this.pseudo = pseudo;
    }
    
    public boolean isPeutJouer() {
		return peutJouer;
	}

	public void setPeutJouer(boolean peutJoueur) {
		this.peutJouer = peutJoueur;
	}
	
	public List<Carte> getMain() {
		return main;
	}
	
	public String getPseudo() {
		return pseudo;
	}

	public int getScore() {
		return score;
	}
	

	public void addScore(int add) {
		score += add;
	}

	public void resetScore() {
		score = 0;
	}

	public boolean isPeutFinir() {
		return peutFinir;
	}

	public void setPeutFinir(boolean peutFinir) {
		this.peutFinir = peutFinir;
	}
	
	
}
