package groupe05.azul.terminal;

/**
 * <b>Defausse des tuiles</b>
 *
 *
 * @see Tuiles
 * @see Sac
 * @see Inaccessibles
 *
 * @version 1.0
 */
public class Defausse extends Inaccessibles {

	/**
	 * Vide la defausse
	 *
	 * @see Defausse
	 */
	public void vider() {
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				sacOuDefausse[i][j] = new Tuiles(CouleurTuiles.VIDE);
			}
		}
	}
}
