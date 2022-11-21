import java.awt.*;

/**
 * A game master which understands the rules and gives feedback about the game's pieces.
 */
public class GameMaster {
	
	//boolean hasMinotaurWon = false;

	Player player = new Player();
	Minotaur minotaur = new Minotaur();
	static GameDisplay gameDisplay;

	/**
	 * @return if the minotaur has reached the end of the maze.
	 * if he reaches the end, the player loses the game.
	 */
	public boolean checkWinCondition() {
		return minotaur.hasReachedEnd();
	}

	/**
	 * Updates the flavor text on the game display for the minotaur
	 * TODO :Determine if this should go into the game display class or minotaur class
	 */
	public void updateFlavorText() {
		//GameDisplay.someComponent.setText(minotaur.getMinotaurText()); //TODO
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
