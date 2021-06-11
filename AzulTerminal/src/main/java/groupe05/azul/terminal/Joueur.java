package groupe05.azul.terminal;

import java.awt.Frame;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <b>Joueur est la classe représentant le joueur qui joue</b>
 * <p>
 * Un Joueur est caractérisé par :
 * <ul>
 * <li>Un nom</li>
 * <li>Un age</li>
 * <li>Un PlateauJoueur</li>
 * <li>Un score</li>
 * <li>Un scanner (qui représente les valeur choisies par le joueur)</li>
 * </ul>
 * </p>
 *
 * @see PlateauJoueur
 *
 * @version 1.0
 */

public class Joueur {

	/**
	 * Le nom d'un Joueur. Le nom n'est pas modifiable.
	 *
	 * @see Joueur#Joueur()
	 * @see Joueur#getNom()
	 * @see Joueur#demanderNom()
	 * @see Joueur
	 */
	private final String nom;
	/**
	 * L'age d'un Joueur. L'age n'est pas modifiable.
	 *
	 * @see Joueur#Joueur()
	 * @see Joueur#getAge()
	 * @see Joueur#demanderAge()
	 * @see Joueur
	 */
	private final int age;
	/**
	 * Le plateau d'un Joueur.
	 *
	 * @see Joueur#Joueur()
	 * @see PlateauJoueur
	 *
	 */
	private PlateauJoueur plateau;
	/**
	 * Le score d'un Joueur.
	 *
	 * @see Joueur#getScore()
	 * @see Joueur#Joueur()
	 * @see Joueur
	 */
	private int score;
	/**
	 * Le réponse d'un Joueur.
	 *
	 * @see Joueur#Joueur()
	 * @see Joueur#demanderNom()
	 * @see Joueur#demanderAge()
	 * @see Joueur#finirScanner()
	 * @see Joueur
	 *
	 */
	private Scanner scanReponse;
	/**
	 * Si le Joueur commence
	 *
	 * @see Joueur#Joueur()
	 * @see Joueur#demanderNom()
	 * @see Joueur#demanderAge()
	 * @see Joueur#finirScanner()
	 * @See Joueur
	 *
	 */
	private boolean commence;

	/**
	 * Constructeur Joueur.
	 *
	 * @see Joueur#scanReponse
	 * @see Joueur#nom
	 * @see Joueur#age
	 * @see Joueur#plateau
	 * @see Joueur
	 */
	public Joueur() {
		scanReponse = new Scanner(System.in);
		nom = demanderNom();
		age = demanderAge();
		commence = false;
		plateau = new PlateauJoueur();
	}

	/**
	 * Constructeur de joueur avec un nom et un age
	 * 
	 * @param nom
	 * @param age
	 * 
	 * @see Joueur#scanReponse
	 * @see Joueur#nom
	 * @see Joueur#age
	 * @see Joueur#plateau
	 * @see Joueur
	 */

	public Joueur(String nom, int age) {
		this.nom = nom;
		this.age = age;
		commence = false;
		plateau = new PlateauJoueur();
	}

	/**
	 * Retourne le nom d'un Joueur
	 *
	 * @return le nom d'un Joueur
	 *
	 * @see Joueur
	 * @see Joueur#nom
	 * @see Joueur#demanderNom()
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Retourne le score d'un Joueur
	 *
	 * @return le score d'un Joueur
	 *
	 * @see Joueur
	 * @see Joueur#score
	 */

	public int getScore() {
		return score;
	}

	/**
	 * Retourne l'age d'un Joueur
	 *
	 * @return l'age d'un Joueur
	 *
	 * @see Joueur
	 * @see Joueur#age
	 * @see Joueur#demanderAge()
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Retourne vrai si le joueur commence
	 *
	 * @return vrai si le joueur commence
	 *
	 * @see Joueur
	 */
	public boolean getCommence() {
		return commence;
	}

	/**
	 * Retourne le plateau du joueur
	 * 
	 * @return le plateau du joueur
	 * @see Joueur
	 * @see Joueur#plateau
	 */

	public PlateauJoueur getPlaJoueur() {
		return plateau;
	}

	/**
	 * Met a jour si le joueur commence
	 * 
	 * @param commence
	 *
	 * @see Joueur
	 * @see Joueur#commence
	 */
	public void setCommence(boolean commence) {
		this.commence = commence;
	}

	/**
	 * Retourne toutes les informations d'un Joueur
	 *
	 * @return toutes les informations d'un Joueur
	 *
	 * @see Joueur
	 */
	@Override
	public String toString() {
		return "Nom du joueur : " + nom + "\n" + "Score : " + score + "\n" + "Plateau :\n" + plateau;
	}

	/**
	 * Demande le nom d'un Joueur
	 *
	 * @return le nom du Joueur
	 *
	 * @see Joueur
	 * @see Joueur#nom
	 * @see Joueur#getNom()
	 */
	private String demanderNom() {
		System.out.println("Entre ton nom : ");
		return scanReponse.next();
	}

	/**
	 * Demande l'age d'un Joueur
	 *
	 * @return l'age du Joueur
	 *
	 * @see Joueur
	 * @see Joueur#age
	 * @see Joueur#getAge()
	 */
	private int demanderAge() {
		System.out.print("Entre ton age :");
		int resAge;
		do {
			System.out.println("(8 ans ou plus)");
			while (!scanReponse.hasNextInt()) {
				String input = scanReponse.next();
				System.out.println("\"" + input + "\" n'est pas un chiffre \n");
			}
			resAge = scanReponse.nextInt();
		} while (resAge < 8);
		return resAge;
	}

	/**
	 * Ferme le scanner de reponse du joueur
	 *
	 * @see Joueur
	 * @see Joueur#scanReponse
	 */
	public void finirScanner() {
		this.scanReponse.close();
	}

	/**
	 * Demande au Joueur où il veut placer les Tuiles récupérées (sur le tableau
	 * ligne motif ou sur le plancher). </br>
	 * Tout en vérifiant que les valeurs données sont bonnes. </br>
	 * Et s'il y a trop de tuiles pour la place disponible alors ça les placera dans
	 * le plancher.
	 * 
	 * @param t
	 * @param defausse
	 *
	 * @see Joueur
	 * 
	 */
	public void demanderPlacerTuiles(Tuiles[] t, Defausse defausse) {
		int ligne = 0;
		System.out.print("Sur qu'elle ligne voulez-vous mettre vos Tuiles ");
		do {
			System.out.println(
					"(Seulement entre 1 & 5 et vide ou sur une ligne de la meme couleur et sur une ligne ou le mur) et 0 pour le plancher");
			while (!scanReponse.hasNextInt()) {
				String input = scanReponse.next();
				System.out.println("\"" + input + "\" n'est pas un chiffre \n");
			}
			ligne = scanReponse.nextInt() - 1;
			System.out.println();
		} while (!(ligne == -1 || plateau.ligneEstValide(ligne)));
		verificationEtPlacerTuiles(t, ligne, defausse);
	}

	/**
	 * Verifie que l'on peut placer la tuiles et la place sinon redemande ou la
	 * placer
	 * 
	 * @param t
	 * @param ligne
	 * @param defausse
	 *
	 * @see Joueur
	 */
	private void verificationEtPlacerTuiles(Tuiles[] t, int ligne, Defausse defausse) {
		if (ligne == -1) {
			plateau.placerPlancher(t, 0, t.length, defausse);
		} else if ((plateau.ligneLibre(ligne) || plateau.estMemeCouleur(t, ligne))
				&& !plateau.murCouleurFini(t[0].getCouleur(), ligne)) {
			plateau.placerSurPlateau(t, ligne, defausse);
		} else {
			System.out.println(
					"La ligne choisit n'est pas de la meme couleur ou est pleine ou la couleur du mur est deja fait");
			demanderPlacerTuiles(t, defausse);
		}
	}

	/**
	 * Mets le score du Joueur à la fin du tour et verifie si il commence.
	 * 
	 * @param defausse
	 *
	 * @see Joueur
	 * @see Joueur#score
	 */
	public void finDeTour(Defausse defausse) {
		commence = plateau.possedeIndependante();
		score += plateau.finirLigneEtScore();
		score += plateau.PlancherEtScore();
		score += plateau.pointParLignesEtColones();
		score += plateau.pointParCouleur();
		plateau.liberer(defausse);
	}

	/**
	 * verifie si une ligne du mur est fini
	 *
	 * @see Joueur
	 * @see Joueur#plateau
	 */
	public boolean ligneMurEstFini() {
		return plateau.ligneMurFini();
	}

	/**
	 * Demande au Joueur qu'elle fabrique prendre
	 * 
	 * @param toutesFabriques
	 * @param fabriques
	 *
	 * @see Joueur
	 * @see Fabrique
	 */
	public int demanderQuelleFabriquePrendre(int toutesFabriques, Fabrique[] fabriques) {
		try {
			System.out.print("Dans quelle fabrique tu veux prendre ?");
			int res;
			do {
				System.out.println("(entre 1 et " + toutesFabriques + " Et non vide)");
				while (!scanReponse.hasNextInt()) {
					String input = scanReponse.next();
					System.out.println("\"" + input + "\" n'est pas un chiffre \n");
				}
				res = scanReponse.nextInt() - 1;
			} while ((res < 0 || res > toutesFabriques - 1));
			if (res == -1 || !fabriques[res].estVide()) {
				return res;
			}
			return demanderQuelleFabriquePrendre(toutesFabriques, fabriques);
		} catch (NoSuchElementException elementException) {
			System.out.println("Aurevoir!");
			System.exit(0);
			return 0;
		}
	}

	/**
	 * Demande au Joueur qu'elle Tuile prendre
	 *
	 * @param tailleOuPiocher
	 *
	 * @see Joueur
	 * @see Tuiles
	 */
	public int positionTuile(int tailleOuPiocher) {
		try {
			System.out.print("Quelle tuiles tu veux prendre ?");
			int res;
			do {
				System.out.println("(Entre 1 et " + tailleOuPiocher + ")");
				while (!scanReponse.hasNextInt()) {
					String input = scanReponse.next();
					System.out.println("\"" + input + "\" n'est pas un chiffre \n");
				}
				res = scanReponse.nextInt() - 1;
			} while (res < 0 || res > tailleOuPiocher - 1);
			return res;
		} catch (NoSuchElementException elementException) {
			System.out.println("Aurevoir!");
			System.exit(0);
			return 0;
		}
	}

	/**
	 * Demande au Joueur ou il prend (fabrique ou centre de table)
	 * 
	 * @param t
	 *
	 * @see Joueur
	 * @see Fabrique
	 * @see CentreTable
	 */
	public boolean prendreDansFabrique(Tour t) throws Exception {
		try {
			System.out.print("Ou veux tu prendre Fabrique ou CentreTable");
			String res;
			do {
				System.out.println("(f ou c)");
				res = scanReponse.next();
			} while (!(res.equals("f") || res.equals("c")));
			if (res.equals("f") && t.fabriqueVide()) {
				System.out.println("Les fabriques sont vides");
				return prendreDansFabrique(t);
			}
			if (res.equals("c") && t.centreTableVide()) {
				System.out.println("Le centre de la tables est vide");
				return prendreDansFabrique(t);
			}
			return res.equals("f");
		} catch (NoSuchElementException elementException) {
			System.out.println("Aurevoir!");
			System.exit(0);
			return false;
		}
	}

}
