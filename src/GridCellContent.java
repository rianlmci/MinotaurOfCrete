import edu.princeton.cs.algs4.Graph;
import edu.princeton.cs.algs4.In;

/**
 * Helper class for maze grid logic. A maze will be made of a series of cells in
 * a grid. A grid cell will either be a vertex, an edge*, or whitespace* (*) i/e
 * not a vertex. and each grid cell will contain either symbols or a whitespace.
 * 
 * @author Rianna McIntyre
 */
public class GridCellContent {
	private boolean isVertex = true;
	private String cellText;
	private Iterable<Integer> adjacentPoints;

	/**
	 * @param cellText symbol or symbols to be inserted into the grid cell.
	 * @throws IllegalArgumentException if <code>cellText</code> is null.
	 */
	GridCellContent(String cellText) {
		if (cellText == null) {
			throw new IllegalArgumentException("Cell text cannot be null");
		}

		if (cellText.equals(" ")) { // if cell is whitespace
			this.isVertex = false;
			this.cellText = cellText;
			return;
		}

		try {
			setAdjacent(Integer.parseInt(cellText));
			this.cellText = cellText;
		} catch (NumberFormatException nfe) {
			this.isVertex = false;
			this.cellText = cellText;
		}
	}

	/*
	 * Return text for this cell
	 */
	public String getCellText() {
		return cellText;
	}

	/*
	 * Return true if this cell is a vertex; else return false
	 */
	public Boolean isVertex() {
		return isVertex;
	}

	/*
	 * Set up adjacent vertices in the maze for a given vertex
	 */
	private void setAdjacent(Integer vertex) {
		In graphFile;
		Graph graph;
		switch (GameDisplay.mazeDifficulty) {
		case EASY:
			graphFile = new In("src/resources/EasyGraph.txt");
			graph = new Graph(graphFile);
			adjacentPoints = graph.adj(vertex);
			break;
		case MEDIUM:
			graphFile = new In("src/resources/MediumGraph.txt");
			graph = new Graph(graphFile);
			adjacentPoints = graph.adj(vertex);
			break;
		case HARD:
			graphFile = new In("src/resources/HardGraph.txt");
			graph = new Graph(graphFile);
			adjacentPoints = graph.adj(vertex);
			break;
		default:
			System.err.println("Graph file not found! check your path and try again!");
			break;
		}
	}

	/*
	 * Return adjacent points for a grid cell
	 */
	public Iterable<Integer> getAdjacentPoints() {
		return adjacentPoints;
	}
}
