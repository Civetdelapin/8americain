package model.effets;

import model.Jeu;
import model.Joueur;
import model.Message;

/**
 * Effet repr�sentant un joueur qui rejoue.
 */
public class EffetRejouer extends Effet {

	/**
	 * Constante priv�e indiquant le score de cet Effet.
	 */
	private static final int score = 20;

	public EffetRejouer() {
		super(EffetRejouer.score);
	}

	/**
	 * Fait rejouer le Joueur gr�ce � un appel de faireRejouer() de Jeu. Renvoie
	 * ensuite un message de type effetRejouer
	 */
	public Message action(Joueur joueurCourant) {
		Jeu.getInstance().faireRejouer(joueurCourant);

		Message msg = new Message(Message.Types.effetRejouer);
		msg.setJoueurCourant(joueurCourant);
		return msg;
	}

}
