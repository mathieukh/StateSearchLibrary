package fr.khalypso.statesearchlib.model.exception;

/**
 * Exception thrown when no solution is found.
 */
public class NoSolutionException extends RuntimeException {

	public NoSolutionException() {
		super("No solution found");
	}
}
