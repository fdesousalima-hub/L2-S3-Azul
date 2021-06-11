package groupe05.azul.terminal;

import java.util.ArrayList;

/**
 * <b>Centre de la table qui contient les Tuiles pas encore piochées</b>
 *
 * @see Tuiles
 * @see ZonesCommunes
 * 
 * @version 1.0
 */
public class CentreTable extends ZonesCommunes {

	/**
	 * Toutes les tuiles non utilisées dans les fabriques et piochable par un joueur
	 *
	 * @see Tuiles
	 */
	private ArrayList<Tuiles> tuilesDeCentreTable;

	/**
	 * Constructeur CentreTable.
	 * 
	 * @see CentreTable
	 */
	public CentreTable() {
		super();
		initialiser();
	}

	/**
	 * Taille du tableau qui contient les tuiles
	 * 
	 * @return la taille du tableau qui contient les tuiles
	 * 
	 * @see CentreTable
	 * @see CentreTable#tuilesDeCentreTable
	 */
	public int getTaille() {
		return tuilesDeCentreTable.size();
	}

	/**
	 * Initialise le CentreTable
	 * 
	 * 
	 * @see CentreTable
	 * @see CentreTable#tuilesDeCentreTable
	 */
	@Override
	public void initialiser() {
		tuilesDeCentreTable = new ArrayList<Tuiles>();
		tuilesDeCentreTable.add(new Tuiles(CouleurTuiles.INDEPENDANTE));
	}

	/**
	 * Retourne le tableau les tuiles choisies par un joueur
	 * 
	 * @return les tuiles choisies par un joueur
	 * 
	 * @see CentreTable
	 */

	public Tuiles[] recupTuiles(int positionDeLaTuile) {
		ArrayList<Tuiles> t = new ArrayList<Tuiles>();
		CouleurTuiles couleurPiocher = tuilesDeCentreTable.get(positionDeLaTuile).getCouleur();
		for (int i = 0; i < tuilesDeCentreTable.size(); i++) {
			Tuiles temp = tuilesDeCentreTable.get(i);
			System.out.println(tuilesDeCentreTable.size());

			if (temp.estIndependante()) {
				t.add(temp);
				tuilesDeCentreTable.remove(i--);
				System.out.println(tuilesDeCentreTable.size());

			} else if (temp.getCouleur() == couleurPiocher) {
				t.add(temp);
				tuilesDeCentreTable.remove(i--);
			}
		}
		return t.toArray(new Tuiles[t.size()]);
	}

	public ArrayList<Tuiles> recupTuiles(Tuiles tuile) {
		ArrayList<Tuiles> t = new ArrayList<Tuiles>();
		CouleurTuiles couleurPiocher = tuile.getCouleur();
		for (int i = 0; i < tuilesDeCentreTable.size(); i++) {
			Tuiles temp = tuilesDeCentreTable.get(i);
			if (temp.estIndependante()) {
				t.add(temp);
				tuilesDeCentreTable.remove(i--);
			} else if (temp.getCouleur() == couleurPiocher) {
				t.add(temp);
				tuilesDeCentreTable.remove(i--);
			}
		}
		return t;
	}

	/**
	 * Ajoute des Tuiles au CentreTable
	 * 
	 * 
	 * @see CentreTable
	 * @see Tuiles
	 */
	public void ajouter(Tuiles[] tuileAAjouter) {
		for (int i = 0; i < tuileAAjouter.length; i++) {
			tuilesDeCentreTable.add(tuileAAjouter[i]);
		}
	}

	/**
	 * Retourne le tableau de tuiles du centre de la table
	 * 
	 * @return le tableau de tuiles du centre de la table
	 * 
	 * @see CentreTable
	 */
	@Override
	public Tuiles[] getTableauDeTuiles() {
		return tuilesDeCentreTable.toArray(new Tuiles[tuilesDeCentreTable.size()]);
	}

	/**
	 * Retourne le tableau de tuile du centre de la table
	 * 
	 * @return le tableau de tuile du centre de la table
	 * 
	 * @see CentreTable
	 */
	public ArrayList<Tuiles> getTuilesCouleur(CouleurTuiles couleurPiocher) {
		ArrayList<Tuiles> t = new ArrayList<Tuiles>();
		for (int i = 0; i < tuilesDeCentreTable.size(); i++) {
			Tuiles temp = tuilesDeCentreTable.get(i);
			if (temp.estIndependante()) {
				t.add(temp);
			} else if (temp.getCouleur() == couleurPiocher) {
				t.add(temp);
			}
		}
		return t;

	}

}
