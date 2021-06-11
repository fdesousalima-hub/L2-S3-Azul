package groupe05.azul.ig;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import groupe05.azul.terminal.Tuiles;

/**
 * <b>Class qui affiche les tuiles dans l'interface</b>
 * 
 * @see Tuiles
 * 
 * @version 1.0
 * 
 */
public class TuilePanel extends JPanel {

	/**
	 * Tuile à afficher
	 *
	 * @see Tuiles
	 */
	private Tuiles tuile;
	/**
	 * Couleur à afficher
	 *
	 * @see Tuiles
	 */
	private Color couleur;

	/**
	 * Constructeur TuilePanel
	 * 
	 * @param tuile
	 * @param transparent
	 */
	public TuilePanel(Tuiles tuile, boolean transparent) {
		this.tuile = tuile;
		this.setBorder(BorderFactory.createLineBorder(Color.black));
		switch (tuile.getCouleur()) {
		case NOIR:
			couleur = Color.BLACK;
			break;
		case BLEU:
			couleur = Color.BLUE;
			break;
		case GRIS:
			couleur = Color.GRAY;
			break;
		case JAUNE:
			couleur = Color.YELLOW;
			break;
		case ROUGE:
			couleur = Color.RED;
			break;
		case INDEPENDANTE:
			couleur = Color.GREEN;
			JLabel un = new JLabel("1");
			un.setHorizontalAlignment(SwingConstants.CENTER);
			add(un);
			break;
		case VIDE:
			couleur = Color.WHITE;
			break;

		default:
			couleur = Color.WHITE;
			break;
		}
		if (transparent) {
			setBackground(new Color(couleur.getRed(), couleur.getGreen(), couleur.getBlue(), 50));
		} else {
			setBackground(couleur);
		}
	}

	/**
	 * Retourne la tuile
	 * 
	 * @return la tuile
	 */
	public Tuiles getTuiles() {
		return tuile;
	}

	/**
	 * Retourne la couleur
	 * 
	 * @return la couleur
	 */
	public Color getCouleur() {
		return couleur;
	}
}
