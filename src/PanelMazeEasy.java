import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;


/**
 * Easy difficulty maze screen in the GUI.
 */
public class PanelMazeEasy extends JPanel {
    private GameMaster gm = new GameMaster();


   /*
   * = = = = = Graph as Text = = = = =
   *       0    1    2    3    4    5    6  [column k]
   * 0     1    -    0   " "   7    -    6
   * 1     |   " "   |    /    |    /    |
   * 2     2   " "   3    -    4   " "   5
   * [row i] " " is whitespace!
   */

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

    int mazeStartingPoint;
    int mazeEndingPoint;
    JPanel allPanels[][];
    Font cellFont = new Font("Tahoma", Font.PLAIN, 12);
    private Map<JButton, GridCellContent> mapButtons = new HashMap<JButton, GridCellContent>((allCellContents.length * allCellContents[0].length));
    private void createPanelsFromGridCells() {
        gm.minotaur.setBestPath(MazeDifficulty.EASY);
        allPanels = new JPanel[allCellContents.length][allCellContents[0].length]; //makes identical rows/col #s as allCells [][]
        for (int i = 0; i < allCellContents.length; i++) {
            for (int j = 0; j < allCellContents[i].length; j++) {
                //set up button for this cell in the grid...
                JButton cellButton = new JButton(allCellContents[i][j].getCellText());
                cellButton.setFont(cellFont);
                cellButton.setBackground(Color.BLACK);
                cellButton.setForeground(Color.WHITE);
                cellButton.setBorder(null);
                mapButtons.put(cellButton, allCellContents[i][j]); //add key value pair for later use

                //if this cell is the starting point's cell, mark it as orange.
                if (allCellContents[i][j].isVertex() && Integer.parseInt(allCellContents[i][j].getCellText()) == mazeStartingPoint){
                    cellButton.setBackground(Color.ORANGE);
                }

                //if this cell is not a vertex, don't let the user click on it.
                if (!allCellContents[i][j].isVertex()){
                    cellButton.setEnabled(false);
                }

                else{
                    cellButton.addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            Object source = e.getSource();
                            if(source instanceof JButton){
                                GridCellContent thisContent = mapButtons.get(cellButton);
                                //is the button a connector, whitespace, or a vertex?
                                if (thisContent.isVertex()) {
                                    //if the player hasn't visited this node, mark it as orange, update grid
                                    if(!gm.player.hasVisited(Integer.parseInt(thisContent.getCellText()))) {
                                        gm.player.moveForward(Integer.parseInt(thisContent.getCellText()));
                                        gm.minotaur.move(gm.player.stepsTaken);
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
                add(cellPanel); //adds to the Maze Grid
            }
        }
        updateMazeGUI();
    }

    private void updateMazeGUI() {
        for (int i = 0; i < allPanels.length; i++) {
            for (int j = 0; j < allPanels[i].length; j++) {
                if(allPanels[i][j].getComponent(0) instanceof JButton){
                    GridCellContent thisContent = mapButtons.get((JButton)allPanels[i][j].getComponent(0));
                    JButton thisButton = (JButton) allPanels[i][j].getComponent(0);
                    allPanels[i][j].getComponent(0).setEnabled(false);

                    try {
                        Integer.parseInt(thisButton.getText());
                        if (gm.player.hasVisited(Integer.parseInt(thisButton.getText()))){
                            allPanels[i][j].getComponent(0).setBackground(Color.ORANGE);
                        }

                        for (Integer onePoint: thisContent.getAdjacentPoints()) {
                            if (thisButton.getBackground() != Color.ORANGE && onePoint == gm.player.nodesVisited.peek()){
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

    PanelMazeEasy(){
        gm.player.nodesVisited.push(mazeStartingPoint);
        setLayout(new GridLayout(3,7));
        createPanelsFromGridCells();

        for (int i = 0; i < allPanels.length; i++){
            for( int j = 0; j < allPanels[i].length; j++){
                add(allPanels[i][j]);
            }
        }
    }

}
