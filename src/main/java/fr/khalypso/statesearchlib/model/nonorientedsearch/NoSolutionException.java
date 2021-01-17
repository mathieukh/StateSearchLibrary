package fr.khalypso.statesearchlib.model.nonorientedsearch;

/**
 * Exception qui sera soulevée lorsqu'aucune solution ne sera trouvée
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public class NoSolutionException extends Exception {

	public NoSolutionException() {
		super("Aucune solution trouvée");
	}
}
