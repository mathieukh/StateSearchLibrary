package fr.khalypso.statesearchlib.model;

import java.util.LinkedList;

/**
 * Une liste ordonnée de Node qui permet de retracer le chemin solution
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public class Solution extends LinkedList<Node> {

	/**
	 * Build a {@link Solution} from a {@link Node}.
	 * @param node
	 * @return
	 */
	public static Solution buildFromNode(Node node) {
		Solution solution = new Solution();
		solution.addFirst(node);
		while (node != null) {
			node = node.parent;
			solution.addFirst(node);
		}
		return solution;
	}

};
