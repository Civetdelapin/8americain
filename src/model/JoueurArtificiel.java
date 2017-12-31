package model;

/**
 * JoueurArtificiel repr�sente un Joueur BOT qui poss�de une surcharge de la
 * m�thode choisirCarte() qui utilise une strategie propre au Joueur.
 */

public class JoueurArtificiel extends Joueur {
	/**
	 * La strat�gie du joueur artificiel.
	 */
	private Strategie strategie;

	/**
	 * Constante pour la strat�gie Passive.
	 */
	public static final int PASSIF = 0;

	/**
	 * Constante pour la strat�gie Agressive.
	 */
	public static final int AGRESSIF = 1;
	
	public JoueurArtificiel(String pseudo, int strategie) {
		super(pseudo);

		switch (strategie) {
		case PASSIF:
			this.strategie = new Passif();
			break;
		case AGRESSIF:
			this.strategie = new Agressif();
			break;
		default: // Par d�faut on choisi une strategie Passive.
			this.strategie = new Passif();
		}

	}

	public Carte choisirCarte() {
		return this.strategie.choisirCarteStrategie(this);
	}

	public Integer[] choisirDataDonner() {
		return this.strategie.choisirDataDonner(this);
	}

	public Integer[] choisirDataChangerCouleur() {
		return this.strategie.choisirDataChangerCouleur(this);
	}

	public String choisirAnnonce() {
		return this.strategie.choisirAnnonce(this);
	}

}
