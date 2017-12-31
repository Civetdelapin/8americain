package model.effets;

import model.Joueur;
import model.Message;

/**
 * Classe squelette repr�sentant un Effet li� � une Carte. Il poss�de une
 * m�thode action().
 *
 */
public abstract class Effet {
	/**
	 * La valeur de la carte, elle peut �tre fixe ou dynamique.
	 */
	protected int valeurScore;

	/**
	 * D�termine si la Carte est toujours posable ou bien suit les r�gles de posage
	 * classiques.
	 */
	private boolean alwaysPosable = false;

	/**
	 * R�alise l'effet ad�quat puis retourne un Message indiquant l'action
	 * effectu�e.
	 * 
	 * @param joueurCourant
	 *            Le joueur qui a jou� la Carte (et donc l'Effet).
	 * @return Le Message associ� � l'Effet, indique ce qu'il sait pass� gr�ce � son
	 *         Type.
	 */
	public abstract Message action(Joueur joueurCourant);

	public Effet(int scoreValue) {
		this.valeurScore = scoreValue;
	}

	public int getScoreValue() {
		return valeurScore;
	}

	public boolean isAlwaysPosable() {
		return alwaysPosable;
	}

	public void setAlwaysPosable(boolean bool) {
		alwaysPosable = bool;
	}

}
