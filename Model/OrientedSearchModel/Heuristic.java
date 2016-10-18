package Model.OrientedSearchModel;

import Model.State;

/**
 * Created by sylom on 13/01/2016.
 */

/**
 * L'interface permettant d'implémenter l'heuristique
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public interface Heuristic {
    /**
     * Evaluation d'un état en un nombre entier naturel
     *
     * @param state Etat à analyser
     * @return Nombre entier de l'évaluation
     */
    int eval(State state);
}
