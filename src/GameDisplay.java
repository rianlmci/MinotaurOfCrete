import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class in charge of all the GUI components of the minotaur game.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class GameDisplay extends JFrame {
	private MazeDifficulty mazeDifficulty = MazeDifficulty.EASY; // TODO: Initialize later with a screen

	// Display Containers
	protected static JPanel outerContainer = new JPanel(new BorderLayout());
	protected static CardLayout cardDeck = new CardLayout();
	protected static JPanel gameContent = new JPanel(cardDeck);
	protected static JLabel minotaurTextLabel = new JLabel();

	// Game Screens
	protected static PanelMenuItems panelMenuItems = new PanelMenuItems();
	private static PanelTitle panelTitle = new PanelTitle();
	private static PanelGameOverWin panelGameOverWin = new PanelGameOverWin();
	private static PanelGameOverLose panelGameOverLose = new PanelGameOverLose();
	private static PanelMaze panelMazeEasy = new PanelMaze(MazeDifficulty.EASY);
	private static PanelMaze panelMazeMedium = new PanelMaze(MazeDifficulty.MEDIUM);
	private static PanelMaze panelMazeHard = new PanelMaze(MazeDifficulty.HARD);

	public GameDisplay() {
		setSize(1000, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panelMazeEasy.gm.minotaur.setBestPath(MazeDifficulty.EASY);
		panelMazeMedium.gm.minotaur.setBestPath(MazeDifficulty.EASY); //TODO Change after maze is created
		panelMazeHard.gm.minotaur.setBestPath(MazeDifficulty.EASY); //TODO Change after maze is created

		// adds each card and their aliases to the game content panel
		gameContent.add(panelTitle, "Title");
		gameContent.add(panelMazeEasy, "Easy");
		gameContent.add(panelMazeMedium, "Medium");
		gameContent.add(panelMazeHard, "Hard");
		gameContent.add(panelGameOverWin, "Win");
		gameContent.add(panelGameOverLose, "Lose");
		outerContainer.add(gameContent, BorderLayout.NORTH);
		minotaurTextLabel.setVisible(false);
		outerContainer.add(minotaurTextLabel, BorderLayout.CENTER);
		outerContainer.add(panelMenuItems, BorderLayout.SOUTH);
		setMenuButtonsLogic();
		add(outerContainer);
		panelMazeEasy.updateMazeGUI();
		panelMazeMedium.updateMazeGUI();
		panelMazeHard.updateMazeGUI();
		setVisible(true);
	}

	/**
	 * Creates logic for each of the menu buttons
	 */
	private void setMenuButtonsLogic() {
		// Start Button
		panelMenuItems.startButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				updateCurrentMaze();
				cardDeck.show(gameContent, "Easy");
				minotaurTextLabel.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.resetButton.setVisible(true);
				panelMenuItems.undoButton.setVisible(true);
			}
		});

		// (Return to) Title Button
		panelMenuItems.titleButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				resetCurrentPlayer();
				updateCurrentMaze();
				cardDeck.show(gameContent, "Title");
				panelMenuItems.startButton.setVisible(true);
				panelMenuItems.titleButton.setVisible(false);
			}
		});

		// Undo Button
		panelMenuItems.undoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					switch (mazeDifficulty) {
						case EASY:
							if (!panelMazeEasy.gm.player.nodesVisited.isEmpty()){
								panelMazeEasy.gm.player.moveBackward();
								panelMazeEasy.gm.minotaur.move(panelMazeEasy.gm.player.stepsTaken);
							}
							break;
						case MEDIUM:
							if (!panelMazeMedium.gm.player.nodesVisited.isEmpty()) {
								panelMazeMedium.gm.player.moveBackward();
								panelMazeMedium.gm.minotaur.move(panelMazeMedium.gm.player.stepsTaken);
							}
							break;
						case HARD:
							if (!panelMazeHard.gm.player.nodesVisited.isEmpty()) {
							panelMazeHard.gm.player.moveBackward();
							panelMazeHard.gm.minotaur.move(panelMazeHard.gm.player.stepsTaken);
					}
				}
				updateCurrentMaze();
			}
		});
		panelMenuItems.resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				resetCurrentPlayer();
				updateCurrentMaze();
			}
		});
	}

	private void updateCurrentMaze() {
		switch (mazeDifficulty) {
		case EASY:
			panelMazeEasy.updateMazeGUI();
			break;
		case MEDIUM:
			panelMazeMedium.updateMazeGUI();
			break;
		case HARD:
			panelMazeHard.updateMazeGUI();
			break;
		}
	}

	/**
	 * Reset current player and minotaur position and steps taken
	 */
	private void resetCurrentPlayer() {
		switch (mazeDifficulty) {
			case EASY:
				while (panelMazeEasy.gm.player.nodesVisited.size() > 1) {
					panelMazeEasy.gm.player.moveBackward();
				}
				panelMazeEasy.gm.minotaur.move(panelMazeEasy.gm.player.stepsTaken);
				panelMazeEasy.updateMazeGUI();
				break;
			case MEDIUM:
				while (panelMazeMedium.gm.player.nodesVisited.size() > 1) {
					panelMazeMedium.gm.player.moveBackward();
				}
				panelMazeMedium.gm.minotaur.move(panelMazeMedium.gm.player.stepsTaken);
				panelMazeMedium.updateMazeGUI();
				break;
			case HARD:
				while (panelMazeHard.gm.player.nodesVisited.size() > 1) {
					panelMazeHard.gm.player.moveBackward();
				}
				panelMazeHard.gm.minotaur.move(panelMazeHard.gm.player.stepsTaken);
				panelMazeHard.updateMazeGUI();
				break;
		}
	}

	// = = = = = TEST CLIENT = = = = = //
	public static void main(String[] args) {

	}
}
