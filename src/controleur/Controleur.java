package controleur;

import model.*;
import view.IHM;
import view.interfaceConsole.InterfaceConsole;
import view.interfaceGraphique.InterfaceGraphique;

/**
 * Impl�mentation du mod�le MVC. Ici le Controleur.
 */
public class Controleur {

	private Jeu jeu;

	public Controleur() {
		this.setJeu(Jeu.getInstance());
	}

	public Jeu getJeu() {
		return jeu;
	}

	public void setJeu(Jeu jeu) {
		this.jeu = jeu;
	}

	// Methode MAIN du logiciel.
	public static void main(String[] args) {

		Controleur controleur = new Controleur();
		
		// Cr�ation d'une interface Console
		IHM ihm = new InterfaceConsole(controleur);
		controleur.getJeu().addObserver(ihm);

		// Cr�ation d'une interface Graphique
		IHM ihm2 = new InterfaceGraphique(controleur);
		controleur.getJeu().addObserver(ihm2);
		
		controleur.getJeu().initPartie();
	}

}
