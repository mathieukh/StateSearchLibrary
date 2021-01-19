package fr.khalypso.statesearchlib.model;

import java.util.LinkedList;

/**
 * An ordered list of nodes to reach a terminal state.
 */
public class Solution extends LinkedList<Node> {

	/**
	 * Build a {@link Solution} from a {@link Node}.
	 */
	public static Solution buildFromNode(Node node) {
		Solution solution = new Solution();
		solution.addFirst(node);
		while (node != null) {
			node = node.getParent();
			solution.addFirst(node);
		}
		return solution;
	}

};
