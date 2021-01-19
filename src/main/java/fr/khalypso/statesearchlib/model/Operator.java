package fr.khalypso.statesearchlib.model;

import fr.khalypso.statesearchlib.model.exception.OperatorApplicationException;

/**
 * Operator model class.
 */
public interface Operator {

	/**
	 * Return the cost of the operator.
	 */
	int getCost();

	/**
	 * Apply the operator to the state given.
	 *
	 * @param state
	 * 	the state on which the operator must be applied
	 * @return the reached state after the application of the state
	 * @throws OperatorApplicationException
	 * 	an error occurred during the application of the operator
	 */
	State apply(final State state) throws OperatorApplicationException;

}
