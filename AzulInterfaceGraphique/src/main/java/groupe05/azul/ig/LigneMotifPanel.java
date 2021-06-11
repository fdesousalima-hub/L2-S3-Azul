package groupe05.azul.ig;

import java.awt.GridLayout;

import javax.swing.JPanel;

import groupe05.azul.terminal.Joueur;
import groupe05.azul.terminal.Tuiles;

/**
 * <b>Class qui affiche la LigneMotif d'un Joueur dans l'interface</b>
 * 
 * @see Joueur
 * 
 * @version 1.0
 * 
 */
public class LigneMotifPanel extends JPanel {

	/**
	 * Joueur de la LigneMotif
	 *
	 * @see Joueur
	 * @see LigneMotifPanel#LigneMotifPanel(Joueur)
	 * @see LigneMotifPanel#getJoueur()
	 */
	private Joueur joueur;

	/**
	 * Constructeur LigneMotifPanel
	 * 
	 * @param joueur
	 *
	 * @see LigneMotifPanel
	 * 
	 */
	public LigneMotifPanel(Joueur joueur) {
		this.joueur = joueur;
		setLayout(new GridLayout(joueur.getPlaJoueur().getLignesMotif().length, 1));
		for (int i = 0; i < joueur.getPlaJoueur().getLignesMotif().length; i++) {
			add(new LigneDeLaLigneMotifPanel(joueur.getPlaJoueur().getLignesMotif()[i], i));
		}
	}

	/**
	 * Retourne le joueur
	 * 
	 * @return Le joueur
	 * 
	 * @see LigneMotifPanel
	 * @see LigneMotifPanel#joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

	/**
	 * <b>Class qui affiche une ligne de LigneMotif</b>
	 * 
	 * @see Joueur
	 * 
	 * @version 1.0
	 * 
	 */
	public class LigneDeLaLigneMotifPanel extends JPanel {
		/**
		 * Ligne de ligne motif
		 *
		 * @see Joueur
		 * @see LigneDeLaLigneMotifPanel
		 * @see LigneDeLaLigneMotifPanel#LigneDeLaLigneMotifPanel(Tuiles[], int)
		 * @see LigneDeLaLigneMotifPanel#getLigne()
		 */
		private int ligne;

		/**
		 * Constructeur LigneDeLaLigneMotifPanel
		 * 
		 * @param tuiles
		 * @param ligne
		 *
		 * @see LigneDeLaLigneMotifPanel
		 * 
		 */
		public LigneDeLaLigneMotifPanel(Tuiles[] tuiles, int ligne) {
			this.ligne = ligne;
			int compteur = 0;
			setLayout(new GridLayout(1, 5));
			for (int i = 0; i < 4 - ligne; i++) {
				JPanel vide = new JPanel();
				vide.setVisible(false);
				add(vide);
			}
			for (int i = 4 - ligne; i < 5; i++) {
				add(new TuilePanel(tuiles[compteur++], false));
			}
		}

		/**
		 * Retourne la ligne de ligne motif
		 * 
		 * @return la ligne de ligne motif
		 * 
		 * @see LigneDeLaLigneMotifPanel
		 * @see LigneDeLaLigneMotifPanel#ligne
		 */
		public int getLigne() {
			return ligne;
		}
	}
}
