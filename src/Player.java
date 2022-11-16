import edu.princeton.cs.algs4.Stack;

public class Player {
	Stack<Integer> nodesVisited = new Stack<>();
	Integer currentNode;
	int stepsTaken;

	// methods
	public void moveForward(Integer nextNode) {
		nodesVisited.push(nextNode);
		stepsTaken++;
	}

	public void moveBackward() {
		nodesVisited.pop();
		stepsTaken--;
	}

}
