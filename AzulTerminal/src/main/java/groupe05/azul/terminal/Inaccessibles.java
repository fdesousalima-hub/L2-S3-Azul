package groupe05.azul.terminal;

/**
 * <b>Inaccessibles par les Joueur</b>
 *
 * 
 * @see Sac
 * @see Defausse
 * 
 * @version 1.0
 */
public abstract class Inaccessibles {

	/**
	 * Le double tableau de Tuiles. Qui est un sac dans sac et une defausse dans
	 * defausse
	 * 
	 * @see Sac
	 * @see Defausse
	 */
	protected Tuiles[][] sacOuDefausse;

	/**
	 * Retourne le sacouDefausse
	 * 
	 * @return tableau de tableau le sacouDefausse
	 * 
	 * @see Inaccessibles
	 * @see Inaccessibles#sacOuDefausse
	 */
	public Tuiles[][] getSacOuDefausse() {
		return sacOuDefausse;
	}

	/**
	 * Créer les tuiles du sac ou de la defausse
	 * 
	 * @see Inaccessibles
	 */
	public Inaccessibles() {
		sacOuDefausse = new Tuiles[5][20];
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				sacOuDefausse[i][j] = new Tuiles(CouleurTuiles.VIDE);
			}
		}
	}

	/**
	 * Retourne la taille totale du sac ou de la defausse
	 * 
	 * @return la taille totale du sac ou de la defausse
	 * 
	 * @see Inaccessibles
	 */
	public int getTaille() {
		return sacOuDefausse.length * sacOuDefausse[0].length;
	}

	/**
	 * Affiche le sac ou la defausse
	 * 
	 * 
	 * @see Inaccessibles
	 */
	@Override
	public String toString() {
		String res = "";
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				res += sacOuDefausse[i][j];
			}
			res += "\n";
		}
		return res;
	}

	/**
	 * Vérifie que le sac ou la defausse ne sont pas vides
	 * 
	 * @return true si le sac ou la defausse est vide
	 * 
	 * @see Inaccessibles
	 */
	public boolean estVide() {
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				if (sacOuDefausse[i][j].getCouleur() != CouleurTuiles.VIDE) {
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * place une tuiles dans le sac
	 * 
	 * @param t
	 * 
	 * @see Inaccessibles
	 * @see Tuiles
	 */
	public void placer(Tuiles t) {
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				if (sacOuDefausse[i][j].getCouleur() == CouleurTuiles.VIDE) {
					sacOuDefausse[i][j] = t;
					i = sacOuDefausse.length;
					break;
				}
			}
		}
	}
}
