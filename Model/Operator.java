package Model;

/**
 * Created by sylom on 13/01/2016.
 */

/**
 * L'interface Operator permet de modéliser un opérateur
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public abstract class Operator {
    /**
     * Propriété permettant de stocker le coût de l'opérateur
     */
    public int cost = 0;

    /**
     * Appliquer l'opérateur à un état pour obtenir le nouvel état
     *
     * @param state L'état auquel sera appliqué l'opérateur
     * @return L'état obtenu après application de l'opérateur
     * @throws OperatorApplicationException L'opérateur ne peut être appliquée sur l'état actuel
     */
    public abstract State apply(State state) throws OperatorApplicationException;

}
