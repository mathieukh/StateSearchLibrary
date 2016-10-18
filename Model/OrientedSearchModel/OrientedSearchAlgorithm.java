package Model.OrientedSearchModel;

/**
 * Created by sylom on 13/01/2016.
 */

import Model.NonOrientedSearchModel.NoSolutionException;
import Model.Solution;
import Model.State;

/**
 * L'interface permettant de modéliser la structure d'un algorithme de recherche orientée
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public abstract class OrientedSearchAlgorithm {

    /**
     * Heuristique qui permettra d'orienter la recherche
     */
    public Heuristic h = null;

    public OrientedSearchAlgorithm(Heuristic h){
        this.h = h;
    }

    /**
     * Retourne la solution à un problème
     *
     * @param initial L'état initial du problème
     * @return La liste des noeuds permettant de tracer le chemin depuis l'état initial à l'état final
     * @throws NoSolutionException L'exception est soulevée quand aucune solution n'a été trouvée
     */
    public abstract Solution findSolution(State initial) throws NoSolutionException;
}
