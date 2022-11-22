import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class in charge of all the GUI components of the minotaur game.
 */
public class GameDisplay extends JFrame {
	public GameMaster gm = new GameMaster();

	//Display Containers
	private static JPanel outerContainer = new JPanel(new BorderLayout());
	private static CardLayout cardDeck = new CardLayout();
	private static JPanel gameContent = new JPanel(cardDeck);

	//Game Screens
	private static PanelMenuItems panelMenuItems = new PanelMenuItems();
	private static PanelTitle panelTitle = new PanelTitle();
	private static PanelGameOverWin panelGameOverWin= new PanelGameOverWin();
	private static PanelMaze panelMazeEasy = new PanelMaze(MazeDifficulty.EASY);
	//private static PanelMaze panelMazeMedium = new PanelMaze(MazeDifficulty.MEDIUM);
	//private static PanelMaze panelMazeHard = new PanelMaze(MazeDifficulty.HARD);

	public GameDisplay() {
		setSize(1000, 700);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//adds each card and their aliases to the game content panel
		gameContent.add(panelTitle, "Title");
		gameContent.add(panelMazeEasy, "Easy");
		gameContent.add(panelGameOverWin, "Win");
		outerContainer.add(panelMenuItems, BorderLayout.SOUTH);
		setMenuButtonsLogic();
		outerContainer.add(gameContent,SwingConstants.CENTER);
		add(outerContainer);
		panelMazeEasy.updateMasterGm();
		//panelMazeMedium.updateMasterGm();
		//panelMazeHard.updateMasterGm();
		setVisible(true);
	}

	/**
	 * Creates logic for each of the menu buttons
	 */
	private void setMenuButtonsLogic(){
		//Start Button
		panelMenuItems.startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardDeck.show(gameContent,"Easy");
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.resetButton.setVisible(true);
				panelMenuItems.undoButton.setVisible(true);

			}
		});

		//(Return to) Title Button
		panelMenuItems.titleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardDeck.show(gameContent,"Title");
				panelMenuItems.startButton.setVisible(true);
				panelMenuItems.titleButton.setVisible(false);
			}
		});
	}
	// = = = = = TEST CLIENT = = = = = //
	public static void main(String[] args) {

	}
}

