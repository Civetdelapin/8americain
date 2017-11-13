package model;

public class EffetSauterTour implements Effet {

    
	public void action(Joueur joueurCourant) {
		
		Jeu.getInstance().getJoueurSuivant(joueurCourant).setPeutJoueur(false);
    
	}

	@Override
	public String getMessage(Joueur joueurCourant) {
		String str = joueurCourant.getPseudo()+" emp�che "+Jeu.getInstance().getJoueurSuivant(joueurCourant).getPseudo()+" de jouer !";
		return str;
	}

}
