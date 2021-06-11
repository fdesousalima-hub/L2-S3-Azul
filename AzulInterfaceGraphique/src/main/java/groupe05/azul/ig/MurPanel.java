package groupe05.azul.ig;

import java.awt.GridLayout;

import javax.swing.JPanel;

import groupe05.azul.terminal.CouleurTuiles;
import groupe05.azul.terminal.Joueur;

/**
 * <b>Class qui affiche le mur d'un Joueur dans l'interface</b>
 * 
 * @see Joueur
 * 
 * @version 1.0
 * 
 */
public class MurPanel extends JPanel {
	/**
	 * Joueur de la LigneMotif
	 *
	 * @see Joueur
	 * @see MurPanel#MurPanel(Joueur)
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
	public MurPanel(Joueur joueur) {
		this.joueur = joueur;
		setLayout(new GridLayout(5, 5));
		for (int i = 0; i < joueur.getPlaJoueur().getMur().length; i++) {
			for (int j = 0; j < joueur.getPlaJoueur().getMur()[i].length; j++) {
				if (joueur.getPlaJoueur().getMur()[i][j].getCouleur() != CouleurTuiles.VIDE) {
					add(new TuilePanel(joueur.getPlaJoueur().getMur()[i][j], false));
				} else {
					add(new TuilePanel(joueur.getPlaJoueur().getMurFini()[i][j], true));
				}
			}
		}
	}

}
