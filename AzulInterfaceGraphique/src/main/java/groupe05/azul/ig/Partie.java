package groupe05.azul.ig;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import groupe05.azul.terminal.Jeu;
import groupe05.azul.terminal.Joueur;
import groupe05.azul.terminal.Tour;
import groupe05.azul.terminal.Tuiles;

/**
 * <b>Partie est la class qui permet de lancer le jeu</b>
 * 
 * @see Jeu
 * @see Contenu
 * 
 * @version 1.0
 */
public class Partie extends Jeu {

	/**
	 * Contenu de la fenêtre
	 *
	 * @see Contenu
	 * @see Partie
	 * @see Partie#Partie(Contenu, Joueur[])
	 * @see TourIG
	 */
	private Contenu contenu;

	/**
	 * Constructeur Partie
	 * 
	 * @param contenu
	 * @param tousLesJoueur
	 * 
	 * @see Contenu
	 * 
	 */
	public Partie(Contenu contenu, Joueur[] tousLesJoueur) {
		super();
		this.tousLesJoueur = tousLesJoueur;
		this.contenu = contenu;
	}

	/**
	 * Permet de lancer le jeu
	 * 
	 * @throws Exception
	 *
	 * @see Jeu
	 */
	@Override
	public void start() throws Exception {
		TourIG t = new TourIG(this);
		t.commencerTour();
	}

	/**
	 * <b>La class TourIG qui permet de lancer un tour</b>
	 * 
	 * @see Tour
	 * 
	 * @version 1.0
	 */
	public class TourIG extends Tour {

		/**
		 * Fabrique pour l'interface
		 *
		 * @see TourIG
		 * @see TourIG#TourIG(Jeu)
		 * @see TourIG#afficherFabrique()
		 * @see TourIG#creeFenetre()
		 */
		private JPanel fabriquesPanel;

		/**
		 * CentreTable pour l'interface
		 *
		 * @see TourIG
		 * @see TourIG#TourIG(Jeu)
		 * @see TourIG#afficherCentreTable()
		 * @see TourIG#creeFenetre()
		 * @see CustomMouseAdapter
		 */
		private JPanel centreTablePanel;

		/**
		 * tous les joueurs pour l'interface
		 *
		 * @see TourIG
		 * @see TourIG#TourIG(Jeu)
		 * @see TourIG#afficherJoueurs()
		 * @see TourIG#creeFenetre()
		 * @see TourIG#removeAllJoueur()
		 * @see TourIG#addPanelJoueur(GridBagConstraints)
		 * @see CustomMouseAdapter
		 */
		private JPanel[] joueursPanel;
		/**
		 * Nom du tour
		 *
		 * @see TourIG
		 * @see TourIG#creeFenetre()
		 * @see TourIG#removeAllJoueur()
		 * @see TourIG#phaseDePioche()
		 * @see TourIG#pageVictoire()
		 */
		private JLabel nomTour;

		/**
		 * Position du joueur qui joue
		 *
		 * @see TourIG
		 * @see TourIG#phaseDePioche()
		 * @see CustomMouseAdapter
		 */
		private int positionJoueurQuiJoue;
		/**
		 * Compteur pour avoir les joueurs au fur et a mesuré
		 *
		 * @see TourIG
		 * @see TourIG#commencerTour()
		 * @see TourIG#phaseDePioche()
		 * @see CustomMouseAdapter
		 */
		private int compteurPosition = 0;

		/**
		 * Constructeur TourIG
		 * 
		 * @param jeu
		 *
		 * @see TourIG
		 * 
		 */
		public TourIG(Jeu jeu) {
			super(jeu);
			CustomMouseAdapter listener = new CustomMouseAdapter();
			contenu.addMouseListener(listener);
			contenu.addMouseMotionListener(listener);
			centreTablePanel = new JPanel();

			fabriquesPanel = new JPanel();
			joueursPanel = new JPanel[4];
			for (int i = 0; i < joueursPanel.length; i++) {
				joueursPanel[i] = new JPanel();
			}
		}

		/**
		 * Permet de commencer un tour
		 *
		 *
		 * @see TourIG
		 */
		public void commencerTour() {
			compteurPosition = phasePreparation();
			afficherTout();
			phaseDePioche();
			phaseDecoration();
		}

		/**
		 * Affiche tout les information pour les joueurs
		 *
		 *
		 * @see TourIG
		 */
		@Override
		protected void afficherTout() {
			creeFenetre();
			afficherFabrique();
			afficherCentreTable();
			afficherJoueurs();
		}

		/**
		 * Affiche le centre de la table
		 *
		 *
		 * @see TourIG
		 */
		@Override
		protected void afficherCentreTable() {
			centreTablePanel.setBorder(BorderFactory.createLineBorder(Color.black));
			centreTablePanel.setLayout(new GridLayout(1, 1));
			centreTablePanel.add(new CentreTablePanel(centreTable));
		}

		/**
		 * Affiche les fabriques
		 *
		 *
		 * @see TourIG
		 */
		@Override
		protected void afficherFabrique() {
			fabriquesPanel.setLayout(new GridLayout(1, fabriques.length, 5, 0));
			for (int i = 0; i < fabriques.length; i++) {
				fabriquesPanel.add(new FabriquePanel(fabriques[i], i));
			}

		}

		/**
		 * Affiche tout les joueur
		 *
		 *
		 * @see TourIG
		 */
		@Override
		protected void afficherJoueurs() {
			for (int i = 0; i < tousLesJoueur.length; i++) {
				joueursPanel[i].setBackground(Color.BLACK);
				joueursPanel[i].setLayout(new GridLayout(1, 1));
				joueursPanel[i].add(new JoueurPanel(tousLesJoueur[i]));
			}
		}

		/**
		 * Permet de crée la page de jeu
		 *
		 *
		 * @see TourIG
		 */
		private void creeFenetre() {
			contenu.nouvellePage();
			nomTour = new JLabel();
			nomTour.setHorizontalAlignment(SwingConstants.CENTER);
			contenu.setLayout(new GridBagLayout());

			GridBagConstraints c = new GridBagConstraints();

			c.fill = GridBagConstraints.BOTH;
			c.weightx = 1;
			c.weighty = 0.3;

			c.gridx = 0;

			c.gridy = 0;

			c.gridwidth = 3;

			contenu.add(nomTour, c);

			fabriquesPanel.removeAll();
			c.weighty = 0.5;

			c.gridx = 0;

			c.gridy = 1;

			contenu.add(fabriquesPanel, c);
			removeAllJoueur();

			c.weighty = 1;

			c.gridx = 0;

			c.gridy = 2;

			c.gridwidth = 1;

			addPanelJoueur(c);

			centreTablePanel.removeAll();

			c.gridx = 1;

			c.gridy = 2;

			c.gridwidth = 1;

			c.gridheight = 2;

			contenu.add(centreTablePanel, c);

		}

		/**
		 * Permet de mettre les joueurs a 0
		 *
		 *
		 * @see TourIG
		 */
		private void removeAllJoueur() {
			for (int i = 0; i < 4; i++) {
				joueursPanel[i].removeAll();
			}
		}

		/**
		 * Permet d'ajouter les joueurs
		 *
		 *
		 * @see TourIG
		 */
		private void addPanelJoueur(GridBagConstraints c) {
			int compteur = 0;
			for (int i = 0; i < 4; i++) {
				switch (i % 2) {
				case 0:
					c.gridx = 0;
					c.gridy = compteur + 2;
					c.gridwidth = 1;
					contenu.add(joueursPanel[i], c);
					break;

				case 1:
					c.gridx = 2;
					c.gridy = compteur + 2;
					c.gridwidth = 1;
					contenu.add(joueursPanel[i], c);
					compteur++;
					break;
				}
			}
		}

		/**
		 * Phase de pioche
		 *
		 *
		 * @see TourIG
		 */
		protected void phaseDePioche() {
			positionJoueurQuiJoue = compteurPosition % tousLesJoueur.length;
			nomTour.setText(
					"Tour: " + nbTour + "   " + tousLesJoueur[positionJoueurQuiJoue].getNom() + " à toi de jouer!");
			contenu.repaint();
			contenu.validate();
			compteurPosition++;
		}

		/**
		 * Phase de decoration ou l'on calcul les points
		 *
		 *
		 * @see TourIG
		 */
		protected void phaseDecoration() {
			for (int i = 0; i < jeu.tousLesJoueur.length; i++) {
				jeu.tousLesJoueur[i].finDeTour(jeu.defausse);
			}
		}

		/**
		 * Affiche le gagnant
		 *
		 *
		 * @see TourIG
		 */
		private void pageVictoire() {
			nomTour.setText("Fin de la partie");
			JLabel texteVictoire = new JLabel(joueurGagne().getNom() + " a gagner!");
			texteVictoire.setForeground(Color.green);
			JButton menuBouton = new JButton("Menu Principale");
			menuBouton.addActionListener((ActionEvent e) -> {
				contenu.pageDeLancement();
			});
			centreTablePanel.setLayout(new GridBagLayout());
			centreTablePanel.add(texteVictoire);
			centreTablePanel.add(menuBouton);
		}

		/**
		 * Permet de passer au joueur suivant
		 *
		 *
		 * @see TourIG
		 */
		private void prochainJoueur() {
			if (touteZonesCommunesVide()) {
				phaseDecoration();
				if (fin()) {
					afficherTout();
					pageVictoire();
				} else {
					nbTour++;
					commencerTour();
				}
			} else {
				afficherTout();
				phaseDePioche();
			}

		}

		/**
		 * <b>La class CustomMouseAdapter permet de gérer les événements de la souris
		 * </b>
		 * 
		 * @see TourIG
		 * 
		 * @version 1.0
		 */
		private class CustomMouseAdapter extends MouseAdapter {
			/**
			 * Tuile sélectionnée
			 *
			 * @see Tuiles
			 * @see CustomMouseAdapter
			 * @see CustomMouseAdapter#mousePressed(MouseEvent)
			 * @see CustomMouseAdapter#mouseReleased(MouseEvent)
			 * @see CustomMouseAdapter#prendreTuiles()
			 * 
			 */
			private ArrayList<Tuiles> tuileSelectioner;
			/**
			 * PanneauTuile sélectionnée
			 *
			 * @see TuilePanel
			 * @see CustomMouseAdapter
			 * @see CustomMouseAdapter#mousePressed(MouseEvent)
			 * @see CustomMouseAdapter#mouseReleased(MouseEvent)
			 * @see CustomMouseAdapter#prendreTuiles()
			 * 
			 */
			private TuilePanel select;
			/**
			 * Tuile a trainé
			 *
			 * @see CustomMouseAdapter
			 * @see CustomMouseAdapter#mousePressed(MouseEvent)
			 * @see CustomMouseAdapter#mouseReleased(MouseEvent)
			 * @see CustomMouseAdapter#ajoutTuilesTraine(ArrayList, int, int)
			 * @see CustomMouseAdapter#enleverTuilesTraine()
			 * @see TuileTraine
			 */
			private TuileTraine tuileTraine = null;
			/**
			 * Panneau pour les tuiles traine
			 *
			 * @see CustomMouseAdapter
			 * @see CustomMouseAdapter#ajoutTuilesTraine(ArrayList, int, int)
			 * @see CustomMouseAdapter#enleverTuilesTraine()
			 */
			private JLayeredPane panneauTraine;

			public CustomMouseAdapter() {
				panneauTraine = contenu.getFenetre().getLayeredPane();
			}

			/**
			 * Récupère le clic de la souris
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			@Override
			public void mousePressed(MouseEvent e) {
				Component src = SwingUtilities.getDeepestComponentAt(contenu, e.getX(), e.getY());
				tuileSelectioner = new ArrayList<Tuiles>();
				select = null;

				if (src instanceof TuilePanel) {
					select = (TuilePanel) src;
					Component parent = (Component) select.getParent();
					if (parent instanceof CentreTablePanel) {
						tuileSelectioner = ((CentreTablePanel) parent).getTable()
								.getTuilesCouleur(select.getTuiles().getCouleur());
						ajoutTuilesTraine(tuileSelectioner, e.getX(), e.getY());
					} else if (parent instanceof FabriquePanel) {
						tuileSelectioner = ((FabriquePanel) parent).getFabrique()
								.getTuilesCouleur(select.getTuiles().getCouleur());
						ajoutTuilesTraine(tuileSelectioner, e.getX(), e.getY());
					} else {
						select = null;
					}
				} else {
					select = null;
				}
			}

			/**
			 * Récupère le relâchement de la souris
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			@Override
			public void mouseReleased(MouseEvent e) {
				if (select != null) {
					Component src = SwingUtilities.getDeepestComponentAt(contenu, e.getX(), e.getY());
					Component parent = src.getParent();
					if (parent instanceof LigneMotifPanel.LigneDeLaLigneMotifPanel) {
						LigneMotifPanel panelMotif = (LigneMotifPanel) parent.getParent();
						Joueur joueurChoisit = panelMotif.getJoueur();
						if (joueurChoisit.equals(tousLesJoueur[positionJoueurQuiJoue])) {
							int ligne = ((LigneMotifPanel.LigneDeLaLigneMotifPanel) parent).getLigne();
							if ((tousLesJoueur[positionJoueurQuiJoue].getPlaJoueur().ligneLibre(ligne)
									|| tousLesJoueur[positionJoueurQuiJoue].getPlaJoueur()
											.estMemeCouleur(select.getTuiles(), ligne))
									&& !tousLesJoueur[positionJoueurQuiJoue].getPlaJoueur()
											.murCouleurFini(select.getTuiles().getCouleur(), ligne)) {
								prendreTuiles();
								panelMotif.getJoueur().getPlaJoueur().placerSurPlateau(
										tuileSelectioner.toArray(new Tuiles[tuileSelectioner.size()]), ligne, defausse);
								prochainJoueur();
							}
						}
					} else if (parent instanceof PlancherPanel) {
						PlancherPanel panelPlancher = (PlancherPanel) parent;
						Joueur joueurChoisit = panelPlancher.getJoueur();
						if (joueurChoisit.equals(tousLesJoueur[positionJoueurQuiJoue])) {
							prendreTuiles();
							panelPlancher.getJoueur().getPlaJoueur().placerPlancher(
									tuileSelectioner.toArray(new Tuiles[tuileSelectioner.size()]), 0,
									tuileSelectioner.size(), defausse);
							prochainJoueur();
						}

					} else {
						tuileSelectioner = new ArrayList<Tuiles>();
						select = null;
					}
				}
				enleverTuilesTraine();
			}

			/**
			 * Récupère le déplacement de la souris
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			@Override
			public void mouseDragged(MouseEvent e) {
				if (select != null && tuileTraine != null) {
					tuileTraine.x = e.getX();
					tuileTraine.y = e.getY();
					tuileTraine.repaint();
				}
			}

			/**
			 * Prends les tuiles
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			private void prendreTuiles() {
				Component parent = (Component) select.getParent();
				if (parent instanceof CentreTablePanel) {
					CentreTablePanel centreTablePanel = (CentreTablePanel) parent;
					tuileSelectioner = centreTablePanel.getTable().recupTuiles(select.getTuiles());
				} else if (parent instanceof FabriquePanel) {
					FabriquePanel fabriquePanel = (FabriquePanel) parent;
					tuileSelectioner = fabriquePanel.getFabrique().recupTuiles(select.getTuiles(), centreTable);
				}
			}

			/**
			 * Ajoute les tuiles à trainer
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			private void ajoutTuilesTraine(ArrayList<Tuiles> tiles, int x, int y) {
				tuileTraine = new TuileTraine(tiles, x, y);
				panneauTraine.add(tuileTraine, JLayeredPane.DRAG_LAYER);
				tuileTraine.setBounds(0, 0, 100000, 100000);
			}

			/**
			 * Enleve les tuiles à trainer
			 *
			 * @see CustomMouseAdapter
			 * 
			 */
			private void enleverTuilesTraine() {
				if (tuileTraine != null) {
					panneauTraine.remove(tuileTraine);
					tuileTraine = null;
					panneauTraine.repaint();
					contenu.repaint();
					contenu.validate();
				}
			}
		}

		/**
		 * <b>La class TuileTraine permet de dessiner les tuiles trainées </b>
		 * 
		 * @see TourIG
		 * 
		 * @version 1.0
		 */
		private class TuileTraine extends JComponent {

			/**
			 * Position de la souris
			 *
			 * @see TuileTraine
			 * @see TuileTraine#TuileTraine(ArrayList, int, int)
			 * @see TuileTraine#paintComponent(Graphics)
			 */
			private int x, y;

			/**
			 * Toutes les tuiles sélectionnées
			 *
			 * @see TuileTraine
			 * @see TuileTraine#TuileTraine(ArrayList, int, int)
			 * @see TuileTraine#paintComponent(Graphics)
			 */
			private ArrayList<Tuiles> tuiles;

			/**
			 * Constructeur TuileTraine
			 * 
			 * @param tuiles   
			 * @param x
			 * @param y
			 *
			 * @see TuileTraine
			 * 
			 */
			public TuileTraine(ArrayList<Tuiles> tuiles, int x, int y) {
				this.tuiles = tuiles;
				this.x = x;
				this.y = y;
			}

			/**
			 * Dessine les tuiles pendant que l'on glisse
			 * 
			 * @param g
			 *
			 * @see TuileTraine
			 * 
			 */
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				for (int i = 0; i < tuiles.size(); i++) {
					TuilePanel tuilesCourante = new TuilePanel(tuiles.get(i), false);
					g.setColor(new Color(tuilesCourante.getCouleur().getRed(), tuilesCourante.getCouleur().getGreen(),
							tuilesCourante.getCouleur().getBlue(), 100));
					g.fillRect(-25 + x + i * 10, -25 + y + i * 10, 50, 50);
				}
			}

		}
	}
}
