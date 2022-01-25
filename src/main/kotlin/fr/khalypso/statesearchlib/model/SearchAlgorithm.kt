package fr.khalypso.statesearchlib.model

import fr.khalypso.statesearchlib.model.exception.NoSolutionException

interface SearchAlgorithm {
    /**
     * Return a [Solution] if one can be found.
     *
     * @param initial
     * initial state from which one will search for the solution.
     */
    fun solve(initial: State): Solution? {
        val leaf = findLeaf(initial)
        return leaf?.convertAsSolution()
    }

    /**
     * Return a [Solution] if one can be found.
     *
     * @param initial
     * initial state from which one will search for the solution.
     * @throws NoSolutionException
     * no solution can be found
     */
    fun solveOrFail(initial: State): Solution {
        return solve(initial) ?: throw NoSolutionException()
    }

    /**
     * Find a leaf [Node] representing the solution.
     *
     * @param initial
     * initial state from which one will search for the solution.
     * @return the leaf node if available or null.
     */
    fun findLeaf(initial: State): Node?
}
