package view;

import java.util.Observer;

import controleur.Controleur;

/**
 * Classe abstraite servant de squelette pour chacun des types d'Interface. Elle implemente l'interface Observer.
 */
public abstract class IHM implements Observer{

	/**
	 * Le controleur utilise par l'application.
	 */
	private Controleur controleur;

	public IHM(Controleur ctrl) {
		this.setControleur(ctrl);
	}
	
	/**
	 * Getter de controleur
	 * @return l'attribut controleur.
	 */
	public Controleur getControleur() {
		return controleur;
	}

	/**
	 * Setter pour l'attribut controleur. 
	 * @param controleur Le controleur e assigner.
	 */
	public void setControleur(Controleur controleur) {
		this.controleur = controleur;
	}

}
