package fr.khalypso.statesearchlib.model

import fr.khalypso.statesearchlib.model.exception.OperatorApplicationException

/**
 * Operator model class.
 */
interface Operator {
    /**
     * Return the cost of the operator.
     */
    val cost: Int

    /**
     * Apply the operator to the state given.
     *
     * @param state
     * the state on which the operator must be applied
     * @return the reached state after the application of the state
     * @throws OperatorApplicationException
     * an error occurred during the application of the operator
     */
    @Throws(OperatorApplicationException::class)
    fun apply(state: State): State
}
