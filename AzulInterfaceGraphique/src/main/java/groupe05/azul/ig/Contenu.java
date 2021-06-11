package groupe05.azul.ig;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

import javax.swing.*;

import groupe05.azul.terminal.Joueur;

/**
 * <b>Class qui contient le contenu de la fenêtre </b>
 * 
 * @see Fenetre
 * @see Joueur
 * 
 * @version 1.0
 * 
 */
public class Contenu extends JPanel {
	/**
	 * Largeur de la fenêtre
	 *
	 * @see Contenu
	 *
	 */
	public static int largeur = 1280;
	/**
	 * Hauteur de la fenêtre
	 *
	 * @see Contenu
	 *
	 */
	public static int hauteur = 720;

	/**
	 * Fenêtre de l'interface
	 *
	 * @see Fenetre
	 * @see Contenu
	 * @see Contenu#Contenu(Fenetre)
	 * @see Contenu#pageDeLancement()
	 * @see Contenu#lancerParti()
	 * @see Contenu#estCocher()
	 * @see Contenu#cocher(JCheckBox)
	 */
	private Fenetre fenetre;
	/**
	 * Titre de la page
	 *
	 * @see Contenu
	 * @see Contenu#pageDeLancement()
	 * @see Contenu#pageParti()
	 * @see Contenu#pageOption()
	 *
	 */
	private JLabel titre;

	/**
	 * Toutes les zones pour rentrer les noms des joueurs
	 *
	 * @see Contenu
	 * @see Contenu#lancerParti()
	 * @see Contenu#miseAjourJoueur(int, JPanel)
	 *
	 */
	private JTextField[] nomJoueurs;
	/**
	 * Toutes les zones pour rentrer l'ages des joueurs
	 *
	 * @see Contenu
	 * @see Contenu#lancerParti()
	 * @see Contenu#miseAjourJoueur(int, JPanel)
	 *
	 */
	private JTextField[] ageJoueurs;
	/**
	 * Partie
	 *
	 * @see Partie
	 * @see Contenu
	 * @see Contenu#pageParti()
	 * @see Contenu#lancerParti()
	 *
	 */
	private Partie jeu;

	/**
	 * Tous les joueurs qui jouent
	 *
	 * @see Joueur
	 * @see Contenu
	 * @see Contenu#pageParti()
	 * @see Contenu#lancerParti()
	 * @see Contenu#JoueursValide()
	 * @see Contenu#miseAjourJoueur(int, JPanel)
	 * 
	 */
	public Joueur[] touteLesJoueur;

	/**
	 * Constructeur Contenu
	 * 
	 * @param f
	 *
	 * @see Contenu
	 * 
	 */
	public Contenu(Fenetre f) {
		fenetre = f;
		setPreferredSize(new Dimension(largeur, hauteur));
	}

	/**
	 * Retourne la fenêtre
	 * 
	 * @return La fenêtre
	 *
	 * @see Contenu
	 * 
	 */
	public Fenetre getFenetre() {
		return fenetre;
	}

	/**
	 * Rends la page vide
	 * 
	 * @see Contenu
	 * 
	 */
	public void nouvellePage() {
		removeAll();
		repaint();
		revalidate();
	}

	/**
	 * Cree la page de lancement
	 * 
	 * @see Contenu
	 * 
	 */
	public void pageDeLancement() {
		nouvellePage();
		setLayout(new GridBagLayout());

		JPanel menu = new JPanel();

		menu.setLayout(new GridLayout(5, 1));
		titre = new JLabel("Azul");
		titre.setHorizontalAlignment(SwingConstants.CENTER);

		JButton nouvellePartiBouton = new JButton("Nouvelle Partie");
		nouvellePartiBouton.addActionListener((ActionEvent e) -> {
			pageParti();
		});

		JButton quitterBouton = new JButton("Quitter");
		quitterBouton.addActionListener((ActionEvent e) -> {
			fenetre.dispose();
		});

		JButton optionBouton = new JButton("Option");
		optionBouton.addActionListener((ActionEvent e) -> {
			pageOption();
		});

		menu.add(titre);
		menu.add(nouvellePartiBouton);
		menu.add(optionBouton);
		menu.add(quitterBouton);
		add(menu);

	}

	/**
	 * Cree la page pour lancer une partie
	 * 
	 * @see Contenu
	 * 
	 */
	private void pageParti() {
		nouvellePage();
		JPanel menu = new JPanel();
		menu.setLayout(new GridLayout(5, 1));
		menu.setPreferredSize(new Dimension(largeur / 2, hauteur / 2));

		titre.setText("Combien êtes-vous?");
		JSlider nbJoueur = new JSlider();
		JPanel joueurs = new JPanel();
		joueurs.setLayout(new GridLayout());

		nbJoueur.setValue(2);
		nbJoueur.setMinimum(2);
		nbJoueur.setMaximum(4);
		nbJoueur.setPaintLabels(true);
		nbJoueur.setMajorTickSpacing(1);
		nbJoueur.addChangeListener((e) -> {
			miseAjourJoueur(nbJoueur.getValue(), joueurs);
		});
		miseAjourJoueur(nbJoueur.getValue(), joueurs);

		JPanel lesBoutons = new JPanel();

		JButton retour = new JButton("Retour");
		retour.addActionListener((ActionEvent e) -> {
			pageDeLancement();
		});

		JButton valider = new JButton("Valider");
		valider.addActionListener((ActionEvent e) -> {
			jeu = new Partie(this, touteLesJoueur);
			try {
				lancerParti();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		lesBoutons.add(retour);
		lesBoutons.add(valider);

		menu.add(titre);
		menu.add(nbJoueur);
		menu.add(joueurs);
		menu.add(lesBoutons);
		add(menu);
	}

	/**
	 * Lance une partie
	 * 
	 * @see Contenu
	 * 
	 */
	private void lancerParti() throws Exception {
		for (int i = 0; i < ageJoueurs.length; i++) {
			if (nomJoueurs[i].getText().equals("")) {
				String message = "Les noms ne doivent pas etre vide";
				JOptionPane.showMessageDialog(fenetre, message, "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
			} else if (estUnEntier(ageJoueurs[i].getText()) && Integer.parseInt(ageJoueurs[i].getText()) >= 8) {
				touteLesJoueur[i] = new Joueur(nomJoueurs[i].getText(), Integer.parseInt(ageJoueurs[i].getText()));
			} else {
				String message = "Age non valide (8 ans ou plus)";
				JOptionPane.showMessageDialog(fenetre, message, "Erreur", JOptionPane.ERROR_MESSAGE);
				break;
			}
		}
		if (JoueursValide()) {
			jeu.start();

		}
	}

	/**
	 * Vérifie que tous les joueurs sont valides
	 * 
	 * @return Vrai si les joueurs sont valides
	 * 
	 * @see Contenu
	 * 
	 */
	private boolean JoueursValide() {
		for (int i = 0; i < touteLesJoueur.length; i++) {
			if (touteLesJoueur[i] == null) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie qu'une chaine de caractères est un entier
	 * 
	 * @param chaine
	 * 
	 * @return Vrai si c'est un entier
	 * 
	 * @see Contenu
	 * 
	 */
	private boolean estUnEntier(String chaine) {
		try {
			Integer.parseInt(chaine);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	/**
	 * Ajoute les zones pour les noms et âges en fonction du nombre de joueurs
	 * 
	 * @param nbJoueur
	 * @param joueurs
	 * 
	 * @see Contenu
	 * 
	 */
	private void miseAjourJoueur(int nbJoueur, JPanel joueurs) {
		joueurs.removeAll();
		joueurs.setLayout(new GridLayout(1, nbJoueur));
		touteLesJoueur = new Joueur[nbJoueur];
		nomJoueurs = new JTextField[nbJoueur];
		ageJoueurs = new JTextField[nbJoueur];
		for (int i = 0; i < nbJoueur; i++) {
			JPanel joueur = new JPanel();
			joueur.setLayout(new GridLayout(4, 1));
			JLabel nom = new JLabel("Nom:");
			JLabel age = new JLabel("Age:");
			nomJoueurs[i] = new JTextField();
			ageJoueurs[i] = new JTextField();
			joueur.add(nom);
			joueur.add(nomJoueurs[i]);
			joueur.add(age);
			joueur.add(ageJoueurs[i]);

			joueurs.add(joueur);
		}
		repaint();
		revalidate();
	}

	/**
	 * Cree la page pour les options
	 * 
	 * @see Contenu
	 * 
	 */
	private void pageOption() {
		nouvellePage();

		titre.setText("Option");

		JPanel debut = new JPanel();
		debut.setLayout(new GridLayout(3, 1));

		JButton retour = new JButton("Retour");
		retour.addActionListener((ActionEvent e) -> {
			pageDeLancement();
		});

		JCheckBox fullscreenBox = new JCheckBox("FULLSCREEN");
		fullscreenBox.setSelected(estCocher());
		cocher(fullscreenBox);

		debut.add(titre);
		debut.add(fullscreenBox);
		debut.add(retour);

		add(debut);
	}

	/**
	 * Vérifie si l'on est en Fullscreen
	 * 
	 * @return Vrai si l'on est en Fullscrean
	 * 
	 * @see Contenu
	 * 
	 */
	private boolean estCocher() {
		int largeurActuel = fenetre.getWidth();
		int hauteurActuel = fenetre.getHeight();
		GraphicsDevice ecran = fenetre.getGraphicsConfiguration().getDevice();
		int largeurEcran = ecran.getDisplayMode().getWidth();
		int hauteurEcran = ecran.getDisplayMode().getHeight();
		return largeurActuel == largeurEcran && hauteurActuel == hauteurEcran;
	}

	/**
	 * Permet de se mettre en Fullscreen
	 * 
	 * @param fullscreenBox
	 * 
	 * @see Contenu
	 * 
	 */
	private void cocher(JCheckBox fullscreenBox) {
		fullscreenBox.addItemListener((ItemEvent e) -> {
			Fenetre newfenetre = fenetre;
			fenetre.dispose();
			if (e.getStateChange() == ItemEvent.SELECTED) {
				newfenetre.setUndecorated(true);
				GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().setFullScreenWindow(fenetre);
				fenetre = newfenetre;
			} else {
				newfenetre.setUndecorated(false);
				fenetre = newfenetre;
				fenetre.setVisible(true);
			}
		});

	}
}
