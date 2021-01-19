package fr.khalypso.statesearchlib.model;

import java.util.List;


/**
 * State model class.
 * <p>
 * A state class
 * </p>
 */
public interface State {

	/**
	 * Is the state a terminal one.
	 */
	boolean isTerminal();

	/**
	 * {@link Operator} list that can be applied on this state.
	 */
	List<Operator> operators();

}
