import java.awt.*;

/**
 * A game master which understands the rules and gives feedback about the game's pieces.
 */
public class GameMaster {
	Player player = new Player();
	Minotaur minotaur = new Minotaur();
	static GameDisplay gameDisplay;

	/**
	 * @return if the minotaur has reached the end of the maze.
	 * if he reaches the end, the player loses the game.
	 */
	public boolean checkLoseCondition() {
		return minotaur.hasReachedEnd();
	}

    // = = = = = TEST CLIENT = = = = = //
    public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gameDisplay = new GameDisplay();
					gameDisplay.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
    }
}
