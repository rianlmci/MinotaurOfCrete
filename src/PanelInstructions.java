import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 * Introduction and game instructions for the user.
 * 
 * @author Wyatt McCurdy
 */
public class PanelInstructions extends JPanel {
	private final Color BACKGROUND_COLOR = Color.decode("#181A1B");

	public PanelInstructions() {
		setBackground(BACKGROUND_COLOR);
		JLabel explanationLabel = new JLabel("<html>"
				+ "<h1>The Minotaur of Crete is a maze game based on a Greek Myth<h1/><br>"
				+ "You play Theseus, a guy who goes into a maze to fight a bull-man (Minotaur)<br>"
				+ "The Minotaur was scarier than you thought, so now you have to run!<br>" + "How the game works: <br>"
				+ "The Minotaur knows the best way to get to the exit, but starts one step behind you.<br>"
				+ "You must find the most efficient way to the end of the maze.<br>" + "<br>"
				+ "		1. Your starting position is marked in yellow.<br>"
				+ "		2. The end of the maze is marked in green.<br>"
				+ "		3. The maze is laid out in a grid, and there are connections between certain cells.<br>"
				+ "		4. If there is a connection between your tile and another tile, it will be highlighted in white.<br>"
				+ "		5. You can click on a highlighted tile to move there. The Minotaur will take its turn after you do.<br>"
				+ "		6. If you want to backtrack, you can press the 'Undo' button. This will cause the Minotaur to backtrack too.<br>"
				+ "		7. There are three difficulty settings below. Choose one.<br>" + "<br>"
				+ "Get to the end of the maze and save your bacon! Otherwise, you're toast." + "<html/>");
		explanationLabel.setForeground(new Color(255, 255, 255));
		add(explanationLabel);
	}
}
