package groupe05.azul.ig;

import javax.swing.JFrame;

/**
 * <b>Class qui contient la fenêtre </b>
 * 
 * @see Contenu
 * 
 * @version 1.0
 * 
 */
public class Fenetre extends JFrame {

	/**
	 * Contenu de la fenêtre
	 *
	 * @see Contenu
	 * @see Fenetre#Fenetre()
	 */
	private Contenu contenu = new Contenu(this);

	/**
	 * Constructeur Contenu
	 * 
	 * @see Contenu
	 * 
	 */
	public Fenetre() {
		setTitle("Azul");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);

		contenu.pageDeLancement();

		add(contenu);

		pack();

	}

}