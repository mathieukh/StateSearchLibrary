package fr.khalypso.statesearchlib.model.algorithm;

import fr.khalypso.statesearchlib.model.Node;
import fr.khalypso.statesearchlib.model.SearchAlgorithm;
import fr.khalypso.statesearchlib.model.State;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DfsAlgorithm implements SearchAlgorithm {

	@Override
	public Node findLeaf(State initial) {
		Stack<Node> stack = new Stack<>();
		Set<Node> discovered = new HashSet<>();
		stack.push(new Node(initial));
		while (!stack.empty()) {
			Node current = stack.pop();
			if (discovered.contains(current)) {
				continue;
			}
			if (current.getState().isTerminal()) {
				return current;
			}
			discovered.add(current);
			current.getState().operators().forEach(op -> stack.push(current.applyOperator(op)));
		}
		return null;
	}

}
