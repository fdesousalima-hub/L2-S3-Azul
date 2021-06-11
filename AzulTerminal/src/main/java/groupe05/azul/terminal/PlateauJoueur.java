package groupe05.azul.terminal;

/**
 * <b>PlateauJoueur est la classe représentant le plateau d'un joueur</b>
 * <p>
 * Un PlateauJoueur est caractérisé par :
 * <ul>
 * <li>Une lignes motif</li>
 * <li>Un mur</li>
 * <li>Un mur fini</li>e Ohlmann, 306B Ha
 * <li>Un plancher</li>
 * </ul>
 * </p>
 *
 * @see Joueur
 * @see Fabrique
 * @see CentreTable
 * @see Tuiles
 *
 * @version 1.0
 */
public class PlateauJoueur {

	/**
	 * La ligne motif d'un Joueur.
	 *
	 * @see PlateauJoueur#PlateauJoueur()e Ohlmann, 306B Ha
	 * @see PlateauJoueur#lignesMotifToString()
	 * @see PlateauJoueur#placerSurPlateau(Tuiles[], int, Defausse)
	 * @see PlateauJoueur#ligneLibre(int)
	 * @see PlateauJoueur#estMemeCouleur(Tuiles[], int)
	 * @see PlateauJoueur#finirLigneEtScore()
	 * @see PlateauJoueur#ligneEstFini(int)
	 * @see PlateauJoueur
	 */
	private Tuiles[][] lignesMotif;

	/**
	 * Le mur d'un Joueur.
	 *
	 * @see PlateauJoueur#PlateauJoueur()
	 * @see PlateauJoueur#murToString()()
	 * @see PlateauJoueur#finirLigneEtScore()
	 * @see PlateauJoueur#ligneMurFini()
	 * @see PlateauJoueur#pointParLignesEtColones()
	 * @see PlateauJoueur#murCouleurFini(CouleurTuiles, int)
	 * @see PlateauJoueur
	 */
	private Tuiles[][] mur;

	/**
	 * Le murfini d'un Joueur. Le murfini n'est pas modifiable.
	 *
	 * @see PlateauJoueur#PlateauJoueur()
	 * @see PlateauJoueur#creeMurFini()
	 * @see PlateauJoueur#finirLigneEtScore()
	 * @see PlateauJoueur
	 *
	 */
	private final Tuiles[][] murFini;

	/**
	 * Le plancher d'un Joueur.
	 *
	 * @see PlateauJoueur#PlateauJoueur()
	 * @see PlateauJoueur#plancherToString()
	 * @see PlateauJoueur#placerPlancher(Tuiles[], int, int, Defausse)
	 * @see PlateauJoueur#libererPlancher(Defausse)
	 * @see PlateauJoueur
	 */
	private Tuiles[] plancher;

	/**
	 * Nombre de colonne completer
	 *
	 * @see PlateauJoueur
	 * 
	 */
	private int nbColonneTotal = 0;

	/**
	 * Constructeur PlateauJoueur.
	 *
	 * @see PlateauJoueur#lignesMotif
	 * @see PlateauJoueur#mur
	 * @see PlateauJoueur#murFini
	 * @see PlateauJoueur#plancher
	 * @see PlateauJoueur
	 */
	public PlateauJoueur() {
		this.lignesMotif = creeLigneMotif();
		initialiserLigneMotif();
		this.mur = creeMur();
		this.murFini = creeMurFini();
		creePlancher();
	}

	/**
	 * Creer un tableau plancher
	 * 
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 */

	private void creePlancher() {
		plancher = new Tuiles[7];
		for (int i = 0; i < plancher.length; i++) {
			plancher[i] = new Tuiles(CouleurTuiles.VIDE);
		}
	}

	/**
	 * Creer un tableau de tableau mur
	 * 
	 * @return le mur
	 * 
	 * @see PlateauJoueur
	 * @see PlateauJoueur#mur
	 */

	private Tuiles[][] creeMur() {
		Tuiles[][] mur = new Tuiles[5][5];
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				mur[i][j] = new Tuiles(CouleurTuiles.VIDE);
			}
		}
		return mur;
	}

	/**
	 * Retourne lignesmotif
	 * 
	 * @return lignesmotif
	 * 
	 * @see PlateauJoueur#lignesMotif
	 * @see PlateauJoueur
	 * 
	 */

	public Tuiles[][] getLignesMotif() {
		return lignesMotif;
	}

	/**
	 * Retourne mur
	 * 
	 * @return mur
	 * 
	 * @see PlateauJoueur#mur
	 * @see PlateauJoueur
	 * 
	 */
	public Tuiles[][] getMur() {
		return mur;
	}

	/**
	 * Retourne murfini
	 * 
	 * @return murfini
	 * 
	 * @see PlateauJoueur#murFini
	 * @see PlateauJoueur
	 * 
	 */

	public Tuiles[][] getMurFini() {
		return murFini;
	}

	/**
	 * Retourne plancher
	 * 
	 * @return plancher
	 * 
	 * @see PlateauJoueur#plancher
	 * @see PlateauJoueur
	 * 
	 */
	public Tuiles[] getPlancher() {
		return plancher;
	}

	/**
	 * Retourne lignesMotif d'un Joueur </br>
	 * Sous forme de triangle
	 *
	 * @return lignesMotif
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#lignesMotif
	 */
	private Tuiles[][] creeLigneMotif() {
		Tuiles[][] t = new Tuiles[5][];
		for (int i = 0; i < t.length; i++) {
			t[i] = new Tuiles[i + 1];
		}
		return t;
	}

	/**
	 * Initialise lignesMotif d'un Joueur </br>
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#lignesMotif
	 */
	private void initialiserLigneMotif() {
		for (int i = 0; i < lignesMotif.length; i++) {
			for (int j = 0; j < lignesMotif[i].length; j++) {
				lignesMotif[i][j] = new Tuiles(CouleurTuiles.VIDE);
			}
		}
	}

	/**
	 * Creer le murFini d'un Joueur
	 *
	 * @return murFini
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#murFini
	 */
	private Tuiles[][] creeMurFini() {
		Tuiles[][] mur = new Tuiles[5][5];
		int compte = 0;
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				try {
					mur[i][j] = new Tuiles(CouleurTuiles.tuileByIndex(j - compte));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			compte++;
		}
		return mur;
	}

	/**
	 * Retourne lignesMotif d'un Joueur sous forme d'un String.</br>
	 * Sous forme de triangle sur la droite.</br>
	 * Pour l'afficher.
	 *
	 * @return lignesMotif sous forme de String
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#lignesMotif
	 */
	private String lignesMotifToString() {
		String res = "*Lignes Motif :\n";
		for (int i = 0; i < lignesMotif.length; i++) {
			for (int j = 0; j < 5 - 1 - i; j++) {
				res += " ";
			}
			for (int j = 0; j < lignesMotif[i].length; j++) {
				res += lignesMotif[i][j];
			}
			res += "\n";
		}
		return res;
	}

	/**
	 * Retourne plancher d'un Joueur sous forme d'un String</br>
	 * Pour l'afficher
	 *
	 * @return plancher sous forme de String
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 */
	private String plancherToString() {
		String res = "*Plancher : \n";
		for (int i = 0; i < plancher.length; i++) {
			res += plancher[i];
		}
		return res + "\n";
	}

	/**
	 * Retourne mur d'un Joueur sous forme d'un String</br>
	 * Pour l'afficher.
	 *
	 * @return mur sous forme de String
	 *
	 * @see PlateauJoueur#mur
	 * @see PlateauJoueur
	 */
	private String murToString() {
		String res = "*Mur : \n";
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				res += mur[i][j];
			}
			res += "\n";
		}
		return res;
	}

	/**
	 * Retourne toutes les information d'un PlateauJoueur
	 *
	 * @return toutes les information d'un PlateauJoueur
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#lignesMotif
	 * @see PlateauJoueur#mur
	 * @see PlateauJoueur#plancher
	 */
	@Override
	public String toString() {
		String res = "";
		res += lignesMotifToString() + "\n";
		res += murToString() + "\n";
		res += plancherToString() + "\n";
		return res;
	}

	/**
	 * Place des tuiles sur une ligne donnée par le Joueur. Et si le nombre de
	 * tuiles est supérieur à la taille disponible alors on le place sur le plancher
	 * 
	 * @param t
	 * @param ligne
	 * @param defausse
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 * @see PlateauJoueur#mur
	 *
	 */
	public void placerSurPlateau(Tuiles[] t, int ligne, Defausse defausse) {
		int compteur = 0;
		int attente = t.length;
		for (int i = 0; i < lignesMotif[ligne].length; i++) {
			if (lignesMotif[ligne][i].getCouleur() == CouleurTuiles.VIDE && compteur < t.length) {
				if (t[compteur].estIndependante()) {
					placerPlancher(t, compteur, compteur + 1, defausse);
					compteur++;
					attente--;
					i--;
				} else {
					lignesMotif[ligne][i] = t[compteur++];
					attente--;
				}
			}
		}
		if (attente != 0) {
			placerPlancher(t, compteur, attente, defausse);
		}
	}

	/**
	 * Place des tuiles sur le plancher
	 * 
	 * @param t
	 * @param compteur
	 * @param attente
	 * @param defausse
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 *
	 */
	public void placerPlancher(Tuiles[] t, int compteur, int attente, Defausse defausse) {
		int i = 0;
		while (attente != 0) {
			if (plancherEstPlein() && attente != 0) {
				defausse.placer(t[compteur++]);
				attente--;
			} else if (i < plancher.length && plancher[i].getCouleur() == CouleurTuiles.VIDE) {
				this.plancher[i] = t[compteur++];
				attente--;
			}
			i++;

		}
	}

	/**
	 * Vérifie que le plancher est plein
	 *
	 * @return true si le plancher est plein
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 *
	 */
	private boolean plancherEstPlein() {
		for (int i = 0; i < plancher.length; i++) {
			if (plancher[i].getCouleur() == CouleurTuiles.VIDE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie que la ligne demandée est libre
	 *
	 * @param ligne
	 *
	 * @return vrai si la ligne est libre
	 *
	 * @see PlateauJoueur
	 *
	 */
	public boolean ligneLibre(int ligne) {
		for (int i = 0; i < lignesMotif[ligne].length; i++) {
			if (lignesMotif[ligne][i].getCouleur() != CouleurTuiles.VIDE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie que la ligne existe
	 * 
	 * @param ligne
	 *
	 * @return vrai si la ligne existe
	 *
	 * @see PlateauJoueur
	 *
	 */
	public boolean ligneEstValide(int ligne) {
		return (ligne >= 0 && ligne <= 4);
	}

	/**
	 * Vérifie que la ligne est de même couleur que les tuiles
	 * 
	 * @param t
	 * @param ligne
	 *
	 * @return vrai si la couleur de la ligne est pareille que celle des tuiles
	 *
	 * @see PlateauJoueur
	 *
	 */
	public boolean estMemeCouleur(Tuiles[] t, int ligne) {
		if (!ligneEstFini(ligne)) {
			System.out.println(lignesMotif[ligne][0].getCouleur());
			System.out.println(t[0].getCouleur());
			return lignesMotif[ligne][0].getCouleur() == t[0].getCouleur()
					|| lignesMotif[ligne][0].getCouleur() == CouleurTuiles.VIDE;
		} else {
			return false;
		}
	}

	/**
	 * Vérifie que la tuile est de même couleur que les tuiles
	 * 
	 * @param tuiles
	 * @param ligne
	 *
	 * @return vrai si la couleur de la tuile est pareille que celle des tuiles
	 *
	 * @see PlateauJoueur
	 *
	 */

	public boolean estMemeCouleur(Tuiles tuiles, int ligne) {
		if (!ligneEstFini(ligne)) {
			return lignesMotif[ligne][0].getCouleur() == tuiles.getCouleur()
					|| lignesMotif[ligne][0].getCouleur() == CouleurTuiles.VIDE;
		} else {
			return false;
		}
	}

	/**
	 * Fini une ligne et place une tuile sur le mur. <br>
	 * Et calcul les points en fonction de la tuile posée.
	 *
	 * @return le score en fonction des tuiles posées;
	 *
	 * @see PlateauJoueur
	 *
	 */
	public int finirLigneEtScore() {
		int point = 0;
		for (int i = 0; i < lignesMotif.length; i++) {
			if (ligneEstFini(i)) {
				for (int j = 0; j < mur[i].length; j++) {
					if (murFini[i][j].getCouleur() == lignesMotif[i][0].getCouleur()) {
						mur[i][j] = lignesMotif[i][0];
						lignesMotif[i][0] = new Tuiles(CouleurTuiles.VIDE);
						point++;
						if (j - 1 >= 0 && mur[i][j - 1].getCouleur() != CouleurTuiles.VIDE) {
							point++;
						}
						if (i - 1 >= 0 && mur[i - 1][j].getCouleur() != CouleurTuiles.VIDE) {
							point++;
						}
						if (j + 1 < mur[i].length && mur[i][j + 1].getCouleur() != CouleurTuiles.VIDE) {
							point++;
						}
						if (i + 1 < mur.length && mur[i + 1][j].getCouleur() != CouleurTuiles.VIDE) {
							point++;
						}
						break;
					}
				}
			}
		}
		return point;
	}

	/**
	 * Libère toutes les zones ou l'on pose des tuiles
	 * 
	 * @param defausse
	 *
	 * @see PlateauJoueur
	 * @see Defausse
	 *
	 */
	public void liberer(Defausse defausse) {
		libererLigneMotif(defausse);
		libererPlancher(defausse);
	}

	/**
	 * Libère ligneMotif
	 * 
	 * @param defausse
	 *
	 * @see PlateauJoueur
	 * @see Defausse
	 *
	 */
	private void libererLigneMotif(Defausse defausse) {
		for (int i = 1; i < lignesMotif.length; i++) {
			if (lignesMotif[i][1].getCouleur() != CouleurTuiles.VIDE
					&& murCouleurFini(lignesMotif[i][1].getCouleur(), i)) {
				for (int j = 1; j < lignesMotif[i].length; j++) {
					defausse.placer(lignesMotif[i][j]);
					lignesMotif[i][j] = new Tuiles(CouleurTuiles.VIDE);
				}
			}
		}
	}

	/**
	 * Libère plancher
	 * 
	 * @param defausse
	 *
	 * @see PlateauJoueur
	 * @see Defausse
	 *
	 */
	private void libererPlancher(Defausse defausse) {
		for (int i = 0; i < plancher.length; i++) {
			if (plancher[i].getCouleur() != CouleurTuiles.VIDE && plancher[i].estIndependante()) {
				plancher[i] = new Tuiles(CouleurTuiles.VIDE);
			} else {
				defausse.placer(plancher[i]);
				plancher[i] = new Tuiles(CouleurTuiles.VIDE);
			}
		}
	}

	/**
	 * Vérifie que la ligne est fini
	 * 
	 * @param ligne
	 *
	 * @return vrai si la ligne est complète
	 *
	 * @see PlateauJoueur
	 *
	 */
	private boolean ligneEstFini(int ligne) {
		for (int i = 0; i < lignesMotif[ligne].length; i++) {
			if (lignesMotif[ligne][i].getCouleur() == CouleurTuiles.VIDE) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Vérifie qu'une ligne du mur est fini
	 *
	 * @return vrai si une ligne du mur est complète
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#murFini
	 *
	 */
	public boolean ligneMurFini() {
		int compte = 0;
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				if (mur[i][j].getCouleur() != CouleurTuiles.VIDE) {
					compte++;
				}
			}
			if (compte == 5) {
				return true;
			} else {
				compte = 0;
			}
		}
		return false;
	}

	/**
	 * Calcul les points en fonction des colonnes et des lignes complète
	 *
	 * @return les points supplémentaires
	 *
	 * @see PlateauJoueur
	 *
	 */
	public int pointParLignesEtColones() {
		int comptelignes = 0;
		int comptecolones = 0;
		int nbColonesFini = 0;
		int point = 0;
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				if (mur[i][j].getCouleur() != CouleurTuiles.VIDE) {
					comptelignes++;
				}
				if (mur[j][i].getCouleur() != CouleurTuiles.VIDE) {
					comptecolones++;
				}
			}
			if (comptelignes == 5) {
				point += 2;

			}
			if (comptecolones == 5) {
				nbColonesFini += 1;
			}
			comptelignes = 0;
			comptecolones = 0;
		}
		for (int j = 0; j < nbColonneTotal - nbColonesFini; j++) {
			point += 7;
		}
		return point;
	}

	/**
	 * Calcul les points en fonction des couleur complète
	 *
	 * @return les points supplémentaires
	 *
	 * @see PlateauJoueur
	 *
	 */
	public int pointParCouleur() {
		int[] compteCouleur = new int[5];
		int point = 0;
		for (int i = 0; i < mur.length; i++) {
			for (int j = 0; j < mur[i].length; j++) {
				switch (mur[i][j].getCouleur()) {
				case ROUGE:
					compteCouleur[0]++;
					break;
				case BLEU:
					compteCouleur[1]++;
					break;
				case NOIR:
					compteCouleur[2]++;
					break;
				case GRIS:
					compteCouleur[3]++;
					break;
				case JAUNE:
					compteCouleur[4]++;
					break;

				default:
					break;
				}
			}
			for (int j = 0; j < compteCouleur.length; j++) {
				if (compteCouleur[i] == 5) {
					point += 10;
				}
			}
		}
		return point;
	}

	/**
	 * Vide le plancher et calcule les points à retirer
	 *
	 * @return les points à retirer
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#plancher
	 *
	 */
	public int PlancherEtScore() {
		int point = 0;
		for (int i = 0; i < plancher.length; i++) {
			if (plancher[i].getCouleur() != CouleurTuiles.VIDE) {
				if (i <= 1) {
					point -= 1;
				}
				if (i >= 2 && i <= 4) {
					point -= 2;
				}
				if (i >= 5) {
					point -= 3;
				}
			}
		}
		return point;
	}

	/**
	 * Vérifie qu'une couleur est complétée sur une ligne du mur
	 * 
	 * @param c
	 * @param ligne
	 *
	 * @return vrai si la couleur est deja fini sur une ligne du mur
	 *
	 * @see PlateauJoueur
	 * @see PlateauJoueur#murFini
	 *
	 */
	public boolean murCouleurFini(CouleurTuiles c, int ligne) {
		for (int i = 0; i < mur[ligne].length; i++) {
			if (mur[ligne][i].getCouleur() == c) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vérifie si l'on possede la tuile independante
	 * 
	 * @return true si la personne a l'independante
	 *
	 *
	 * @see PlateauJoueur
	 *
	 */
	public boolean possedeIndependante() {
		for (int i = 0; i < plancher.length; i++) {
			if (plancher[i].getCouleur() != CouleurTuiles.VIDE
					&& plancher[i].getCouleur() == CouleurTuiles.INDEPENDANTE) {
				return true;
			}
		}
		return false;
	}

}
