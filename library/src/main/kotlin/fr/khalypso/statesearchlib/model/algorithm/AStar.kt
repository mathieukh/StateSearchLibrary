package fr.khalypso.statesearchlib.model.algorithm

import fr.khalypso.statesearchlib.model.*
import java.util.ArrayList
import java.util.Comparator
import java.util.PriorityQueue

class AStar(private val heuristic: Heuristic) : SearchAlgorithm {

    private val comparator: Comparator<Node> = Comparator { n1: Node, n2: Node ->
        if (this.heuristic.eval(n1.state) < this.heuristic.eval(n2.state)) {
            1
        } else if (heuristic.eval(n1.state) == heuristic.eval(n2.state)) {
            0
        } else {
            -1
        }
    }

    override fun solve(initial: State): Solution? {
        val closedList = ArrayList<Node>()
        val openList = PriorityQueue(comparator)
        val init = Node.root(initial)
        openList.add(init)
        while (!openList.isEmpty()) {
            val u = openList.poll()
            if (u.state.isTerminal) {
                return u.convertAsSolution()
            }
            for (op in u.state.operators) {
                val vn = u.applyOperator(op)
                if (!existsWithLowestCost(vn, closedList) && !existsWithLowestCost(vn, openList)) {
                    openList.add(vn)
                }
            }
            closedList.add(u)
        }
        return null
    }

    private fun existsWithLowestCost(n: Node, list: Collection<Node>): Boolean {
        if (!list.contains(n)) {
            return false
        }
        for (c in list) {
            if (c.state == n.state) {
                return c.cost < n.cost
            }
        }
        return false
    }
}
