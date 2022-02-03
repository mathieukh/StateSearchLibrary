package fr.khalypso.statesearchlib.model

/**
 * State model class.
 *
 *
 * A state class
 *
 */
interface State {
    /**
     * Is the state a terminal one.
     */
    val isTerminal: Boolean

    /**
     * [Operator] list that can be applied on this state.
     */
    val operators: List<Operator>
}
