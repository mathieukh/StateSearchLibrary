package fr.khalypso.statesearchlib.model.algorithm

import fr.khalypso.statesearchlib.model.Node
import fr.khalypso.statesearchlib.model.SearchAlgorithm
import fr.khalypso.statesearchlib.model.State
import java.util.*

class DfsAlgorithm : SearchAlgorithm {

    override fun findLeaf(initial: State): Node? {
        val stack = Stack<Node>()
        val discovered: MutableSet<Node> = HashSet()
        stack.push(Node.root(initial))
        while (!stack.empty()) {
            val current = stack.pop()
            if (discovered.contains(current)) {
                continue
            }
            if (current.state.isTerminal) {
                return current
            }
            discovered.add(current)
            current.state.operators.map { current.applyOperator(it) }.forEach { stack.push(it) }
        }
        return null
    }

}
