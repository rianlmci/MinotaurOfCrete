import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;


/**
 * Maze screen in the GUI.
 */
public class PanelMaze extends JPanel {
    public GameMaster currentGM = new GameMaster();

    /**
     * Updates the GameContainer's GM
     * by calling parent containers until we reach the GameDisplay's gm,
     * the master copy of the Game Master variable.
     */
    public void updateMasterGm(){
        ((GameDisplay)this.
                getParent(). /*JPanel*/
                getParent(). /*JPanel*/
                getParent(). /*JPanel*/
                getParent(). /*LayeredPane*/
                getParent(). /*JRootPane*/
                getParent() /*GameDisplay*/).gm = currentGM;
    }

    public void updateMinotaurTextLabel(){
        ((GameDisplay)this.
                getParent(). /*JPanel*/
                getParent(). /*JPanel*/
                getParent(). /*JPanel*/
                getParent(). /*LayeredPane*/
                getParent(). /*JRootPane*/
                getParent() /*GameDisplay*/).minotaurTextLabel.setText(currentGM.minotaur.getMinotaurText());
    }

    public void displayGameOver(){
        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.undoButton.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.resetButton.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.titleButton.setVisible(true);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).minotaurTextLabel.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).cardDeck.show(GameDisplay.gameContent, "Lose");

    }
    public void displayGameOverWin(){
        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.undoButton.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.resetButton.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).panelMenuItems.titleButton.setVisible(true);
        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).minotaurTextLabel.setVisible(false);

        ((GameDisplay)this.
                getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*JPanel*/
                        getParent(). /*LayeredPane*/
                        getParent(). /*JRootPane*/
                        getParent() /*GameDisplay*/).cardDeck.show(GameDisplay.gameContent, "Win");

    }


   /*
   * = = = = = Graph as Text = = = = =
   *       0    1    2    3    4    5    6  [column k]
   * 0     1    -    0   " "   7    -    6
   * 1     |   " "   |    /    |    /    |
   * 2     2   " "   3    -    4   " "   5
   * [row i] " " is whitespace!
   */

    //TODO: Initialize with a text file based on difficulty?
    GridCellContent [][] allCellContents = {
            /*Row 0*/{
            new GridCellContent("1"), /*[0][0]*/
            new GridCellContent("-"), /*[0][1]*/
            new GridCellContent("0"), /*[0][2]*/
            new GridCellContent(" "), /*[0][3]*/
            new GridCellContent("7"), /*[0][4]*/
            new GridCellContent("-"), /*[0][5]*/
            new GridCellContent("6"), /*[0][6]*/
            },

            /*Row 1*/{
            new GridCellContent("|"), /*[1][0]*/
            new GridCellContent(" "), /*[1][1]*/
            new GridCellContent("|"), /*[1][2]*/
            new GridCellContent("/"), /*[1][3]*/
            new GridCellContent("|"), /*[1][4]*/
            new GridCellContent("/"), /*[1][5]*/
            new GridCellContent("|"), /*[1][6]*/
            },

            /*Row 2*/{
            new GridCellContent("2"), /*[2][0]*/
            new GridCellContent(" "), /*[2][1]*/
            new GridCellContent("3"), /*[2][2]*/
            new GridCellContent("-"), /*[2][3]*/
            new GridCellContent("4"), /*[2][4]*/
            new GridCellContent(" "), /*[2][5]*/
            new GridCellContent("5"), /*[2][6]*/
            }
    };

    JPanel allPanels[][];
    int mazeStartingPoint = 0; //TODO Initialize based on maze difficulty.
    int mazeEndingPoint = 7; //TODO Initialize based on maze difficulty.
    private Map<JButton,GridCellContent> mapButtons =
            new HashMap<JButton,GridCellContent>((allCellContents.length * allCellContents[0].length));
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
                            updateMinotaurTextLabel();
                            Object source = e.getSource();
                            if(source instanceof JButton){
                                GridCellContent thisCellsContent = mapButtons.get(source);
                                //TODO Remove text when bugs are fixed!
                                JButton thisCellButton = (JButton) source;
                                System.out.println("TEMPORARY TESTING TEXT IN GRAPH BUTTON:");
                                System.out.printf("Player steps: %f\n" +
                                                "Minotaur steps: %f\n" +
                                                "Minotaur path size: %d\n" +
                                                "Minotaur has reached end %b\n",
                                        currentGM.player.stepsTaken,
                                        currentGM.minotaur.stepsTaken,
                                        currentGM.minotaur.bestPath.length,
                                        currentGM.minotaur.hasReachedEnd());

                                //if player reached the end node, they win!
                                if(thisCellsContent.getCellText().equals(String.valueOf(currentGM.player.nodesVisited.peek()))){
                                    while (currentGM.player.nodesVisited.size() > 1){
                                        currentGM.player.moveBackward();
                                    }
                                    currentGM.minotaur.move(0);
                                    updateMinotaurTextLabel();
                                    updateMasterGm();
                                    updateMazeGUI();
                                    displayGameOverWin();
                                }
                                //check minotaur lose condition
                                else if(currentGM.checkLoseCondition()){
                                    while (currentGM.player.nodesVisited.size() > 1){
                                        currentGM.player.moveBackward();
                                    }
                                    currentGM.minotaur.move(0);
                                    updateMinotaurTextLabel();
                                    updateMasterGm();
                                    updateMazeGUI();
                                    displayGameOver();
                                }

                                //is the button a connector, whitespace, or a vertex?
                                if (thisCellsContent.isVertex()) {
                                        //if the player hasn't visited this node, mark it as orange, update grid
                                        if (!currentGM.player.hasVisited(Integer.parseInt(thisCellsContent.getCellText()))){
                                            currentGM.player.moveForward(Integer.parseInt(thisCellsContent.getCellText()));
                                            currentGM.minotaur.move(currentGM.player.stepsTaken);
                                            updateMasterGm();
                                        }
                                    }
                                }
                            updateMazeGUI();
                        }
                });
            }
                //finally, sets up JPanel with this button that will go inside the grid...
                JPanel cellPanel = new JPanel(new BorderLayout());
                allPanels[i][j] = cellPanel; //add to 2D array for later reference
                cellPanel.add(cellButton, SwingConstants.CENTER); //adds button to this panel
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
                            if (currentGM.player.hasVisited(Integer.parseInt(thisButton.getText()))){
                                allPanels[i][j].getComponent(0).setBackground(Color.ORANGE);
                            }

                            //if this cell is the ending point's cell, mark it as green.
                            if (allCellContents[i][j].isVertex() && Integer.parseInt(allCellContents[i][j].getCellText()) == mazeEndingPoint){
                                allPanels[i][j].getComponent(0).setBackground(Color.GREEN);
                            }


                            //if player has not visited this node, and it's adjacent to the last node visited,
                            //then enable the player to click on this node.
                            for (Integer onePoint: thisCellsContent.getAdjacentPoints()) {
                                if (thisButton.getBackground() != Color.ORANGE && onePoint == currentGM.player.nodesVisited.peek()){
                                    allPanels[i][j].getComponent(0).setEnabled(true);
                                }
                            }
                    }
                    catch (NumberFormatException nfe) {

                    }

                };
            }
        }
    }

    PanelMaze(MazeDifficulty difficulty){
        currentGM.minotaur.setBestPath(difficulty);
        currentGM.player.moveForward(mazeStartingPoint);
        currentGM.minotaur.move(currentGM.player.stepsTaken);
        createPanelsFromGridCells();

        for (int i = 0; i < allPanels.length; i++){
            for( int j = 0; j < allPanels[i].length; j++){
                add(allPanels[i][j]);
            }
        }
    }

}
