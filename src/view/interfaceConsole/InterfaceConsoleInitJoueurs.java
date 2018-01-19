package view.interfaceConsole;

import java.util.LinkedList;

import controleur.Controleur;
import model.Joueur;
import model.JoueurArtificiel;

/**
 * Repr�sente la demande faite aupr�s de l'Utilisateur pour initialiser les joueurs 
 * de la partie. Elle permet d'initier le nom du joueur et d'ajouter des bots (en
 * pr�cisant leur nom et leur strat�gie).
 *
 */

public class InterfaceConsoleInitJoueurs extends InterfaceConsole implements Runnable {

	public InterfaceConsoleInitJoueurs(Controleur ctrl) {
		super(ctrl);
	}

	@Override
	public void run() {
		boolean operationInterompue = true;
		LinkedList<Joueur> joueursInit = new LinkedList<Joueur>();

		System.out.println("===== CHOIX DE VOTRE NOM =====");
		String nomJoueurHumain = super.lireChaine("Choisir votre nom : ");
		if (nomJoueurHumain != null) {
			joueursInit.add(new Joueur(nomJoueurHumain));

			JoueurArtificiel bot1 = creerBot();

			if (bot1 != null) {

				joueursInit.add(bot1);

				boolean finCreationBot;
				do {
					finCreationBot = true;

					System.out.println("===== ACTION =====");
					System.out.println("(0) Cr�er un nouveau Joueur IA");
					System.out.println("(1) Commencer la partie");
					System.out.println("------------------");

					Integer choix = lireInteger("Choisir action :");
					if (choix != null) {
						switch (choix) {
						case 0:
							JoueurArtificiel bot = creerBot();
							if (bot != null) {
								joueursInit.add(bot);
								finCreationBot = false;
							} else {
								operationInterompue = true;
							}
							break;
						case 1:
							operationInterompue = false;
							break;
						default:
							finCreationBot = false;
							break;
						}

					}

				} while (!finCreationBot);

			}
		}
		if (!operationInterompue) {
			getControleur().getJeu().setJoueursInitiation(joueursInit);
			getControleur().getJeu().commencerPartie();
		}
	}

	/**
	 * Cr�er un bot en demande � l'utilisateur son nom et sa strategie.
	 * 
	 * @return Le nouveau BOT, renvoie NULL si le Thread est interrompu.
	 */
	private JoueurArtificiel creerBot() {
		System.out.println("===== CHOIX NOM DU JOUEUR IA =====");
		String nomBot = super.lireChaine("Choisir le nom : ");
		if (nomBot != null) {
			System.out.println("===== CHOIX STRATEGIE " + nomBot + " =====");
			System.out.println("(" + JoueurArtificiel.PASSIF + ") PASSIF");
			System.out.println("(" + JoueurArtificiel.AGRESSIF + ") AGRESSIF");
			System.out.println("==================");

			boolean choixok;
			do {
				choixok = true;

				Integer strategie = super.lireInteger("Choisir une strag�gie : ");

				if (strategie != null) {
					if (strategie == JoueurArtificiel.AGRESSIF || strategie == JoueurArtificiel.PASSIF) {
						return new JoueurArtificiel(nomBot, strategie);
					} else {
						choixok = false;
					}

				} else {
					return null;
				}

			} while (!choixok);

		}
		return null;
	}
}
