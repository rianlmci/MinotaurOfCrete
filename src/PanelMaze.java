import javax.swing.*;

import edu.princeton.cs.algs4.In;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;


/**
 * Maze screen in the GUI.
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class PanelMaze extends JPanel {
    public GameMaster gm = new GameMaster();
    public void updateMinotaurTextLabel(){

        GameDisplay.minotaurTextLabel.setText(gm.minotaur.getMinotaurText());
    }

    public void displayGameOver(){
        GameDisplay.panelMenuItems.undoButton.setVisible(false);

        GameDisplay.panelMenuItems.resetButton.setVisible(false);

        GameDisplay.panelMenuItems.titleButton.setVisible(true);

        GameDisplay.minotaurTextLabel.setVisible(false);

        GameDisplay.cardDeck.show(GameDisplay.gameContent, "Lose");

    }
    public void displayGameOverWin(){
        GameDisplay.panelMenuItems.undoButton.setVisible(false);

        GameDisplay.panelMenuItems.resetButton.setVisible(false);

        GameDisplay.panelMenuItems.titleButton.setVisible(true);
        
        GameDisplay.minotaurTextLabel.setVisible(false);

        GameDisplay.cardDeck.show(GameDisplay.gameContent, "Win");

    }


   /*
   * = = = = = Graph as Text = = = = =
   *       0    1    2    3    4    5    6  [column k]
   * 0     1    -    0   " "   7    -    6
   * 1     |   " "   |    /    |    /    |
   * 2     2   " "   3    -    4   " "   5
   * [row i] " " is whitespace!
   */


    private GridCellContent[][] fillGridCells(In inputContents) {
    	String[] lines = inputContents.readAllLines();
    	GridCellContent[][] allCellContents = 
    			new GridCellContent[lines.length][(lines[0].length()/5)+1];
    	

    	// Testing print
    	int lineCounter = 0;
    	for (String currentLine : lines) {
    		int oneCounter = 0;
    		int fiveCounter = 0;
    		while (fiveCounter < currentLine.length()) {
    			char cellContentChar = currentLine.charAt(fiveCounter);
    			allCellContents[lineCounter][oneCounter] = 
    					new GridCellContent(Character.toString(cellContentChar));
    			oneCounter++;
    			fiveCounter += 5;
    		}
    		lineCounter++;
		}
    	return allCellContents;
    }
    
    GridCellContent [][] allCellContents = fillGridCells(new In("src/resources/EasyMazeDisplay.txt"));

    //TODO: Initialize with a text file based on difficulty?
//    GridCellContent [][] allCellContents = {
//            /*Row 0*/{
//            new GridCellContent("1"), /*[0][0]*/
//            new GridCellContent("-"), /*[0][1]*/
//            new GridCellContent("0"), /*[0][2]*/
//            new GridCellContent(" "), /*[0][3]*/
//            new GridCellContent("7"), /*[0][4]*/
//            new GridCellContent("-"), /*[0][5]*/
//            new GridCellContent("6"), /*[0][6]*/
//            },
//
//            /*Row 1*/{
//            new GridCellContent("|"), /*[1][0]*/
//            new GridCellContent(" "), /*[1][1]*/
//            new GridCellContent("|"), /*[1][2]*/
//            new GridCellContent("/"), /*[1][3]*/
//            new GridCellContent("|"), /*[1][4]*/
//            new GridCellContent("/"), /*[1][5]*/
//            new GridCellContent("|"), /*[1][6]*/
//            },
//
//            /*Row 2*/{
//            new GridCellContent("2"), /*[2][0]*/
//            new GridCellContent(" "), /*[2][1]*/
//            new GridCellContent("3"), /*[2][2]*/
//            new GridCellContent("-"), /*[2][3]*/
//            new GridCellContent("4"), /*[2][4]*/
//            new GridCellContent(" "), /*[2][5]*/
//            new GridCellContent("5"), /*[2][6]*/
//            }
//    };

    // Initialize 
    JPanel allPanels[][];
    int mazeStartingPoint = 0; //TODO Initialize based on maze difficulty.
    int mazeEndingPoint = 7; //TODO Initialize based on maze difficulty.
    private Map<JButton,GridCellContent> mapButtons =
            new HashMap<JButton,GridCellContent>((allCellContents.length * allCellContents[0].length));
    
    /**
     * Create panels from grid cells.
     * 
     */
    private void createPanelsFromGridCells() {
        Font cellFont = new Font("Tahoma", Font.BOLD, 8);
        allPanels = new JPanel[allCellContents.length][allCellContents[0].length]; //makes identical rows/col #s as allCells [][]
        setLayout(new GridLayout(allCellContents.length,allCellContents[0].length)); //makes identical rows/col #s as allCells [][]
        for (int i = 0; i < allCellContents.length; i++) {
            for (int j = 0; j < allCellContents[i].length; j++) {
                //set up button for this cell in the grid...
            	JButton cellButton = new JButton(allCellContents[i][j].getCellText());
                cellButton.setFont(cellFont);
                cellButton.setBackground(Color.BLACK);
                cellButton.setForeground(Color.WHITE);
                cellButton.setBorder(null);
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
                                        gm.player.moveBackward(); ///
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
                    allPanels[i][j].getComponent(0).setBackground(Color.BLACK);

                    try {
                        Integer.parseInt(thisButton.getText());
                            //if player has visited this node, mark it as orange
                            if (gm.player.hasVisited(Integer.parseInt(thisButton.getText()))){
                                allPanels[i][j].getComponent(0).setBackground(Color.ORANGE);
                            }

                            //if this cell is the ending point's cell, mark it as green.
                            if (allCellContents[i][j].isVertex() &&
                                    Integer.parseInt(allCellContents[i][j].getCellText()) == mazeEndingPoint){
                                allPanels[i][j].getComponent(0).setBackground(Color.GREEN);
                            }

                            //if player has not visited this node, and it's adjacent to the last node visited,
                            //then enable the player to click on this node.
                            for (Integer onePoint: thisCellsContent.getAdjacentPoints()) {
                                if (thisButton.getBackground() != Color.ORANGE &&
                                        !gm.player.nodesVisited.isEmpty() &&
                                        onePoint == gm.player.nodesVisited.peek()){
                                    allPanels[i][j].getComponent(0).setEnabled(true);
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

    PanelMaze(MazeDifficulty difficulty){
        gm.minotaur.setBestPath(difficulty);
        gm.player.moveForward(mazeStartingPoint);
        gm.minotaur.move(gm.player.stepsTaken);
        
//        fillGridCells(new In());
        
        createPanelsFromGridCells();

        for (int i = 0; i < allPanels.length; i++){
            for( int j = 0; j < allPanels[i].length; j++){
                add(allPanels[i][j]);
            }
        }
    }
//    
//    public static void main(String[] args) {
//    	
////    	GridCellContent [][] allCellContents = fillGridCells();
//    	
//		PanelMaze pm = new PanelMaze(MazeDifficulty.EASY);
//		
//		
//		pm.fillGridCells(new In("src/resources/EasyMazeDisplay.txt"));
//	}

}
