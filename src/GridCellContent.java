import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;


/**
 * Helper class for maze grid logic.
 * A maze will be made of a series of cells in a grid.
 * A grid cell will either be a vertex, an edge*, or whitespace*
 * (*) i/e not a vertex.
 * and each grid cell will contain one symbol.
 */
public class GridCellContent {
    private boolean isVertex = true;
    private String cellText;
    private Iterable<Integer> adjacentPoints;

    /**
     * @param cellText symbol to be inserted into the grid cell
     * @throws IllegalArgumentException if <code>cellText</code> is null
     * @throws IllegalArgumentException if <code>cellText</code> is > 1
     */
    GridCellContent(String cellText) {
        if (cellText == null) {
            throw new IllegalArgumentException("Cell text cannot be null");
        }

        if (cellText.length() > 1) {
            throw new IllegalArgumentException("Cell text must less than or equal to 1");
        }

        if (cellText.equals(" ")){ //if cell is whitespace
            this.isVertex = false;
            this.cellText = cellText;
            return;
        }

        try {
            Integer.parseInt(cellText);
            this.cellText = cellText;
            setAdjacent(Integer.parseInt(cellText), MazeDifficulty.EASY);
        }
        catch (NumberFormatException nfe) {
            this.isVertex = false;
            this.cellText = cellText;
        }
    }



    public String getCellText(){
        return cellText;
    }

    public Boolean isVertex(){
        return isVertex;
    }

    private void setAdjacent(Integer vertex, MazeDifficulty difficulty){
        In graphFile;
        switch (difficulty){
            case EASY:
                graphFile = new In("src/resources/EasyGraph.txt");
                setAdjacentHelper(graphFile,vertex);
                break;
            case MEDIUM:
                graphFile = new In("src/resources/MediumGraph.txt");
                setAdjacentHelper(graphFile,vertex);
                break;
            case HARD:
                graphFile = new In("src/resources/HardGraph.txt");
                setAdjacentHelper(graphFile,vertex);
                break;
            default:
                System.err.println("Graph file not found! check your path and try again!");
                break;
        }
    }
    private void setAdjacentHelper(In graphFile, Integer vertex){
        Graph graph = new Graph(graphFile);
        adjacentPoints = graph.adj(vertex);
    }

    public Iterable<Integer> getAdjacentPoints() {
        return adjacentPoints;
    }
}

