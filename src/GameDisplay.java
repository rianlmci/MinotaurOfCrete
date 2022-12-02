import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Class in charge of all the GUI components of the minotaur game.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class GameDisplay extends JFrame {
	protected static MazeDifficulty mazeDifficulty = MazeDifficulty.EASY; // TODO: Initialize later with a screen

	// Display Containers
	protected static JPanel outerContainer = new JPanel();

	protected static CardLayout cardDeck = new CardLayout();
	protected static JPanel gameContent = new JPanel(cardDeck);
	protected static JLabel minotaurTextLabel = new JLabel();

	// Game Screens
	protected static PanelMenuItems panelMenuItems = new PanelMenuItems();
	private PanelTitle panelTitle = new PanelTitle();
	private PanelInstructions panelInstructions = new PanelInstructions();
	private PanelDifficulty panelDifficulty = new PanelDifficulty(); 
	private PanelGameOverWin panelGameOverWin = new PanelGameOverWin();
	private PanelGameOverLose panelGameOverLose = new PanelGameOverLose();
	private PanelMaze panelMazeEasy = new PanelMaze(MazeDifficulty.EASY);
	private PanelMaze panelMazeMedium = new PanelMaze(MazeDifficulty.MEDIUM); //TODO Change when mazes are made
	private PanelMaze panelMazeHard = new PanelMaze(MazeDifficulty.HARD); //TODO Change when mazes are made
	private JScrollPane scrollableArea = new JScrollPane(outerContainer); //makes whole game scrollable when resized

	// Look and feel of GameDisplay
	private final Color FONT_COLOR = Color.WHITE;
	private final Color BACKGROUND_COLOR = Color.decode("#181A1B"); //hex code decoder, a charcoal color.
	
	public GameDisplay() {
		setTitle("The Minotaur of Crete");
		setSize(1500, 1000);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		outerContainer.setLayout(new BoxLayout(outerContainer, BoxLayout.Y_AXIS));
		outerContainer.setBackground(BACKGROUND_COLOR);
		outerContainer.setForeground(FONT_COLOR);
		// adds each card and their aliases to the game content panel
		gameContent.add(panelTitle, "Title");
		gameContent.add(panelInstructions, "Instructions");
		gameContent.add(panelDifficulty, "Difficulty");
		gameContent.add(panelMazeEasy, "Easy");
		gameContent.add(panelMazeMedium, "Medium");
		gameContent.add(panelMazeHard, "Hard");
		gameContent.add(panelGameOverWin, "Win");
		gameContent.add(panelGameOverLose, "Lose");
		outerContainer.add(gameContent);
		
		//Look and feel of minotaur label:
		minotaurTextLabel.setVisible(false);
		minotaurTextLabel.setAlignmentX(Component.CENTER_ALIGNMENT); //centers the label horizontally
		minotaurTextLabel.setBorder(new EmptyBorder(20,0,20,0)); //Pseudo padding for label
		FontGetter fontGetter = new FontGetter();
		Font minotaurFont = fontGetter.getFontByName("VCR_OSD_MONO_1.001.ttf");
		minotaurFont = minotaurFont.deriveFont(Font.ITALIC,30);
		minotaurTextLabel.setFont(minotaurFont);
		minotaurTextLabel.setForeground(FONT_COLOR);

		outerContainer.add(minotaurTextLabel);
		outerContainer.add(panelMenuItems);
		setMenuButtonsLogic();
		add(scrollableArea);
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
				cardDeck.show(gameContent, "Instructions");
				panelMenuItems.easyButton.setVisible(true);
				panelMenuItems.mediumButton.setVisible(true);
				panelMenuItems.hardButton.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
//				cardDeck.show(gameContent, "Difficulty");
			}
		});
		
		// Easy button
		panelMenuItems.easyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateCurrentMaze();
				cardDeck.show(gameContent, "Easy");
				mazeDifficulty = MazeDifficulty.EASY;
				minotaurTextLabel.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.easyButton.setVisible(false);
				panelMenuItems.mediumButton.setVisible(false);
				panelMenuItems.hardButton.setVisible(false);
				panelMenuItems.resetButton.setVisible(true);
				panelMenuItems.undoButton.setVisible(true);
			}
		});
		
		// Medium button
		panelMenuItems.mediumButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateCurrentMaze();
				cardDeck.show(gameContent, "Medium");
				mazeDifficulty = MazeDifficulty.MEDIUM;
				minotaurTextLabel.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.easyButton.setVisible(false);
				panelMenuItems.mediumButton.setVisible(false);
				panelMenuItems.hardButton.setVisible(false);
				panelMenuItems.resetButton.setVisible(true);
				panelMenuItems.undoButton.setVisible(true);
			}
		});
		
		// Hard button
		panelMenuItems.hardButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				updateCurrentMaze();
				cardDeck.show(gameContent, "Hard");
				mazeDifficulty = MazeDifficulty.HARD;
				minotaurTextLabel.setVisible(true);
				panelMenuItems.startButton.setVisible(false);
				panelMenuItems.easyButton.setVisible(false);
				panelMenuItems.mediumButton.setVisible(false);
				panelMenuItems.hardButton.setVisible(false);
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
							break;
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

	/**
	 * Updates the currently selected maze.
	 */
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
	 * Reset current player and minotaur position and steps taken.
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
