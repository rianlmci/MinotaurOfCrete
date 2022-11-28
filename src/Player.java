import edu.princeton.cs.algs4.Stack;

/**
 * Player who explores the maze and tries to escape it!
 * @author Rianna McIntyre
 * @author Wyatt McCurdy
 */
public class Player {
	protected Stack<Integer> nodesVisited = new Stack<>();
	protected int stepsTaken;

	// methods
	/**
	 * Checks if the player has visited a particular node
	 */
	public boolean hasVisited(Integer nodeToCheck) {
		for (Integer oneNode : nodesVisited) {
			if (oneNode == nodeToCheck) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Moves the player forward and increments their steps taken
	 */
	public void moveForward(Integer nextNode) {
		nodesVisited.push(nextNode);
		stepsTaken = nodesVisited.size()-1; //to account for starting point
	}

	/**
	 * Moves the player to their previous position and decrements their number of
	 * steps (takes back their turn)
	 */
	public void moveBackward() {
		if (nodesVisited.size() == 1) {
			return;
		}
		nodesVisited.pop();
		stepsTaken = nodesVisited.size()-1; //to account for starting point
	}
}