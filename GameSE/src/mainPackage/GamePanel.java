package mainPackage;

/**
 * Die Klasse GamePanel repräsentiert das Haupt-Panel des Spiels, auf dem die Grafik gezeichnet wird.
 */

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;
import static mainPackage.Game.GAME_HEIGHT;
import static mainPackage.Game.GAME_WIDTH;

public class GamePanel extends JPanel {
	
	private static final long serialVersionUID = 1L; // because we got this error!! The serializable class GamePanel does not declare a static final serialVersionUID field of type long
	
	private MouseInputs mouseInputs;
	private Game game;

	public GamePanel(Game game) {
		setLayout(null);  // Set layout manager to null for manual component positioning.

		mouseInputs = new MouseInputs(this);  // Initialize mouse input handling.

		this.game = game;  // Reference to the game object.

		setPanelSize();  // Set the size of the panel.

		// Add listeners for keyboard and mouse events using respective input handling classes.
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);

	}

	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
	}

	public void updateGame() {

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);
		
		
		//WORKING ON... 04.02.2024.
		/*Display level/score information
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Level: " + game.getPlaying().getLevelManager().getLevelIndex() + 1, 10, 20);
        g.drawString("Score: " + game.getPlaying().getPlayer().getScore(), 10, 40);*/
	}

	public Game getGame() {
		return game;
	}
	


}