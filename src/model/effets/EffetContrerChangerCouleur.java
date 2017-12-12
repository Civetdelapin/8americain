package model.effets;

import model.Jeu;
import model.Joueur;
import model.Message;

public class EffetContrerChangerCouleur extends EffetChangerCouleur {
	private static final int score = 50;
	
	public EffetContrerChangerCouleur() {
		this.valeurScore = EffetContrerChangerCouleur.score;
	}
	
	public Message action(Joueur joueurCourant) {
		Message msg;
		
		//On arr�te les attaques
		if(Jeu.getInstance().isModeAttaque()){
			Jeu.getInstance().setModeAttaque(false);
			Jeu.getInstance().setNbCarteModeAttaque(0);
			
			msg = new Message(Message.Types.effetContrerChangerCouleur);
			msg.setJoueurCourant(joueurCourant);
			msg.setNouvelleCouleur(nouvelleCouleur);
			
			//On r�alise l'action ChangerCouleur
			super.action(joueurCourant);
		}else {
			//On r�alise l'action ChangerCouleur
			msg = super.action(joueurCourant);
		}
		

		return msg;	
    }

	
}
