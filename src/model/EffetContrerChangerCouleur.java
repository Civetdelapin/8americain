package model;

public class EffetContrerChangerCouleur extends EffetChangerCouleur {

   
	public String action(Joueur joueurCourant) {
		String message;
		
		//On arr�te les attaques
		if(Jeu.getInstance().isModeAttaque()){
			Jeu.getInstance().setModeAttaque(false);
			Jeu.getInstance().setNbCarteModeAttaque(0);
			message = getMessageStopAttaque(joueurCourant);
			
			//On r�alise l'action ChangerCouleur
			super.action(joueurCourant);
		}else {
			//On r�alise l'action ChangerCouleur
			message = super.action(joueurCourant);
		}
		

		return message;	
    }
	
	private String getMessageStopAttaque(Joueur joueurCourant) {
		String str = joueurCourant.getPseudo()+" a arreter une attaque et a choisi la couleur "+ Carte.COULEURS[nouvelleCouleur]+"!";
		
		return str;
	}
	
}
