package groupe05.azul.terminal;

import java.util.*;

/**
 * <b>Sac est la classe représentant toutes les Tuiles piochable</b>
 * <p>
 * Un Sac est caractérisé par :
 * <ul>
 * <li>Un double tableau de Tuiles de 5*20 (Total: 100)</li>
 * </ul>
 * </p>
 * 
 * @see Tuiles
 * @see Inaccessibles
 * @see Defausse
 * 
 * @version 1.0
 */

public class Sac extends Inaccessibles {

	/**
	 * Constructeur de sac Crée le sac de 100 tuiles, 20 de chaque couleur
	 * différente
	 * 
	 * @see Sac
	 */
	public Sac() {
		super();
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				try {
					sacOuDefausse[i][j] = new Tuiles(CouleurTuiles.tuileByIndex(i));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Pioche une Tuiles aléatoire et qui lève une erreur si le sac est vide
	 * 
	 * @param defausse
	 * 
	 * @return 2 entiers (x et y)
	 * @throws RuntimeException "Sac est vide"
	 * 
	 * @see Sac
	 * @see Defausse
	 */
	public Tuiles piocherRandom(Defausse defausse) {
		Random r = new Random();
		boolean bool = true;
		do {
			int random = r.nextInt(getTaille());
			int[] res = { random / sacOuDefausse[0].length, random % sacOuDefausse[0].length };
			if (sacOuDefausse[res[0]][res[1]].getCouleur() != CouleurTuiles.VIDE) {
				Tuiles resultat = sacOuDefausse[res[0]][res[1]];
				sacOuDefausse[res[0]][res[1]] = new Tuiles(CouleurTuiles.VIDE);
				return resultat;
			}
			if (estVide()) {
				if (!defausse.estVide()) {
					remplir(defausse);
				} else {
					bool = false;
				}
			}
		} while (bool);
		throw new RuntimeException("Sac et Defausse est vide");
	}

	/**
	 * Rempli le sac avec defausse
	 * 
	 * @param defausse
	 * 
	 * @see Sac
	 * @see Defausse
	 */
	private void remplir(Defausse defausse) {
		for (int i = 0; i < sacOuDefausse.length; i++) {
			for (int j = 0; j < sacOuDefausse[i].length; j++) {
				sacOuDefausse[i][j] = defausse.getSacOuDefausse()[i][j];
			}
		}
		defausse.vider();

	}

}
