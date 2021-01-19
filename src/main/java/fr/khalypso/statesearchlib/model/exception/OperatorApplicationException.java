package fr.khalypso.statesearchlib.model.exception;

import fr.khalypso.statesearchlib.model.Operator;
import fr.khalypso.statesearchlib.model.State;

/**
 * Exception thrown when an {@link Operator} can not be applied to a {@link State}.
 */
public class OperatorApplicationException extends RuntimeException {

	public OperatorApplicationException() {
		super("The operator can not be applied to the current state");
	}
}
