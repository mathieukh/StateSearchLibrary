package fr.khalypso.statesearchlib.model.orientedsearch;

import fr.khalypso.statesearchlib.model.Node;
import fr.khalypso.statesearchlib.model.nonorientedsearch.NoSolutionException;
import fr.khalypso.statesearchlib.model.Solution;
import fr.khalypso.statesearchlib.model.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;

public class AStar extends OrientedSearchAlgorithm {

	Comparator<Node> comparator = (n1, n2) -> {
		if (h.eval(n1.state) < h.eval(n2.state)) {
			return 1;
		} else if (h.eval(n1.state) == h.eval(n2.state)) {
			return 0;
		} else {
			return -1;
		}
	};

	public AStar(Heuristic h) {
		super(h);
	}

	@Override
	public Solution findSolution(State initial) throws NoSolutionException {
		ArrayList<Node> closedList = new ArrayList<>();
		PriorityQueue<Node> openList = new PriorityQueue<>(comparator);
		Node init = new Node(initial);
		openList.add(init);
		while (!openList.isEmpty()) {
			Node u = openList.poll();
			if (u.state.isTerminal()) {
				return makeSolution(u);
			}
			for (State v : u.state.successors()) {
				Node vn = new Node(v, u);
				if (existsWithLowestCost(vn, closedList) || existsWithLowestCost(vn, openList)) {
					continue;
				} else {
					vn.cost = u.cost + v.operator.cost;
					v.heuristic = h.eval(v);
					openList.add(vn);
				}
			}
			closedList.add(u);
		}
		throw new NoSolutionException();
	}

	private boolean existsWithLowestCost(Node n, Collection<Node> list) {
		if (!list.contains(n)) {
			return false;
		} else {
			for (Node c : list) {
				if (c.equals(n)) {
					return c.cost < n.cost;
				}
			}
		}
		return false;
	}

	private Solution makeSolution(Node node) {
		Solution solution = new Solution();
		solution.addFirst(node);
		while (node != null) {
			node = node.parent;
			solution.addFirst(node);
		}
		return solution;
	}

}
