package fr.khalypso.statesearchlib.model.nonorientedsearch;

import fr.khalypso.statesearchlib.model.Solution;
import fr.khalypso.statesearchlib.model.State;

/**
 * L'interface permettant de modéliser la structure d'un algorithme de recherche non orientée
 *
 * @author Mathieu KHALEM
 * @version 1.0
 */
public interface NonOrientedSearchAlgorithm {

	/**
	 * Retourne la solution à un problème
	 *
	 * @param initial
	 * 	L'état initial du problème
	 * @return La liste des noeuds permettant de tracer le chemin depuis l'état initial à l'état final
	 * @throws NoSolutionException
	 * 	L'exception est soulevée quand aucune solution n'a été trouvée
	 */
	Solution findSolution(State initial) throws NoSolutionException;
}
