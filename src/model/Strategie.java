package model;

/**
 * Impl�mentation du pattern Strat�gie. Utilis� ici pour cr�er deux style de
 * jeu, le style Agressif ou Passif. Cette classe contient les m�thodes
 * utilis�es par les JoueurArtificiel lorsqu'un choix doit �tre fait.
 */
public interface Strategie {

	/**
	 * Retourne la carte qui va �tre jouer.
	 * 
	 * @param joueurCourant
	 *            Le joueur qui choisi.
	 * @return La Carte choisie.
	 */
	public Carte choisirCarteStrategie(Joueur joueurCourant);

	/**
	 * Retourne le choix du joueur et de la carte � donner.
	 * 
	 * @param joueurCourant
	 *            Le joueur qui choisi.
	 * @return Un tableau d'entier repr�sentant l'index du joueur � qui donner la
	 *         carte et l'index de la carte � donner.
	 */
	public Integer[] choisirDataDonner(Joueur joueurCourant);

	/**
	 * Retourne la nouvelle couleur choisie.
	 * 
	 * @param joueurCourant
	 *            Le joueur qui choisi.
	 * @return Un tableau d'entier repr�sentant la nouvelle couleur choisie.
	 */
	public Integer[] choisirDataChangerCouleur(Joueur joueurCourant);

	/**
	 * Retourne une annonce, si ne veut plus faire d'annonce, renvoie null.
	 * 
	 * @param joueurCourant
	 *            Le joueur qui choisi.
	 * @return L'annonce choisi.
	 */
	public String choisirAnnonce(Joueur joueurCourant);
}
