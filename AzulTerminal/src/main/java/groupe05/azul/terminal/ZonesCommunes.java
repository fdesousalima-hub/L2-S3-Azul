package groupe05.azul.terminal;

/**
 * <b>ZonesCommunes des Joueur</b>
 *
 * 
 * @see Tuiles
 * @see Fabrique
 * @see CentreTable
 * 
 * @version 1.0
 */
public abstract class ZonesCommunes {

	/**
	 * Retourne le tableau d'une ZonesCommunes
	 * 
	 * @return le tableau d'une ZonesCommunes
	 * 
	 * @see ZonesCommunes
	 */
	public abstract Tuiles[] getTableauDeTuiles();

	/**
	 * Initialise les zones communes
	 * 
	 * 
	 * @see ZonesCommunes
	 */
	public abstract void initialiser();

	/**
	 * Ajoute des Tuiles au ZonesCommunes
	 * 
	 * @param tuileAAjouter
	 * 
	 * @see ZonesCommunes
	 */
	public abstract void ajouter(Tuiles[] tuileAAjouter);

	/**
	 * Retourne vrai si la ZonesCommunes est vide
	 * 
	 * @return vrai si la ZonesCommunes est vide
	 * 
	 * @see ZonesCommunes
	 */
	public boolean estVide() {
		Tuiles[] tableauDeTuile = getTableauDeTuiles();
		for (Tuiles tuile : tableauDeTuile) {
			if (tuile.getCouleur() != CouleurTuiles.VIDE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Retourne toutes les information d'une ZonesCommunes
	 * 
	 * @return toutes les information d'une ZonesCommunes
	 * 
	 * @see ZonesCommunes
	 */
	@Override
	public String toString() {
		Tuiles[] tableauDeTuile = getTableauDeTuiles();
		String res = "[";
		for (Tuiles tuile : tableauDeTuile) {
			res += " " + tuile + ",";
		}
		return res + "]";
	}

}
