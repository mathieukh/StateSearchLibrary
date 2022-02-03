package fr.khalypso.statesearchlib.model.algorithm

import fr.khalypso.statesearchlib.model.Node
import fr.khalypso.statesearchlib.model.SearchAlgorithm
import fr.khalypso.statesearchlib.model.Solution
import fr.khalypso.statesearchlib.model.State
import java.util.*
import kotlin.collections.ArrayDeque

class BfsAlgorithm: SearchAlgorithm {

    override fun solve(initial: State): Solution? {
        val queue = ArrayDeque<Node>()
        queue.addLast(Node.root(initial))
        val discovered: MutableSet<Node> = HashSet()
        while (!queue.isEmpty()) {
            val current = queue.first()
            if (discovered.contains(current)) {
                continue
            }
            if (current.state.isTerminal) {
                return current.convertAsSolution()
            }
            discovered.add(current)
            current.state.operators.map { current.applyOperator(it) }.forEach { queue.addLast(it) }
        }
        return null
    }

}