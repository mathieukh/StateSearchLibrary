package fr.khalypso.statesearchlib.model;

/**
 * Heuristic class model.
 */
public interface Heuristic {


	/**
	 * Estimate a state value.
	 *
	 * @param state
	 * 	the state to estimate
	 * @return the estimation in an integer value
	 */
	int eval(State state);
}
