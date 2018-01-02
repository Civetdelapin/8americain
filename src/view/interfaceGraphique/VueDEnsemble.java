package view.interfaceGraphique;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JPanel;

public class VueDEnsemble {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VueDEnsemble window = new VueDEnsemble();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VueDEnsemble() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 589, 413);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnAnnoncer = new JButton("Annoncer");
		btnAnnoncer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnAnnoncer.setBounds(335, 101, 203, 25);
		frame.getContentPane().add(btnAnnoncer);
		
		JButton btnPiocher = new JButton("Piocher");
		btnPiocher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPiocher.setBounds(335, 139, 203, 25);
		frame.getContentPane().add(btnPiocher);
		
		JTextArea txtrHistorique = new JTextArea();
		txtrHistorique.setText("Historique");
		txtrHistorique.setBounds(335, 177, 203, 157);
		frame.getContentPane().add(txtrHistorique);
		
		JButton btnAbandonner = new JButton("Abandonner");
		btnAbandonner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAbandonner.setBounds(374, 339, 123, 14);
		frame.getContentPane().add(btnAbandonner);
		
		//la main du joueur
		JPanel panel = new JPanel(); 
		panel.setBounds(12, 230, 311, 123);
		frame.getContentPane().add(panel);
		//
		
		//le centre avec la d�fausse
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(62, 139, 214, 78);
		frame.getContentPane().add(panel_1);
		//
		
		//les IA
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 13, 311, 113);
		frame.getContentPane().add(panel_2);
		//
	}
}
