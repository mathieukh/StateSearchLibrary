package fr.khalypso.statesearchlib.model;

/**
 * Exception qui sera utilisé lors de l'échec de l'application d'un opérateur sur un état
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public class OperatorApplicationException extends Exception {
    public OperatorApplicationException() {
        super("L'opérateur ne peut être appliqué sur l'état actuel");
    }
}
