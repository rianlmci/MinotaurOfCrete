import edu.princeton.cs.algs4.BreadthFirstPaths;
import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;

/**
 * The antagonist of the maze, the minotaur! It moves around the maze in a set path
 * to try and beat the player to the exit of the maze!
 */
public class Minotaur {
    private Integer [] bestPath;
    public static int stepsTaken;

    /**
     * Sets up the best path for the minotaur to take to
     * the exit of selected the maze.
     * @param difficulty the difficulty of the maze
     */
    public void setBestPath(MazeDifficulty difficulty){
        In graphFile;
        switch (difficulty){
            case EASY:
                graphFile = new In("src/resources/EasyGraph.txt");
                setBestPathHelper(graphFile,1, 7);//TODO: Files, Ent/Exit.
                break;
            case MEDIUM:
                graphFile = new In("src/resources/MediumGraph.txt");
                setBestPathHelper(graphFile,1, 8);//TODO: Files, Ent/Exit.
                break;
            case HARD:
                graphFile = new In("src/resources/HardGraph.txt");
                setBestPathHelper(graphFile,1, 9);//TODO: Files, Ent/Exit.
                break;
            default:
                System.err.println("Graph file not found! check your path and try again!");
                break;
        }
    }

    /**
     * Helper method to create the best path for the minotaur to take
     * @param graphFile the file containing the graph
     * @param entranceNodeNumber the node number for the entrance of the maze
     * @param exitNodeNumber the node number for the exit of the maze
     */
    private void setBestPathHelper(In graphFile,int entranceNodeNumber, int exitNodeNumber){
        Integer [] builtPath;
        Graph graph = new Graph(graphFile);
        BreadthFirstPaths bfs = new BreadthFirstPaths(graph,entranceNodeNumber);
        ArrayList<Integer> bestPathAsList;
        bestPathAsList = (ArrayList<Integer>) bfs.pathTo(exitNodeNumber); //casting to specific iterable for conversion
        bestPath = new Integer[bestPathAsList.size()]; //matching size
        bestPath = bestPathAsList.toArray(bestPath); //finally, filling out the array to the best path to exit
    }

    /**
     * Moves the minotaur the same amount of steps as the player
     * (aka setter for stepsTaken)
     * @param playerSteps number of steps the player has currently taken
     */
    public void move(int playerSteps){
        if (playerSteps < bestPath.length-1) {
            stepsTaken = playerSteps;
        }
    }
    
    public boolean hasReachedEnd() {
    	return bestPath.length == stepsTaken;
    }
    // = = = = = TEST CLIENT = = = = = //
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
