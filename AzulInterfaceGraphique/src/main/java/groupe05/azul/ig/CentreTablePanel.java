package groupe05.azul.ig;

import java.awt.GridLayout;

import javax.swing.JPanel;

import groupe05.azul.terminal.CentreTable;
/**
 * <b>Class qui affiche le centreTable dans l'interface</b>
 * 
 * @see CentreTable
 * 
 * @version 1.0
 * 
 */
public class CentreTablePanel extends JPanel {
	/**
	 * Centre de la table
	 *
	 * @see CentreTable
	 * @see CentreTablePanel#CentreTablePanel(CentreTable)
	 * @see CentreTablePanel#getTable()
	 */
	private CentreTable centreTable;
	
	/**
	 * Constructeur CentreTablePanel
	 * 
	 * @param centreTable
	 *
	 * @see CentreTable
	 * 
	 */
	public CentreTablePanel(CentreTable centreTable) {
		this.centreTable=centreTable;
		setLayout(new GridLayout(5,5,5,5));
		for (int i = 0; i < centreTable.getTableauDeTuiles().length; i++) {
			TuilePanel tuilepanel =new TuilePanel(centreTable.getTableauDeTuiles()[i],false);
			add(tuilepanel);
		}
	}

	/**
	 * Retourne le Centre de la table
	 * 
	 * @return Centre de la table
	 * 
	 * @see CentreTablePanel
	 * @see CentreTablePanel#centreTable
	 */
	public CentreTable getTable() {
		return centreTable;
	}

}
