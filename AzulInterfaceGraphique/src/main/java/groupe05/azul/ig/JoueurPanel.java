package groupe05.azul.ig;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import groupe05.azul.terminal.Joueur;

/**
 * <b>Class qui affiche un Joueur dans l'interface</b>
 * 
 * @see Joueur
 * 
 * @version 1.0
 * 
 */
public class JoueurPanel extends JPanel {
	/**
	 * Nom du joueur
	 *
	 * @see JoueurPanel
	 * @see JoueurPanel#JoueurPanel(Joueur)
	 */
	private JLabel nom;
	/**
	 * LigneMotif d'un Joueur pour l'interface
	 *
	 * @see JoueurPanel
	 * @see JoueurPanel#JoueurPanel(Joueur)
	 */
	private LigneMotifPanel ligneMotifPanel;
	/**
	 * Mur d'un Joueur pour l'interface
	 *
	 * @see JoueurPanel
	 * @see JoueurPanel#JoueurPanel(Joueur)
	 */
	private MurPanel murPanel;
	/**
	 * Plancher d'un Joueur pour l'interface
	 *
	 * @see JoueurPanel
	 * @see JoueurPanel#JoueurPanel(Joueur)
	 */
	private PlancherPanel plancherPanel;
	/**
	 * Score d'un Joueur
	 *
	 * @see JoueurPanel
	 * @see JoueurPanel#JoueurPanel(Joueur)
	 */
	private JLabel score;

	/**
	 * Constructeur JoueurPanel
	 * 
	 * @param joueur
	 *
	 * @see JoueurPanel
	 * 
	 */
	public JoueurPanel(Joueur joueur) {
		nom = new JLabel(joueur.getNom());
		nom.setHorizontalAlignment(SwingConstants.CENTER);

		ligneMotifPanel = new LigneMotifPanel(joueur);
		murPanel = new MurPanel(joueur);
		plancherPanel = new PlancherPanel(joueur);

		score = new JLabel("Score: " + Integer.toString(joueur.getScore()));
		score.setHorizontalAlignment(SwingConstants.CENTER);

		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.BOTH;
		c.insets = new Insets(3, 3, 3, 3);

		c.weightx = 1;
		c.weighty = 0.3;

		c.gridx = 0;

		c.gridy = 0;

		c.gridwidth = 2;

		add(nom, c);

		c.weightx = 1;
		c.weighty = 1;

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 1;
		add(ligneMotifPanel, c);

		c.gridx = 1;
		c.gridy = 1;
		add(murPanel, c);

		c.weighty = 0.3;
		c.gridx = 0;
		c.gridy = 2;

		add(plancherPanel, c);
		c.gridx = 1;
		c.gridy = 2;

		add(score, c);

	}

}
