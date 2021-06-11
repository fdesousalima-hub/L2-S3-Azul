package groupe05.azul.ig;

import java.awt.EventQueue;

/**
 * <b>Class Main</b>
 * 
 * @see Partie
 * 
 * @version 1.0
 * 
 */
public class App {

	/**
	 * Lance le jeu en version interface Graphique
	 * 
	 * @see Partie
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			Fenetre f = new Fenetre();
			f.setVisible(true);
		});
	}
}
