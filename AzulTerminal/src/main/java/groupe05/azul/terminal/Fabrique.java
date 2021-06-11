package groupe05.azul.terminal;

import java.util.ArrayList;

/**
 * <b>Fabrique est la class représentant la fabrique ou piochent les joueurs</b>
 * <p>
 * Une Fabrique est caractérisée par 4 tuiles
 * </p>
 *
 * @see Jeu
 * @see ZonesCommunes
 * @see Sac
 * @see Tuiles
 *
 * @version 1.0
 */
public class Fabrique extends ZonesCommunes {

	/**
	 * 4 tuiles piochables par un joueur
	 *
	 * @see Fabrique
	 * @see Fabrique#Fabrique()
	 * @see Fabrique#getTuiles()
	 *
	 */
	private Tuiles[] tuilesDeFabrique;

	/**
	 * Constructeur Fabrique.
	 * 
	 * @see Fabrique
	 * @see Fabrique#tuilesDeFabrique
	 */
	public Fabrique() {
		super();
		initialiser();
	}

	/**
	 * Retourne les 4 Tuiles
	 * 
	 * @return Les 4 tuiles
	 * 
	 * @see Fabrique
	 * @see Fabrique#tuilesDeFabrique
	 */
	public Tuiles[] getTuiles() {
		return tuilesDeFabrique;
	}

	/**
	 * Retourne 4
	 * 
	 * @return taille de la fabrique
	 * @see Fabrique#tuilesDeFabrique
	 * @see Fabrique
	 */
	public int getTaille() {
		return tuilesDeFabrique.length;
	}

	/**
	 * Initialise la Fabrique
	 * 
	 * @see Fabrique
	 * @see Tuiles
	 * @see Fabrique#tuilesDeFabrique
	 */
	@Override
	public void initialiser() {
		tuilesDeFabrique = new Tuiles[4];
	}

	/**
	 * Ajoute une tuiles a la fabrique
	 * 
	 * @param tuilesAAjouter
	 * 
	 * @see Fabrique
	 * @see Tuiles
	 * @see Fabrique#tuilesDeFabrique
	 */
	@Override
	public void ajouter(Tuiles[] tuilesAAjouter) {
		for (int i = 0; i < tuilesDeFabrique.length; i++) {
			tuilesDeFabrique[i] = tuilesAAjouter[i];
		}
	}

	/**
	 * Ajoute 4 tuiles aleatoires à la fabrique
	 * 
	 * @param sac
	 * @param defausse
	 * 
	 * @see Sac
	 * @see Defausse
	 * @see Tuiles
	 * @see Fabrique
	 */
	public void ajouterTouteTuiles(Sac sac, Defausse defausse) {
		Tuiles[] tuilesPiocher = new Tuiles[4];
		for (int i = 0; i < tuilesPiocher.length; i++) {
			tuilesPiocher[i] = sac.piocherRandom(defausse);
		}
		ajouter(tuilesPiocher);
	}

	/**
	 * Prends les tuiles de même couleur piocheées par le joueur et place le reste
	 * dans le centre de la table
	 * 
	 * @param positionDeLaTuile
	 * @param centreTable
	 * 
	 * @see Fabrique
	 * @see CentreTable
	 */
	public Tuiles[] recupTuiles(int positionDeLaTuile, CentreTable centreTable) {
		ArrayList<Tuiles> pourJoueur = new ArrayList<Tuiles>();
		ArrayList<Tuiles> pourTable = new ArrayList<Tuiles>();
		CouleurTuiles couleurPiocher = tuilesDeFabrique[positionDeLaTuile].getCouleur();
		for (int i = 0; i < tuilesDeFabrique.length; i++) {
			if (tuilesDeFabrique[i].getCouleur() == couleurPiocher) {
				pourJoueur.add(tuilesDeFabrique[i]);
			} else {
				pourTable.add(tuilesDeFabrique[i]);
			}
			tuilesDeFabrique[i] = new Tuiles(CouleurTuiles.VIDE);
		}
		Tuiles[] table = pourTable.toArray(new Tuiles[pourTable.size()]);
		centreTable.ajouter(table);
		Tuiles[] joueur = pourJoueur.toArray(new Tuiles[pourJoueur.size()]);
		return joueur;
	}

	public ArrayList<Tuiles> recupTuiles(Tuiles tuile, CentreTable centreTable) {
		ArrayList<Tuiles> pourJoueur = new ArrayList<Tuiles>();
		ArrayList<Tuiles> pourTable = new ArrayList<Tuiles>();
		CouleurTuiles couleurPiocher = tuile.getCouleur();
		for (int i = 0; i < tuilesDeFabrique.length; i++) {
			if (tuilesDeFabrique[i].getCouleur() == couleurPiocher) {
				pourJoueur.add(tuilesDeFabrique[i]);
			} else {
				if (tuilesDeFabrique[i].getCouleur() != CouleurTuiles.VIDE) {
					pourTable.add(tuilesDeFabrique[i]);
				}
			}
			tuilesDeFabrique[i] = new Tuiles(CouleurTuiles.VIDE);
		}
		centreTable.ajouter(pourTable.toArray(new Tuiles[pourTable.size()]));

		return pourJoueur;
	}

	/**
	 * Retourne le tableau de tuiles du centre de la table
	 * 
	 * @return le tableau de tuiles du centre de la table
	 * 
	 * @see Fabrique
	 * @see CentreTable
	 */
	@Override
	public Tuiles[] getTableauDeTuiles() {
		return tuilesDeFabrique;
	}

	/**
	 * Retourne le tableau de tuile de la fabrique
	 * 
	 * @return le tableau de tuile de la fabrique
	 * 
	 * @see CentreTable
	 */
	public ArrayList<Tuiles> getTuilesCouleur(CouleurTuiles couleurPiocher) {
		ArrayList<Tuiles> pourJoueur = new ArrayList<Tuiles>();
		for (int i = 0; i < tuilesDeFabrique.length; i++) {
			if (tuilesDeFabrique[i].getCouleur() == couleurPiocher) {
				pourJoueur.add(tuilesDeFabrique[i]);
			}
		}
		return pourJoueur;

	}

}
