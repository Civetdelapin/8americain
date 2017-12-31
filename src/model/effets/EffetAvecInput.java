package model.effets;

import model.Joueur;

/**
 * Squelette pour les Effets ayant besoin d'�tre initialiser avec des donn�es
 * Utilisateur avant d'�tre jou�e.
 */
public abstract class EffetAvecInput extends Effet {

	public EffetAvecInput(int scoreValue) {
		super(scoreValue);

	}

	/**
	 * @param data
	 *            Les donn�es sous forme d'un tableau d'Entier, se r�f�rer aux
	 *            classes qui h�ritent EffetAvecInput afin de conna�tre ce qu'elles
	 *            repr�sentent.
	 * @param joueurCourant
	 *            Le joueur qui joue la Carte.
	 * @throws ErreurDonneesEffet
	 *             Est lev�e si les donn�es pass�es ne sont pas conformes.
	 */
	public abstract void setData(Integer[] data, Joueur joueurCourant) throws ErreurDonneesEffet;

	/**
	 * Remet � z�ro les donn�es de la classe.
	 */
	public abstract void resetData();

}
