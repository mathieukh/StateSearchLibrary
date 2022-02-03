package fr.khalypso.statesearchlib.model

import java.util.*

/**
 * Node class model.
 */
class Node private constructor(
    /**
     * Parent of this node.
     */
    private val _parent: Node?,
    /**
     * State within this node.
     */
    val state: State,
    /**
     * Cumulated cost to reach this node.
     */
    val cost: Int
) {
    /**
     * Apply an operator and return the reached node.
     *
     * @param operator
     * operator to apply
     * @return the reached node.
     */
    fun applyOperator(operator: Operator): Node {
        return Node(
            this,
            operator.apply(state),
            cost + operator.cost
        )
    }

    val parent: Optional<Node> = Optional.ofNullable(_parent)

    fun convertAsSolution(): Solution {
        if (!state.isTerminal) {
            throw IllegalStateException("The state of the node is not terminal. Won't create a solution from here.")
        }
        var nextNode = this
        val solution = Solution()
        solution.addFirst(nextNode)
        while (nextNode.parent.isPresent) {
            nextNode = nextNode.parent.get()
            solution.addFirst(nextNode)
        }
        return solution
    }

    companion object {
        /**
         * Constructor for the initial state.
         *
         * @param state
         * the initial state
         */
        fun root(state: State): Node {
            return Node(_parent = null, state = state, cost = 0)
        }
    }
}
