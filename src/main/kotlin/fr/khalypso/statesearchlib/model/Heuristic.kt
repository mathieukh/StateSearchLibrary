package fr.khalypso.statesearchlib.model

/**
 * Heuristic class model.
 */
interface Heuristic {
    /**
     * Estimate a state value.
     *
     * @param state
     * the state to estimate
     * @return the estimation in an integer value
     */
    fun eval(state: State): Int
}
