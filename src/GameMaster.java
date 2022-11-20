import java.awt.*;

public class GameMaster {
	
	boolean hasMinotaurWon = false;
	Player player = new Player();
	Minotaur minotaur = new Minotaur();
	static GameDisplay gameDisplay;
	
	
	public boolean checkWinCondition() {
		return minotaur.hasReachedEnd();
	}
	
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
