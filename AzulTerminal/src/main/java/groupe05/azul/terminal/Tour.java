package groupe05.azul.terminal;

/**
 * <b>Tour est la classe représentant un tour dans une parti</b>
 *
 * @see Jeu
 *
 * @version 1.0
 */
public class Tour {

	/**
	 * Nombre de tour
	 *
	 *
	 */
	protected static int nbTour = 1;

	/**
	 * Nouveau jeu
	 *
	 * @see Jeu
	 */
	public Jeu jeu = new Jeu();

	/**
	 * Toute les fabrique
	 *
	 * @see Fabrique
	 */
	public Fabrique[] fabriques;

	/**
	 * Centre de table de la partie qui contient des tuiles non utilisé
	 *
	 * @see CentreTable
	 */
	public CentreTable centreTable;

	/**
	 * Consttructeur de Tour
	 *
	 * @param jeu
	 * @see Tour
	 */
	public Tour(Jeu jeu) {
		this.jeu = jeu;
	}

	/**
	 * Permet de commencer un tour
	 *
	 * @throws Exception
	 *
	 *
	 * @see Tour
	 */
	public void commencerTour() throws Exception {
		System.out.println("Tour numero: " + nbTour);
		int first = phasePreparation();
		phaseDePioche(first);
		phaseDecoration();
		afficherJoueurs();
		nbTour++;
	}

	/**
	 * Affiche tout les joueur
	 *
	 * @see Joueur
	 * @see Tour
	 */
	protected void afficherJoueurs() {
		for (int i = 0; i < jeu.tousLesJoueur.length; i++) {
			System.out.println(jeu.tousLesJoueur[i]);
		}

	}

	/**
	 * Prepare un tour
	 *
	 * @return le 1er a jouer
	 *
	 * @see Tour
	 * @see Joueur
	 */
	protected int phasePreparation() {
		int numeroPremierAJouer = 0;
		combienFabrique();
		centreTable = new CentreTable();
		initialiserToutesLesFabrique();
		if (nbTour == 1) {
			numeroPremierAJouer = plusPetitCommence();
		} else {
			for (int i = 0; i < jeu.tousLesJoueur.length; i++) {
				if (jeu.tousLesJoueur[i].getCommence()) {
					numeroPremierAJouer = i;
				}
			}
		}
		return numeroPremierAJouer;
	}

	/**
	 * Phase de pioche ou les joueurs piochent 1 par 1
	 *
	 * @param numeroPremierAJouer
	 *
	 * @throws Exception
	 *
	 * @see Tour
	 * @see Tour#centreTable
	 * @see Tour#fabriques
	 */
	protected void phaseDePioche(int numeroPremierAJouer) throws Exception {
		do {
			for (int i = 0; i < jeu.tousLesJoueur.length; i++) {
				afficherTout();
				int j = (i + numeroPremierAJouer) % jeu.tousLesJoueur.length;
				System.out.println(jeu.tousLesJoueur[j].getNom() + " joue.");
				if (jeu.tousLesJoueur[j].prendreDansFabrique(this)) {
					int numeroFabrique = jeu.tousLesJoueur[j].demanderQuelleFabriquePrendre(fabriques.length,
							fabriques);
					int positionTuiles = jeu.tousLesJoueur[j].positionTuile(fabriques[numeroFabrique].getTaille());
					System.out.println(jeu.tousLesJoueur[j]);
					jeu.tousLesJoueur[j].demanderPlacerTuiles(
							fabriques[numeroFabrique].recupTuiles(positionTuiles, centreTable), jeu.defausse);
				} else {
					int positionTuiles = jeu.tousLesJoueur[j].positionTuile(centreTable.getTaille());
					System.out.println(jeu.tousLesJoueur[j]);
					jeu.tousLesJoueur[j].demanderPlacerTuiles(centreTable.recupTuiles(positionTuiles), jeu.defausse);
				}
				if (touteZonesCommunesVide())
					break;
			}
		} while (!touteZonesCommunesVide());
	}

	/**
	 * Phase de decoration ou l'on calcul les point
	 *
	 *
	 * @see Tour
	 */
	protected void phaseDecoration() {
		for (int i = 0; i < jeu.tousLesJoueur.length; i++) {
			System.out.println("Joueur :" + jeu.tousLesJoueur[i].getNom());
			jeu.tousLesJoueur[i].finDeTour(jeu.defausse);
		}
	}

	/**
	 * Affiche tout les informations pour les joueurs
	 *
	 *
	 * @see Tour
	 * @see Tour#centreTable
	 * @see Tour#fabriques
	 */
	protected void afficherTout() {
		afficherFabrique();
		afficherCentreTable();
	}

	/**
	 * Affiche le centre de la table
	 *
	 *
	 * @see Tour
	 * @see Tour#centreTable
	 */
	protected void afficherCentreTable() {
		System.out.println("Centre de la table:\n" + centreTable);
	}

	/**
	 * Affiche les fabriques
	 *
	 *
	 * @see Tour
	 * @see Tour#fabriques
	 */
	protected void afficherFabrique() {
		System.out.println("Fabrique :");
		for (int i = 0; i < fabriques.length; i++) {
			System.out.println((i + 1) + ": " + fabriques[i]);
		}
	}

	/**
	 * verifie si toute les zones sont vides
	 *
	 * @see Tour
	 * @see Tour#centreTable
	 * @see Tour#fabriques
	 */
	protected boolean touteZonesCommunesVide() {
		return fabriqueVide() && centreTableVide();
	}

	/**
	 * verifie si toute les fabrique sont vides
	 *
	 * @see Tour
	 * @see Tour#fabriques
	 */
	public boolean fabriqueVide() {
		for (int i = 0; i < fabriques.length; i++) {
			if (!fabriques[i].estVide()) {
				return false;
			}
		}
		return true;
	}

	/**
	 * verifie si le centre de la table est vide
	 *
	 * @see Tour
	 * @see Tour#centreTable
	 */
	public boolean centreTableVide() {
		return centreTable.estVide();
	}

	/**
	 * Initialise les fabrique
	 *
	 * @see Tour
	 * @see Tour#fabriques
	 */
	private void initialiserToutesLesFabrique() {
		for (int i = 0; i < fabriques.length; i++) {
			fabriques[i].ajouterTouteTuiles(jeu.sac, jeu.defausse);
		}
	}

	/**
	 * combien de fabrique faut il cree
	 *
	 * @see Tour
	 * @see Tour#fabriques
	 */
	private void combienFabrique() {
		int nbFabrique = 0;
		switch (jeu.tousLesJoueur.length) {
		case 2:
			nbFabrique = 5;
			break;
		case 3:
			nbFabrique = 7;
			break;
		case 4:
			nbFabrique = 9;
			break;
		}
		fabriques = new Fabrique[nbFabrique];
		creeFabrique();
	}

	/**
	 * Cree toute les fabriques
	 *
	 * @see Tour
	 * @see Tour#fabriques
	 * @see Fabrique
	 */
	private void creeFabrique() {
		for (int j = 0; j < fabriques.length; j++) {
			fabriques[j] = new Fabrique();
		}
	}

	/**
	 * donne qu'elle joueur commence
	 *
	 * @see Tour
	 * @see Tour#commencerTour()
	 */
	private int plusPetitCommence() {
		int min = 0;
		for (int i = 1; i < jeu.tousLesJoueur.length; i++) {
			if (jeu.tousLesJoueur[i].getAge() < jeu.tousLesJoueur[min].getAge()) {
				min = i;
			}
		}
		return min;
	}

}
