import edu.princeton.cs.algs4.Stack;

/**
 * Player who explores the maze and tries to escape it!
 */
public class Player {
	Stack<Integer> nodesVisited = new Stack<>();
	Integer currentNode;
	int stepsTaken;

	// methods
	public boolean hasVisited(Integer nodeToCheck){
		for (Integer oneNode:
			 nodesVisited) {
			if (oneNode == nodeToCheck){
				return true;
			}
		}
		return false;
	}
	public void moveForward(Integer nextNode) {
		nodesVisited.push(nextNode);
		stepsTaken++;
	}

	public void moveBackward() {
		nodesVisited.pop();
		stepsTaken--;
	}

}
