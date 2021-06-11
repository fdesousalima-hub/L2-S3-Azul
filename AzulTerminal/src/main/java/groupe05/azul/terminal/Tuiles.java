package groupe05.azul.terminal;

/**
 * <b>Tuiles est la class représentant la pièce prise et posée par le Joueur</b>
 * <p>
 * Une Tuiles est caractérisée par :
 * <ul>
 * <li>Une couleur</li>
 * </ul>
 * </p>
 * 
 * @see CouleurTuiles
 * 
 * @version 1.0
 */
public class Tuiles {
	/**
	 * La couleur d'une Tuiles. La couleur n'est pas modifiable.
	 * 
	 * @see Tuiles#Tuiles(CouleurTuiles)
	 * @see Tuiles#getCouleur()
	 * @see Tuiles
	 */
	private final CouleurTuiles couleur;

	/**
	 * Constructeur Tuiles.
	 * 
	 * @param couleur La couleur d'une Tuiles
	 * 
	 * @see Tuiles#couleur
	 * @see Tuiles
	 */

	public Tuiles(CouleurTuiles couleur) {
		this.couleur = couleur;
	}

	/**
	 * Retourne la couleur d'une Tuiles
	 * 
	 * @return la couleur de la Tuiles
	 * 
	 * @see Tuiles
	 * @see CouleurTuiles
	 */
	public CouleurTuiles getCouleur() {
		return couleur;
	}

	/**
	 * Retourne l'affichage d'une Tuiles
	 * 
	 * @return l'affichage d'une Tuiles
	 * 
	 * @see Tuiles
	 */
	@Override
	public String toString() {
		return "" + couleur.getCouleur();
	}

	/**
	 * verifie si la tuile est independante
	 * 
	 * @return l'affichage d'une Tuiles
	 * 
	 * @see Tuiles
	 */
	public boolean estIndependante() {
		return this.getCouleur() == CouleurTuiles.INDEPENDANTE;
	}
}
