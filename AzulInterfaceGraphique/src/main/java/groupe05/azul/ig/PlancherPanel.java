package groupe05.azul.ig;

import java.awt.GridLayout;

import javax.swing.JPanel;

import groupe05.azul.terminal.Joueur;

/**
 * <b>Class qui affiche le plancher d'un Joueur dans l'interface</b>
 * 
 * @see Joueur
 * 
 * @version 1.0
 * 
 */
public class PlancherPanel extends JPanel {
	/**
	 * Joueur de la LigneMotif
	 *
	 * @see Joueur
	 * @see PlancherPanel#PlancherPanel(Joueur)
	 */
	private Joueur joueur;

	/**
	 * Constructeur MurPanel
	 * 
	 * @param joueur
	 *
	 * @see MurPanel
	 * 
	 */
	public PlancherPanel(Joueur joueur) {
		this.joueur = joueur;
		setLayout(new GridLayout(1, 7));
		for (int i = 0; i < joueur.getPlaJoueur().getPlancher().length; i++) {
			add(new TuilePanel(joueur.getPlaJoueur().getPlancher()[i], false));
		}
	}

	/**
	 * Retourne le joueur
	 * 
	 * @return Le joueur
	 * 
	 * @see PlancherPanel
	 * @see PlancherPanel#joueur
	 */
	public Joueur getJoueur() {
		return joueur;
	}

}
