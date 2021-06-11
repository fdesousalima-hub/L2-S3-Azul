package groupe05.azul.terminal;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * <b>Jeu est la class qui permet de lancer le jeu</b>
 *
 * @see Tuiles
 * @see Sac
 * @see CouleurTuiles
 * @see Joueur
 * @see PlateauJoueur
 * @see Defausse
 *
 * @version 1.0
 */

public class Jeu {
	/**
	 * Scanner qui demande combien il y aura de joueur
	 *
	 */
	public Scanner sc;
	/**
	 * Sac de la partie qui contient des tuiles
	 *
	 * @see Sac
	 */
	public Sac sac;

	/**
	 * Defausse de la partie
	 *
	 * @see Defausse
	 */
	public Defausse defausse;
	/**
	 * Tous les joueur
	 *
	 * @see Joueur
	 */
	public Joueur[] tousLesJoueur;

	/**
	 * Constructeur de jeu
	 *
	 * @see Jeu
	 */

	public Jeu() {
		sc = new Scanner(System.in);
		sac = new Sac();
		defausse = new Defausse();
	}

	/**
	 * Permet de lancer le jeu
	 *
	 * @throws Exception
	 *
	 *
	 * @see Jeu
	 */
	public void start() throws Exception {
		do {
			combienJoueur();
			while (!fin()) {
				Tour t = new Tour(this);
				t.commencerTour();
			}
			for (int i = 0; i < tousLesJoueur.length; i++) {
				System.out.println(tousLesJoueur[i]);
			}
			System.out.println(joueurGagne().getNom()+" gagne la partie!!\n");
		} while (vouloirJouer());
		closeToutlesScanner();
	}

	/**
	 * Permet de fermer tout les scanner
	 *
	 *
	 * @see Jeu
	 */
	private void closeToutlesScanner() {
		for (int i = 0; i < tousLesJoueur.length; i++) {
			tousLesJoueur[i].finirScanner();
		}
		sc.close();
	}

	/**
	 * verifie que personne n'a fini
	 *
	 * @return Vrai si quelqu'un a fini
	 *
	 * @see Jeu
	 * @see Jeu#start()
	 */
	protected boolean fin() {
		for (int i = 0; i < tousLesJoueur.length; i++) {
			if (tousLesJoueur[i].ligneMurEstFini()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Demande si l'on veut encore jouer
	 *
	 * @return Vrai si veut a nouveau jouer
	 *
	 * @see Jeu
	 */
	private boolean vouloirJouer() {
		String input;
		System.out.print("Voulez-vous continuer a Jouer?");
		do {
			System.out.println("(o ou n)");
			input = "" + sc.next();
		} while (!(input.equals("o") || input.equals("n")));
		return (input.equals("o"));
	}

	/**
	 * Demande combien il y a de joueur
	 *
	 *
	 * @see Jeu
	 * @see Joueur
	 */
	private void combienJoueur() {
		try {
		int input;
		System.out.print("Vous-ètes combien?");
		do {
			System.out.println("(entre 2 et 4)");
			while (!sc.hasNextInt()) {
				System.out.println("\"" + sc.next() + "\" n'est pas un chiffre \n");
			}
			input = sc.nextInt();
		} while (input < 2 || input > 4);
		tousLesJoueur = new Joueur[input];
		creeJoueur();
		}catch (NoSuchElementException elementException) {
			System.out.println("Aurevoir!");
			System.exit(0);
		}
	}

	/**
	 * cree le nombre de joueur demander
	 *
	 *
	 * @see Jeu
	 * @see Joueur
	 */
	private void creeJoueur() {
		for (int i = 0; i < tousLesJoueur.length; i++) {
			System.out.println("Joueur numero: " + (i + 1));
			tousLesJoueur[i] = new Joueur();
		}
	}

	/**
	 * Renvoie le gagnant
	 *
	 * @return le joueur qui a gagne
	 * @see Jeu
	 * @see Joueur
	 */
	protected Joueur joueurGagne() {
		Joueur gagnant = tousLesJoueur[0];
		for (int i = 1; i < tousLesJoueur.length; i++) {
			if (tousLesJoueur[i].getScore() > gagnant.getScore()) {
				gagnant = tousLesJoueur[i];
			}
		}
		return gagnant;
	}

}
