package model;

public class EffetContrerChangerCouleur extends EffetChangerCouleur {
	private int scoreValue = 50;
   
	public String action(Joueur joueurCourant) {
		//On arr�te les attaques
		if(Jeu.getInstance().isModeAttaque()){
			Jeu.getInstance().setModeAttaque(false);
			Jeu.getInstance().setNbCarteModeAttaque(0);
		}
		//On r�alise l'action ChangerCouleur
		super.action(joueurCourant);
		return "";	
    	}
	

}
