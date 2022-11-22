import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class in charge of all the GUI components of the minotaur game.
 */
public class GameDisplay extends JFrame {
	public GameMaster gm = new GameMaster();

	private MazeDifficulty mazeDifficulty = MazeDifficulty.EASY; //TODO: Initialize later with a screen

	//Display Containers
	protected static JPanel outerContainer = new JPanel(new BorderLayout());
	protected static CardLayout cardDeck = new CardLayout();
	protected static JPanel gameContent = new JPanel(cardDeck);

	public JLabel minotaurTextLabel = new JLabel(gm.minotaur.getMinotaurText());

	//Game Screens
	protected static PanelMenuItems panelMenuItems = new PanelMenuItems();
	private static PanelTitle panelTitle = new PanelTitle();
	private static PanelGameOverWin panelGameOverWin= new PanelGameOverWin();
	private static PanelGameOverLose panelGameOverLose= new PanelGameOverLose();
	private static PanelMaze panelMazeEasy = new PanelMaze(MazeDifficulty.EASY);
	//private static PanelMaze panelMazeMedium = new PanelMaze(MazeDifficulty.MEDIUM);
	//private static PanelMaze panelMazeHard = new PanelMaze(MazeDifficulty.HARD);

	public GameDisplay() {
		setSize(1000, 700);
		//setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//adds each card and their aliases to the game content panel
		gameContent.add(panelTitle, "Title");
		gameContent.add(panelMazeEasy, "Easy");
		gameContent.add(panelGameOverWin, "Win");
		gameContent.add(panelGameOverLose, "Lose");
		outerContainer.add(gameContent,BorderLayout.NORTH);
		minotaurTextLabel.setVisible(false);
		outerContainer.add(minotaurTextLabel, BorderLayout.CENTER);
		outerContainer.add(panelMenuItems, BorderLayout.SOUTH);
		setMenuButtonsLogic();
		add(outerContainer);
		panelMazeEasy.updateMasterGm();
		panelMazeEasy.updateMazeGUI();
		//panelMazeMedium.updateMasterGm();
		//panelMazeMedium.updateMazeGUI();
		//panelMazeHard.updateMasterGm();
		//panelMazeHard.updateMazeGUI();
		setVisible(true);
	}

	/**
	 * Creates logic for each of the menu buttons
	 */
	private void setMenuButtonsLogic() {
		//Start Button
		panelMenuItems.startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				panelMazeEasy.updateMazeGUI();
				cardDeck.show(gameContent, "Easy");
				minotaurTextLabel.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.resetButton.setVisible(true);
				panelMenuItems.undoButton.setVisible(true);

			}
		});

		//(Return to) Title Button
		panelMenuItems.titleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cardDeck.show(gameContent, "Title");
				panelMenuItems.startButton.setVisible(true);
				panelMenuItems.titleButton.setVisible(false);
			}
		});

		//Undo Button
		panelMenuItems.undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				//gm = panelMazeEasy.currentGM;

				if(!gm.player.nodesVisited.isEmpty()) {
					gm.player.moveBackward();
					gm.minotaur.move(gm.player.stepsTaken);
					updateMazeGm();
				}

				//TODO Remove text when bugs are fixed!
				System.out.println("TEMPORARY TESTING TEXT IN UNDO:");
				System.out.printf("Player steps: %f\n" +
								"Minotaur steps: %f\n" +
								"Minotaur path size: %d\n" +
								"Minotaur has reached end %b\n",
						gm.player.stepsTaken,
						gm.minotaur.stepsTaken,
						gm.minotaur.bestPath.length,
						gm.minotaur.hasReachedEnd());

				minotaurTextLabel.setText(gm.minotaur.getMinotaurText());

			}
		});
		panelMenuItems.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				while (gm.player.nodesVisited.size() > 1){
					gm.player.moveBackward();
				}
				gm.minotaur.move(gm.player.stepsTaken);
				minotaurTextLabel.setText(gm.minotaur.getMinotaurText());
				updateMazeGm();
			}
		});
	}

	private void updateMazeGm() {
		switch (mazeDifficulty) {
			case EASY:
				panelMazeEasy.currentGM = gm;
				panelMazeEasy.updateMazeGUI();
				break;
			case MEDIUM:
				//panelMazeMedium.currentGM = gm;
				//panelMazeMedium.updateMazeGUI();
				break;
			case HARD:
				//panelMazeHard.currentGM = gm;
				//panelMazeHard.updateMazeGUI();
				break;
			default:
				panelMazeEasy.currentGM = gm;
				panelMazeEasy.updateMazeGUI();
				break;
		}
	}
	// = = = = = TEST CLIENT = = = = = //
	public static void main(String[] args) {

	}
}

