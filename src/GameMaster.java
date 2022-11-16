public class GameMaster {
	
	boolean hasMinotaurWon = false;
	Player player = new Player();
	Minotaur minotaur = new Minotaur();
	GameDisplay maze = new GameDisplay();
	
	
	public boolean checkWinCondition() {
		return minotaur.hasReachedEnd();
	}
	
	public void updateFlavorText() {
		GameDisplay.someComponent.setText(minotaur.getMinotaurText());
	}
	
	
	
	
    // = = = = = TEST CLIENT = = = = = //
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
