package groupe05.azul.terminal;

/**
 * <b>Couleur d'une Tuiles utilisable</b>
 * <p>
 * <ul>
 * <li>{@link CouleurTuiles#BLEU}</li>
 * <li>{@link CouleurTuiles#JAUNE}</li>
 * <li>{@link CouleurTuiles#ROUGE}</li>
 * <li>{@link CouleurTuiles#NOIR}</li>
 * <li>{@link CouleurTuiles#GRIS}</li>
 * <li>{@link CouleurTuiles#INDEPENDANTE}</li>
 * </ul>
 * </p>
 *
 * @see Tuiles
 *
 * @version 1.0
 */

public enum CouleurTuiles {

	/**
	 * Couleur Bleu
	 */
	BLEU('b', 0),
	/**
	 * Couleur Jaune
	 */
	JAUNE('j', 1),
	/**
	 * Couleur Rouge
	 */
	ROUGE('r', 2),
	/**
	 * Couleur Noir
	 */
	NOIR('n', 3),
	/**
	 * Couleur Gris
	 */
	GRIS('g', 4),
	/**
	 * Couleur Independante
	 */
	INDEPENDANTE('i', -1),
	/**
	 * Tuile vide
	 */
	VIDE('X', -2);

	/**
	 * Caractère pour l'affichage
	 *
	 * @see CouleurTuiles
	 * @see CouleurTuiles#CouleurTuiles(char, int)
	 * @see CouleurTuiles#getCouleur()
	 */
	private char couleur;
	/**
	 * Entier pour récupérer la couleur
	 *
	 * @see CouleurTuiles
	 * @see CouleurTuiles#CouleurTuiles(char, int)
	 * @see CouleurTuiles#tuileByIndex(int)
	 */
	private int index;

	/**
	 * Constructeur CouleurTuiles.
	 *
	 * @param couleur de la couleur
	 * @param index   de la couleur
	 *
	 * @see CouleurTuiles
	 * @see CouleurTuiles#couleur
	 * @see CouleurTuiles#index
	 */
	private CouleurTuiles(char couleur, int index) {
		this.couleur = couleur;
		this.index = index;
	}

	/**
	 * Retourne le char de la couleur
	 *
	 * @return le char de la couleur
	 *
	 * @see CouleurTuiles
	 * @see CouleurTuiles#couleur
	 */
	public char getCouleur() {
		return couleur;
	}

	/**
	 * Retourne l'index de la couleur
	 *
	 * @return l'index de la couleur
	 *
	 * @see CouleurTuiles
	 * @see CouleurTuiles#index
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Retourne la couleur grâce à un index
	 * 
	 * @param index
	 *
	 * @return la couleur
	 * @throws Exception 
	 *
	 * @see CouleurTuiles
	 */
	public static CouleurTuiles tuileByIndex(int index) throws Exception {
		if (index < 0) {
			index = 5 + index;
		}
		for (CouleurTuiles c : values()) {
			if (index == c.getIndex()) {
				return c;
			}
		}
		throw new Exception("Couleur n'existe pas");
	}
}
