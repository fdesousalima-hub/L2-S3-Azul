package groupe05.azul.ig;

import java.awt.GridLayout;

import javax.swing.JPanel;

import groupe05.azul.terminal.Fabrique;
import groupe05.azul.terminal.Tuiles;

/**
 * <b>Class qui affiche une Fabrique dans l'interface</b>
 * 
 * @see Fabrique
 * 
 * @version 1.0
 * 
 */
public class FabriquePanel extends JPanel {
	/**
	 * Numero de fabique
	 *
	 * @see FabriquePanel
	 * @see FabriquePanel#FabriquePanel(Fabrique, int)
	 * @see FabriquePanel#getNum()()
	 */
	private int num;
	/**
	 * Fabique
	 *
	 * @see Fabrique
	 * @see FabriquePanel#FabriquePanel(Fabrique, int)
	 * @see FabriquePanel#getFabrique()
	 */
	private Fabrique fabrique;

	/**
	 * Constructeur FabriquePanel
	 * 
	 * @param fabrique
	 * @param num
	 *
	 * @see Fabrique
	 * 
	 */
	public FabriquePanel(Fabrique fabrique, int num) {
		this.fabrique = fabrique;
		this.num = num;
		setLayout(new GridLayout(2, 2));
		for (Tuiles tuile : fabrique.getTuiles()) {
			add(new TuilePanel(tuile, false));
		}
	}

	/**
	 * Retourne le numéro de Fabrique
	 * 
	 * @return Numéro de Fabrique
	 *
	 * @see FabriquePanel
	 * @see FabriquePanel#num
	 * 
	 */
	public int getNum() {
		return num;
	}

	/**
	 * Retourne la Fabrique
	 * 
	 * @return la Fabrique
	 *
	 * @see FabriquePanel
	 * @see FabriquePanel#fabrique
	 */
	public Fabrique getFabrique() {
		return fabrique;
	}
}
