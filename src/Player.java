import edu.princeton.cs.algs4.Stack;

/**
 * Player who explores the maze and tries to escape it!
 */
public class Player {
	Stack<Integer> nodesVisited = new Stack<>();
	Integer currentNode;
	protected double stepsTaken;

	// methods
	/*
	 * Check if the player has visited a particular node
	 */
	public boolean hasVisited(Integer nodeToCheck) {
		for (Integer oneNode : nodesVisited) {
			if (oneNode == nodeToCheck) {
				return true;
			}
		}
		return false;
	}

	/*
	 * Move the player forward and increment their steps taken
	 */
	public void moveForward(Integer nextNode) {
		nodesVisited.push(nextNode);
		stepsTaken = nodesVisited.size();
	}

	/*
	 * Move the player to their previous position and decrement their number of
	 * steps (take back the turn)
	 */
	public void moveBackward() {
		// TODO make sure this doesn't give mismatched minotaur/player moves
		if (nodesVisited.size() == 1) {
			return;
		}
		nodesVisited.pop();
		stepsTaken = nodesVisited.size();
	}
}