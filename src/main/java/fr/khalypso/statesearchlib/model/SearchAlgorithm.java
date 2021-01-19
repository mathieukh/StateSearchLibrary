package fr.khalypso.statesearchlib.model;

import fr.khalypso.statesearchlib.model.exception.NoSolutionException;

public interface SearchAlgorithm {

	/**
	 * Return a {@link Solution} if one can be found.
	 *
	 * @param initial
	 * 	initial state from which one will search for the solution.
	 * @throws NoSolutionException
	 * 	no solution can be found
	 */
	default Solution findSolution(State initial) {
		Node leaf = findLeaf(initial);
		if (leaf == null) {
			throw new NoSolutionException();
		}
		return Solution.buildFromNode(leaf);
	}

	/**
	 * Find a leaf {@link Node} representing the solution.
	 *
	 * @param initial
	 * 	initial state from which one will search for the solution.
	 * @return the leaf node if available or null.
	 */
	Node findLeaf(State initial);


}
