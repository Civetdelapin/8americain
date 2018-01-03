package view.interfaceGraphique;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

import controleur.Controleur;
import model.Carte;
import model.ErreurCarteInposable;
import model.Jeu;
import model.Joueur;
import model.JoueurArtificiel;
import model.Message;
import view.IHM;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class InterfaceGraphique extends IHM {

	public InterfaceGraphique(Controleur ctrl) {
		super(ctrl);
	}

	private JFrame fenetreDeJeu;
	private JTextArea txtrHistorique;
	private JPanel panelMainDuJoueur;
	private JPanel panelCentreDefausse;
	private JPanel panelJoueurArtificiel;
	private JButton btnPiocher;
	private JButton btnAnnoncer;

	/**
	 * Initialize the contents of the frame.
	 */
	private void initializeJouerTour(Joueur joueurCourant) {
		fenetreDeJeu = new JFrame();
		fenetreDeJeu.setBounds(100, 100, 589, 413);
		fenetreDeJeu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fenetreDeJeu.getContentPane().setLayout(null);
		fenetreDeJeu.setResizable(true);
		fenetreDeJeu.setVisible(true);
		
		JPanel panel = new JPanel(new BorderLayout()); //le borderlayout de base n'aura qu'un CENTER est un EAST
		fenetreDeJeu.getContentPane().add(panel);
		
		//Center
		JPanel panelCenter = new JPanel(new BorderLayout()); //c'est le bordel
		panel.add(panelCenter); //devrait partager la partie gauche en trois partie... on croise les doigts
								// de mani�re pas trop d�gueu
			//Center de panelCenter
			JPanel panelMainDefausse = new JPanel(new BorderLayout());
			panelCenter.add(panelMainDefausse, BorderLayout.CENTER);
				//Center de panelMainDefausse
				panelMainDuJoueur = new JPanel();
				panelMainDefausse.add(panelMainDuJoueur);
				//
				//North de panelMainDefausse
				panelCentreDefausse = new JPanel();
				panelMainDefausse.add(panelCentreDefausse, BorderLayout.NORTH);
				//
			//
			
			//North de panelCenter
			panelJoueurArtificiel = new JPanel();
			panelCenter.add(panelJoueurArtificiel, BorderLayout.NORTH);
			//
		//
			
		//East
		JPanel panelEast = new JPanel(new BorderLayout());
		panel.add(panelEast, BorderLayout.EAST);
		
			//Center de panelEast
			JPanel panelHistoriquePiocher = new JPanel(new BorderLayout());
			panelEast.add(panelHistoriquePiocher);
				//Center de PanelHistoriquePiocher
				txtrHistorique = new JTextArea();
				txtrHistorique.setEditable(true);
				txtrHistorique.setLineWrap(true);//fait revenir � la ligne les prochaines lettres si elles d�passent le carde
				txtrHistorique.setWrapStyleWord(true);//fait revenir � la ligne tout le dernier mot si ses lettres d�passent le cadre
				JScrollPane scrollPane = new JScrollPane(txtrHistorique);// permet d'utiliser de monter et descendre dans la fenetre de texte
				panelHistoriquePiocher.add(scrollPane);
				//
				//North de panelHistoriquePiocher
				btnPiocher = new JButton();
				btnPiocher.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						getControleur().getJeu().jouerCarte(joueurCourant, null); // On pioche une carte
					}
				});
				panelHistoriquePiocher.add(btnPiocher, BorderLayout.NORTH);
				//
			//
			
			//North de panelEast
			JPanel panelImageAnnoncer = new JPanel(new BorderLayout());
			panelEast.add(panelImageAnnoncer, BorderLayout.NORTH);
				//Center de panelImageAnnoncer
				JLabel jolieImage = new JLabel(new ImageIcon("jolieImage"));
				panelImageAnnoncer.add(jolieImage);
				//
				//South de panelImageAnnoncer
				btnAnnoncer = new JButton();
				btnAnnoncer.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
					}
				});
				panelImageAnnoncer.add(btnAnnoncer, BorderLayout.SOUTH);
				//
			//
		//

		/*JButton btnAnnoncer = new JButton("Annoncer");
		btnAnnoncer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnnoncer.setBounds(335, 101, 203, 25);
		fenetreDeJeu.getContentPane().add(btnAnnoncer);

		btnPiocher = new JButton("Piocher");
		btnPiocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getControleur().getJeu().jouerCarte(joueurCourant, null); // On pioche une carte
			}
		});

		btnPiocher.setBounds(335, 139, 203, 25);
		fenetreDeJeu.getContentPane().add(btnPiocher);

		txtrHistorique = new JTextArea();
		txtrHistorique.setBounds(335, 177, 203, 157);
		fenetreDeJeu.getContentPane().add(txtrHistorique);

		JButton btnAbandonner = new JButton("Abandonner");
		btnAbandonner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbandonner.setBounds(374, 339, 123, 14);
		fenetreDeJeu.getContentPane().add(btnAbandonner);

		// la main du joueur
		panelMainDuJoueur = new JPanel();
		panelMainDuJoueur.setBounds(12, 230, 311, 123);
		fenetreDeJeu.getContentPane().add(panelMainDuJoueur);
		//

		// le centre avec la d�fausse
		panelCentreDefausse = new JPanel();
		panelCentreDefausse.setBounds(62, 139, 214, 78);
		fenetreDeJeu.getContentPane().add(panelCentreDefausse);
		//

		// les IA
		panelJoueurArtificiel = new JPanel();
		panelJoueurArtificiel.setBounds(12, 13, 311, 113);
		fenetreDeJeu.getContentPane().add(panelJoueurArtificiel);
		//

		fenetreDeJeu.setVisible(true);
		*/
	}

	public void refreshDisplay(Jeu jeu, Joueur joueurCourant) {
		// On actualise la main du Joueur
		afficherMainJoueur(joueurCourant);

		// On actualise la d�fausse
		panelCentreDefausse.removeAll();
		panelCentreDefausse.add(new JLabel("D�fausse : " + jeu.getDefausse().getLast()));

		// On actualise les joueurs artificiels
		afficherJoueursArtificiels(jeu.getJoueurs());

		fenetreDeJeu.repaint();
		
	}

	private void afficherMainJoueur(Joueur joueurCourant) {
		panelMainDuJoueur.removeAll();

		for (Carte carte : joueurCourant.getMain()) {
			JButton bouton = new JButton(carte.toString());
			bouton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						getControleur().getJeu().jouerCarte(joueurCourant, carte);
					} catch (ErreurCarteInposable e1) {
						JOptionPane.showMessageDialog(fenetreDeJeu, carte.toString() + " n'a pas pu �tre pos�(e)!");
					}
				}
			});
			panelMainDuJoueur.add(bouton);
		}

	}

	private void afficherJoueursArtificiels(List<Joueur> joueurs) {
		panelJoueurArtificiel.removeAll();

		for (Joueur joueur : joueurs) {
			if (joueur instanceof JoueurArtificiel) {
				panelJoueurArtificiel.add(new InterfaceGraphiqueJoueurArtificiel(joueur));
			}
		}
	}

	public void update(Observable jeu, Object msg) {
		if (msg instanceof Message) {
			switch (((Message) msg).getType()) {
			case effetAttaque:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " oblige "
						+ ((Message) msg).getJoueurVictime().getPseudo() + " � piocher "
						+ ((Message) msg).getNbCartesAttaque() + " carte(s)!");
				break;

			case effetClassique:
				break;

			case effetRejouer:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " rejoue!");
				break;

			case effetSauterTour:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " emp�che "
						+ ((Message) msg).getJoueurVictime().getPseudo() + " de jouer!");
				break;

			case effetContrerChangerCouleur:
				afficherConsole(
						((Message) msg).getJoueurCourant().getPseudo() + " a arret� une attaque et a choisi la couleur "
								+ Carte.COULEURS[((Message) msg).getNouvelleCouleur()] + "!");
				break;

			case effetChangerCouleur:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " a choisi la couleur "
						+ Carte.COULEURS[((Message) msg).getNouvelleCouleur()] + "!");
				break;

			case effetDonner:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " ajoute un(e) "
						+ ((Message) msg).getCarteADonner().toString() + " dans la main de "
						+ ((Message) msg).getJoueurVictime().getPseudo());
				break;

			case effetModeAttaque:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " ajoute "
						+ ((Message) msg).getNbCartesAttaque() + " carte(s) au tas d'attaque!");
				break;

			case effetChangerSensJeu:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " inverse le sens de jeu!");
				break;

			case nePeutPasJouer:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " ne peut pas jouer!");
				break;

			case joueurAnnonce:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " dit : \""
						+ ((Message) msg).getAnnonce() + "\"!");
				break;

			case annonceContreCarteReussi:
				afficherConsole(((Message) msg).getJoueurVictime().getPseudo()
						+ " pioche deux cartes gr�ce � un Contre Carte r�ussi de "
						+ ((Message) msg).getJoueurCourant().getPseudo() + "!");
				break;

			case annonceContreCarteEchoue:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo()
						+ " pioche deux cartes pour avoir annoncer un Contre Carte sans aucune raison!");
				break;

			case annonceInconnue:
				afficherConsole("Rien ne se passe!");
				break;

			case piocherCarte:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " pioche "
						+ ((Message) msg).getNbCartesAttaque() + " carte(s)!");
				break;

			case choixChangerCouleur:

				break;

			case choixDonnerCarte:

				break;

			case cartePosee:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " pose un(e) "
						+ ((Message) msg).getCarteADonner().toString() + "!");
				break;

			case annonceCarteTropTot:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo()
						+ " pioche deux cartes pour avoir annoncer un Carte trop t�t!");
				break;

			case joueurAFiniManche:
				afficherConsole(
						((Message) msg).getJoueurCourant().getPseudo() + " vient de poser sa derni�re carte! Bravo!");
				break;

			case afficherTour:
				afficherConsole("------- TOUR DE " + ((Message) msg).getJoueurCourant().getPseudo() + " -------");
				break;

			case tourJoueurHumain:
				refreshDisplay(getControleur().getJeu(), ((Message) msg).getJoueurCourant());
				break;

			case initJoueurs:

				break;

			case finTourJoueurHumain:
				break;

			case annonceCarte:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + " a bien annonc� Carte!");
				break;

			case nouvelleManche:
				afficherConsole("---------- MANCHE N�" + ((Message) msg).getNumeroManche() + " ----------");
				break;

			case finPartie:
				afficherConsole(((Message) msg).getJoueurCourant().getPseudo() + "gagne la partie!");
				break;

			case initPartie:

				break;
			
			case debutPartie:
				initializeJouerTour(((Message) msg).getJoueurCourant());
				break;

			default:
				afficherConsole("MESSAGE NON PRIS EN CHARGE : " + ((Message) msg).getType().toString());
				break;
			}
		}

	}

	public void afficherConsole(String str) {
		txtrHistorique.append(str + "\n");
	}
}
