package view.interfaceGraphique;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextPane;

import controleur.Controleur;
import model.Jeu;

import model.variantes.Basique;
import model.variantes.Minimale;
import model.variantes.Monclar;

/**
 * Interface graphique pour initialiser la partie. Permet de choisir
 * quelle variante jouer, le nombre de cartes et la methode de comptage de
 * points.
 */

public class InterfaceGraphiqueInitPartie extends InterfaceGraphique {
	/**
	 * Fenetre contenant l'ensemble de l'interface graphique.
	 */
	private JFrame menuInitJFrame;
	/**
	 * Nombre de cartes dans la partie.
	 */
	private JComboBox choixDecks;
	/**
	 * methode de comptage de la partie.
	 */
	private JComboBox choixMethodes;
	/**
	 * Variante de la partie.
	 */
	private JComboBox choixVariante;
	/**
	 * Affiche les effets des cartes selon la variante choisie.
	 */
	private JTextPane textPane;

	/**
	 * Constructeur. Appel la methode {@link}{@link #menuInitPartie()}.
	 * @param ctrl
	 */
	public InterfaceGraphiqueInitPartie(Controleur ctrl) {
		super(ctrl);
		menuInitPartie();
	}

	public JFrame getMenuInitJFrame() {
		return menuInitJFrame;
	}
	
	/**
	 * Initialise le contenu de la fenetre.
	 */
	
	private void menuInitPartie() {
		menuInitJFrame = new JFrame();
		menuInitJFrame.setTitle("8 Americain");
		menuInitJFrame.setSize(400, 600);
		menuInitJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		menuInitJFrame.setResizable(false);
		menuInitJFrame.setLocation(30, 30);

		JPanel jPanelFond = new JPanel();
		menuInitJFrame.add(jPanelFond);

		jPanelFond.setLayout(new BorderLayout());

		JLabel titre = new JLabel("8 Americain");
		titre.setFont(new Font("TimesRoman", Font.PLAIN, 25));
		titre.setHorizontalAlignment(JLabel.CENTER);

		JPanel jPanelTitre = new JPanel();
		jPanelTitre.setLayout(new BorderLayout());

		jPanelTitre.add(titre, BorderLayout.NORTH);

		jPanelTitre.add(new JLabel("REY Baptiste & LORIOT Thomas", JLabel.CENTER), BorderLayout.CENTER);

		jPanelFond.add(jPanelTitre, BorderLayout.NORTH);

		JPanel jPanelCenterFond = new JPanel();
		jPanelFond.add(jPanelCenterFond, BorderLayout.CENTER);

		jPanelCenterFond.setLayout(new BorderLayout());

		JPanel jPanelCenterFondNord = new JPanel();
		jPanelCenterFond.add(jPanelCenterFondNord, BorderLayout.NORTH);

		jPanelCenterFondNord.setLayout(new GridLayout(9, 1));

		jPanelCenterFondNord.add(new JLabel(""));

		jPanelCenterFondNord.add(new JLabel("  Choix du deck : ", null, JLabel.LEFT));

		String[] decks = { "32 Cartes", "52 Cartes" };
		choixDecks = new JComboBox<String>(decks);
		jPanelCenterFondNord.add(choixDecks);
		choixDecks.setSelectedIndex(1);
		
		jPanelCenterFondNord.add(new JLabel(""));

		jPanelCenterFondNord.add(new JLabel("  Choix du mode de comptage : ", null, JLabel.LEFT));

		String[] methodes = { "Compte Positif", "Compte Negatif" };
		choixMethodes = new JComboBox<String>(methodes);
		jPanelCenterFondNord.add(choixMethodes);

		jPanelCenterFondNord.add(new JLabel(""));

		jPanelCenterFondNord.add(new JLabel("  Choix de la variante : ", null, JLabel.LEFT), BorderLayout.NORTH);

		String[] variantes = { "Basique", "Minimale", "Monclar" };
		choixVariante = new JComboBox<String>(variantes);
		jPanelCenterFondNord.add(choixVariante);

		textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setText(Basique.getStringVariante());

		jPanelCenterFond.add(textPane, BorderLayout.CENTER);

		JPanel jPanelSudFond = new JPanel();
		jPanelFond.add(jPanelSudFond, BorderLayout.SOUTH);
		jPanelSudFond.setLayout(new GridLayout(2, 1));

		JButton jButCommencerJeu = new JButton("Commencer le jeu");
		JButton jButExit = new JButton("Quitter");

		jPanelSudFond.add(jButCommencerJeu);
		jPanelSudFond.add(jButExit);

		menuInitJFrame.setVisible(true);

		choixVariante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				switch (choixVariante.getSelectedIndex()) {
				case 0:
					textPane.setText(Basique.getStringVariante());
					break;

				case 1:
					textPane.setText(Minimale.getStringVariante());
					break;

				case 2:
					textPane.setText(Monclar.getStringVariante());
					break;

				}

			}
		});

		jButCommencerJeu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// CHOIX DE LA METHODE DE COMPTAGE
				switch (choixMethodes.getSelectedIndex()) {
				case 0:
					getControleur().getJeu().setMethodeCompte(Jeu.COMPTE_POSITIF);
					break;

				case 1:
					getControleur().getJeu().setMethodeCompte(Jeu.COMPTE_NEGATIF);
					break;

				}

				// CHOIX DU DECK
				switch (choixDecks.getSelectedIndex()) {
				case 0:
					getControleur().getJeu().setNbCarteDeck(Jeu.DECK_32_CARTES);
					break;

				case 1:
					getControleur().getJeu().setNbCarteDeck(Jeu.DECK_52_CARTES);
					break;

				}

				// CHOIX DE LA VARIANTE
				switch (choixVariante.getSelectedIndex()) {
				case 0:
					getControleur().getJeu().setVariante(new Basique());
					break;

				case 1:
					getControleur().getJeu().setVariante(new Minimale());
					break;

				case 2:
					getControleur().getJeu().setVariante(new Monclar());
					break;
				}

				menuInitJFrame.setVisible(false);
				menuInitJFrame.dispose();

				getControleur().getJeu().initJoueurs();
			}
		});

		jButExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}
