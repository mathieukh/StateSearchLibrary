package fr.khalypso.statesearchlib.model.algorithm;

import fr.khalypso.statesearchlib.model.Heuristic;
import fr.khalypso.statesearchlib.model.Node;
import fr.khalypso.statesearchlib.model.Operator;
import fr.khalypso.statesearchlib.model.SearchAlgorithm;
import fr.khalypso.statesearchlib.model.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.PriorityQueue;

public class AStar implements SearchAlgorithm {

	private final Heuristic heuristic;

	private final Comparator<Node> comparator;

	public AStar(Heuristic h) {
		this.heuristic = Objects.requireNonNull(h);
		this.comparator = (n1, n2) -> {
			if (heuristic.eval(n1.getState()) < heuristic.eval(n2.getState())) {
				return 1;
			} else if (h.eval(n1.getState()) == h.eval(n2.getState())) {
				return 0;
			} else {
				return -1;
			}
		};
	}

	@Override
	public Node findLeaf(State initial) {
		ArrayList<Node> closedList = new ArrayList<>();
		PriorityQueue<Node> openList = new PriorityQueue<>(comparator);
		Node init = new Node(initial);
		openList.add(init);
		while (!openList.isEmpty()) {
			Node u = openList.poll();
			if (u.getState().isTerminal()) {
				return u;
			}
			for (Operator op : u.getState().operators()) {
				Node vn = u.applyOperator(op);
				if (!existsWithLowestCost(vn, closedList) && !existsWithLowestCost(vn, openList)) {
					openList.add(vn);
				}
			}
			closedList.add(u);
		}
		return null;
	}

	private boolean existsWithLowestCost(Node n, Collection<Node> list) {
		if (!list.contains(n)) {
			return false;
		} else {
			for (Node c : list) {
				if (c.equals(n)) {
					return c.getCost() < n.getCost();
				}
			}
		}
		return false;
	}

}
