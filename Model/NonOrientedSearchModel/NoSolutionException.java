package Model.NonOrientedSearchModel;

/**
 * Created by sylom on 13/01/2016.
 */

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
