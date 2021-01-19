package fr.khalypso.statesearchlib.model;

import lombok.Getter;

/**
 * Node class model.
 */
public class Node {

	/**
	 * Parent of this node.
	 */
	@Getter
	private final Node parent;

	/**
	 * State within this node.
	 */
	@Getter
	private final State state;

	/**
	 * Cumulated cost to reach this node.
	 */
	@Getter
	private final int cost;

	/**
	 * Apply an operator and return the reached node.
	 *
	 * @param operator
	 * 	operator to apply
	 * @return the reached node.
	 */
	public Node applyOperator(final Operator operator) {
		return new Node(
			this,
			operator.apply(state),
			this.cost + operator.getCost());
	}

	/**
	 * Constructor.
	 * <p>
	 * Used for the initial node
	 * </p>
	 *
	 * @param state
	 * 	the initial state
	 */
	public Node(State state) {
		this(null, state, 0);
	}

	/**
	 * Hidden constructor.
	 * <p>
	 * Complete constructor.
	 * </p>
	 */
	private Node(Node parent, State state, int cost) {
		this.parent = parent;
		this.state = state;
		this.cost = cost;
	}
}
