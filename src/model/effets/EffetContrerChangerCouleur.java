package model.effets;

import model.Jeu;
import model.Joueur;
import model.Message;

/**
 * Contre une attaque en cours si il y en a une puis demande au joueur de
 * choisir une nouvelle couleur.
 */
public class EffetContrerChangerCouleur extends EffetChangerCouleur {

	/**
	 * Constante privee indiquant le score de cet Effet.
	 */
	private static final int score = 50;

	public EffetContrerChangerCouleur() {
		this.valeurScore = EffetContrerChangerCouleur.score;
	}

	/**
	 * Si possible, Contre un message puis change la couleur de la carte et renvoie
	 * un msg de type effetContrerChangerCouleur. Sinon change seulement la couleur
	 * et renvoie un message de type effetChangerCouleur.
	 */
	public Message action(Joueur joueurCourant) {
		Message msg;

		// On arrete les attaques
		if (Jeu.getInstance().isModeAttaque()) {
			Jeu.getInstance().setModeAttaque(false);
			Jeu.getInstance().setNbCarteModeAttaque(0);

			msg = new Message(Message.Types.effetContrerChangerCouleur);
			msg.setJoueurCourant(joueurCourant);
			msg.setNouvelleCouleur(nouvelleCouleur);

			// ET On realise l'action ChangerCouleur
			super.action(joueurCourant);
		} else {
			// On realise l'action ChangerCouleur
			msg = super.action(joueurCourant);
		}

		return msg;
	}

}
