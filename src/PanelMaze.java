import javax.swing.*;

import edu.princeton.cs.algs4.In;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;

/**
 * Maze screens in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelMaze extends JPanel {
    protected GameMaster gm = new GameMaster();
    private JPanel allPanels[][];
    private GridCellContent [][] allCellContents;
    private Map<JButton,GridCellContent> mapButtons;
    private int mazeStartingPoint;
    private int mazeEndingPoint;

    //Look and feel of maze:
    private final Color FONT_COLOR = Color.WHITE;
    private final Color BACKGROUND_COLOR = Color.decode("#181A1B"); //hex code decoder, a charcoal color.
    private final Color VISITED_COLOR = Color.ORANGE;
    private final Color EXIT_COLOR = Color.GREEN;

    PanelMaze(MazeDifficulty difficulty){
        gm.minotaur.setBestPath(difficulty);
        setBackground(BACKGROUND_COLOR);
        switch (difficulty){ 
            case EASY:
                //TODO: remove when finished all mazes
                GameDisplay.mazeDifficulty = MazeDifficulty.EASY;
                allCellContents = fillGridCells(new In("src/resources/EasyMazeDisplay.txt"));
                mazeStartingPoint = 0;
                mazeEndingPoint = 7;
                break;
            case MEDIUM:
                //TODO: remove when finished all mazes
                GameDisplay.mazeDifficulty = MazeDifficulty.MEDIUM;
                allCellContents = fillGridCells(new In("src/resources/MediumMazeDisplay.txt"));
                mazeStartingPoint = 7;
                mazeEndingPoint = 9;
                break;
            case HARD:
            	// TODO create hard maze
                //TODO: remove when finished all mazes
                GameDisplay.mazeDifficulty = MazeDifficulty.HARD;
                allCellContents = fillGridCells(new In("src/resources/HardMazeDisplay.txt"));
                mazeStartingPoint = 11;
                mazeEndingPoint = 4;
                break;
        }

        mapButtons = new HashMap<>((allCellContents.length * allCellContents[0].length));
        gm.player.moveForward(mazeStartingPoint);
        gm.minotaur.move(gm.player.stepsTaken);

        createPanelsFromGridCells();

        for (int i = 0; i < allPanels.length; i++){
            for( int j = 0; j < allPanels[i].length; j++){
                add(allPanels[i][j]);
            }
        }
    }

    /*
     * Updates screen text to communicate the position of the Minotaur
     */
    public void updateMinotaurTextLabel(){
        GameDisplay.minotaurTextLabel.setText(gm.minotaur.getMinotaurText());
    }

    /**
     * Displays the losing screen to the user.
     */
    public void displayGameOver(){
        GameDisplay.panelMenuItems.undoButton.setVisible(false);

        GameDisplay.panelMenuItems.resetButton.setVisible(false);

        GameDisplay.panelMenuItems.titleButton.setVisible(true);

        GameDisplay.minotaurTextLabel.setVisible(false);

        GameDisplay.cardDeck.show(GameDisplay.gameContent, "Lose");

    }
    /**
     * Displays the winning screen to the user.
     */
    public void displayGameOverWin(){
        GameDisplay.panelMenuItems.undoButton.setVisible(false);

        GameDisplay.panelMenuItems.resetButton.setVisible(false);

        GameDisplay.panelMenuItems.titleButton.setVisible(true);
        
        GameDisplay.minotaurTextLabel.setVisible(false);

        GameDisplay.cardDeck.show(GameDisplay.gameContent, "Win");
    }

    /*
     * Constructs a game board of grid cells based on an input text file
     */
    private GridCellContent[][] fillGridCells(In inputContents) {
    	String[] lines = inputContents.readAllLines();
    	
    	String[] firstLineList = lines[0].split(",");
    	
    	GridCellContent[][] localCellContents = 
    			new GridCellContent[lines.length][firstLineList.length];
    	
    	int lineCounter = 0;
    	for (String currentLine : lines) {
    		
    		String[] currentLineList = currentLine.split(",");
    		
    		int cellCounter = 0;
    		for (int i = 0; i < currentLineList.length; i++) {
    			localCellContents[lineCounter][cellCounter] = 
    					new GridCellContent(currentLineList[i]);
    			cellCounter++;
    		}
    		lineCounter++;
		}
    	return localCellContents;
    }

    /**
     * Create panels from grid cells.
     */
    private void createPanelsFromGridCells() {
        //Font style setup:
        FontGetter fontGetter = new FontGetter();
        Font cellFont = fontGetter.getFontByName("VCR_OSD_MONO_1.001.ttf");
        cellFont = cellFont.deriveFont(Font.BOLD,20);

        allPanels = new JPanel[allCellContents.length][allCellContents[0].length]; //makes identical rows/col #s as allCells [][]
        setLayout(new GridLayout(allCellContents.length,allCellContents[0].length)); //makes identical rows/col #s as allCells [][]
        for (int i = 0; i < allCellContents.length; i++) {
            for (int j = 0; j < allCellContents[i].length; j++) {
                //set up button for this cell in the grid...
            	JButton cellButton = new JButton(allCellContents[i][j].getCellText());
                cellButton.setFont(cellFont);
                cellButton.setBackground(BACKGROUND_COLOR);
                cellButton.setForeground(FONT_COLOR);
                cellButton.setBorder(null);
                cellButton.setFocusable(false);
                cellButton.setFocusPainted(false);
                mapButtons.put(cellButton, allCellContents[i][j]); //add key value pair for later use
                //if this cell is not a vertex, don't let the user click on it.
                if (!allCellContents[i][j].isVertex()){
                    cellButton.setEnabled(false);
                }

                else{
                    cellButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Object source = e.getSource();
                            if(source instanceof JButton){
                                GridCellContent thisCellsContent = mapButtons.get(source);
                                //if player clicked the cell containing the end node, they win!
                                if(thisCellsContent.getCellText().equals(String.valueOf(mazeEndingPoint))) {
                                    while (gm.player.nodesVisited.size() > 1){
                                        gm.player.moveBackward();
                                    }
                                    gm.minotaur.move(0);
                                    displayGameOverWin();
                                }

                                //if the player hasn't visited this node, mark it as orange, update grid
                                if (!gm.player.hasVisited(Integer.parseInt(thisCellsContent.getCellText()))){
                                    gm.player.moveForward(Integer.parseInt(thisCellsContent.getCellText()));
                                    gm.minotaur.move(gm.player.stepsTaken);
                                }

                                //check minotaur lose condition
                                if(gm.checkLoseCondition()){
                                    while (gm.player.nodesVisited.size() > 1){
                                        gm.player.moveBackward();
                                    }
                                    gm.minotaur.move(0);
                                    displayGameOver();
                                }
                            }
                            updateMazeGUI();
                        }
                });
            }
                //finally, sets up JPanel with this button that will go inside the grid...
                JPanel cellPanel = new JPanel(new BorderLayout());
                cellPanel.add(cellButton, SwingConstants.CENTER); //adds button to this panel
                cellPanel.setBackground(BACKGROUND_COLOR);
                allPanels[i][j] = cellPanel; //add to 2D array for later reference
                add(cellPanel); //adds to the maze Grid
            }
        }
    }

    /**
     * Updates this maze's components
     * to display up-to-date information.
     */
    public void updateMazeGUI() {
        for (int i = 0; i < allPanels.length; i++) {
            for (int j = 0; j < allPanels[i].length; j++) {
                if(allPanels[i][j].getComponent(0) instanceof JButton){
                    GridCellContent thisCellsContent = mapButtons.get((JButton)allPanels[i][j].getComponent(0));
                    JButton thisButton = (JButton) allPanels[i][j].getComponent(0);

                    //first, we reset buttons to default values
                    allPanels[i][j].getComponent(0).setEnabled(false);
                    allPanels[i][j].getComponent(0).setBackground(BACKGROUND_COLOR);

                    try {
                        Integer.parseInt(thisButton.getText());
                        //if player has visited this node, mark it with visited color
                        if (gm.player.hasVisited(Integer.parseInt(thisButton.getText()))) {
                            allPanels[i][j].getComponent(0).setBackground(VISITED_COLOR);
                        }

                        //if this cell is the ending point's cell, mark it with the exit color
                        if (Integer.parseInt(allCellContents[i][j].getCellText()) == mazeEndingPoint) {
                            allPanels[i][j].getComponent(0).setBackground(EXIT_COLOR);
                        }

                        if (!thisCellsContent.getCellText().equals(gm.player.nodesVisited.peek())) {
                            //if player has not visited this node, and it's adjacent to the last node visited,
                            //then enable the player to click on this node.
                            for (Integer onePoint : thisCellsContent.getAdjacentPoints()) {
                                if (thisButton.getBackground() != VISITED_COLOR &&
                                        onePoint == gm.player.nodesVisited.peek()) {
                                    allPanels[i][j].getComponent(0).setEnabled(true);
                                }
                            }
                        }
                    }
                    catch (NumberFormatException nfe) {
                    }
                };
            }
        }
        updateMinotaurTextLabel();
    }

    // = = = = = TEST CLIENT = = = = = //
     public static void main(String[] args) {
  	    /*
        GridCellContent [][] allCellContents = fillGridCells();

        PanelMaze pm = new PanelMaze(MazeDifficulty.EASY);

        pm.fillGridCells(new In("src/resources/EasyMazeDisplay.txt"));
  	     */
	}
}
