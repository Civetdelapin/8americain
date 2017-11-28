package view;

import java.util.Observable;
import java.util.Scanner;

import controleur.Controleur;
import model.JoueurArtificiel;
import model.Carte;
import model.Jeu;
import model.Joueur;


public class InterfaceConsole extends IHM {

	public InterfaceConsole(Controleur ctrl) {
		super(ctrl);
	}

	@Override
	public void notifier(String msg) {
		if(msg != "") {
			System.out.println(msg);
		}
	}

	@Override
	public int choixIndexCarte(Joueur joueurCourant) {
		String carteDefausse = "Carte sommet d�fausse : ";
		if(Jeu.getInstance().getDefausse().isEmpty()) {
			carteDefausse+="aucune!";
			
		}else {
			carteDefausse+=Jeu.getInstance().getDefausse().get(Jeu.getInstance().getDefausse().size()-1);
		}
		System.out.println(carteDefausse);
		
		System.out.println("-- MAIN DE "+joueurCourant.getPseudo()+" --");
		for(Carte carte : joueurCourant.getMain()){
			System.out.println("("+joueurCourant.getMain().indexOf(carte)+")"+carte.toString());
		}
		System.out.println("=====================");
		System.out.println("(-1)Piocher une carte");
		Scanner sc = new Scanner(System.in);
		System.out.print("Choisir index Carte : ");
		int index = sc.nextInt();
		
		return index;
	}

	@Override
	public void initJoueurs() {
		System.out.println("---- CREATION AUTO DES JOUEURS (POUR TESTER LE RESTE) ----");
		this.getControleur().getJeu().getJoueurs().clear();
		this.getControleur().getJeu().getJoueurs().add(new Joueur("Civetdelapin"));
		this.getControleur().getJeu().getJoueurs().add(new JoueurArtificiel("AI_1",0));
		this.getControleur().getJeu().getJoueurs().add(new JoueurArtificiel("AI_2",1));
		
		/*
		Scanner sc = new Scanner(System.in);
		System.out.println("---- CREATION DU JOUEUR ----");
		System.out.print("Entrer votre nom : ");
		String nom = sc.nextLine();
		Joueur j = new Joueur(nom);
		this.getControleur().getJeu().getJoueurs().add(j);
		System.out.println("---- CREATION DES JOUEURS ARTIFICELS ----");
		System.out.print("Combien de joueurs artificiels ? ");
		int nbJoueur = sc.nextInt();
		int strategie;
		for (int i = 1 ; i <= nbJoueur ; i++) {
			
			System.out.print("Entrer nom joueur"+i+": ");
			
			nom = sc.next();
			
			System.out.print("Entrer stratégie joueur"+i+" (taper 0 pour passif, 1 pour agréssif) :");
			
			strategie = sc.nextInt();
			
			j = new JoueurArtificiel(nom, strategie);
			
			
			this.getControleur().getJeu().getJoueurs().add(j);
		}	
			*/
		
		this.getControleur().commencerPartie();
	}

	@Override
	public int[] choixIndexDonner(Joueur joueurCourant) {
		int [] data = new int [2];
		System.out.println("-- CHOIX EFFET DONNER --");
		
		System.out.println("-- MAIN DE "+joueurCourant.getPseudo()+" --");
		for(Carte carte : joueurCourant.getMain()){
			System.out.println("("+joueurCourant.getMain().indexOf(carte)+")"+carte.toString());
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Choisir index Carte : ");
		data[0] = sc.nextInt();
		
		System.out.println("-- CHOIX DU JOUEUR A QUI DONNER LA CARTE --");
		for(int i =0; i < Jeu.getInstance().getJoueurs().size()-1; i++){
			if(!joueurCourant.equals(Jeu.getInstance().getJoueurs().get(i))){
				System.out.println("("+i+")"+Jeu.getInstance().getJoueurs().get(i).getPseudo());
			}	
		}
		
		
		System.out.print("Choisir index Joueur : ");
		data[1] = sc.nextInt();
		
		return data;
	}

	@Override
	public int[] choixChangerCouleur(Joueur joueurCourant) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("-- CHOIX CHANGER COULEUR --");
		for (int i = 0; i < Carte.COULEURS.length; i++) {
			System.out.println("("+i+")"+Carte.COULEURS[i]);
		}
		
		System.out.print("Choisir couleur : ");
		int couleur = sc.nextInt();
		
		int [] data = new int [1];
		data[0] = couleur;
		return data;
	}

	
}
