package model;

import java.util.ArrayList;
import java.util.List;

public class Joueur {

	/**
	 * Pseudo du Joueur
	 */
	private String pseudo;

	/**
	 * Score du Joueur
	 */
	private int score = 0;

	/**
	 * Indique si le Joueur peut jouer son tour.
	 */
	private boolean peutJouer = true;

	/**
	 * Indique si le jouer � l'immunit� (a anonc� Carte!).
	 */
	private boolean peutFinir = false;

	/**
	 * Main du Joueur, les cartes qu'il poss�de.
	 */
	private List<Carte> main = new ArrayList<Carte>();

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

	public boolean isPeutFinir() {
		return peutFinir;
	}

	public void setPeutFinir(boolean peutFinir) {
		this.peutFinir = peutFinir;
	}

	/**
	 * Ajoute le score au score du Joueur.
	 * 
	 * @param add
	 *            Le score � ajouter.
	 */
	public void addScore(int add) {
		score += add;
	}

	/**
	 * R�initialise le score du Joueur � 0.
	 */
	public void resetScore() {
		score = 0;
	}

}
