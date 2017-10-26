package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search{
    private Frontier frontier;
    public GraphSearch(Frontier fr) {
        frontier = fr;
    }
    public Node findSolution(Node root, GoalTest goalTest) {
        Set<State> exploredStates = new HashSet<State>();
        frontier.add(root);
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)) return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!exploredStates.contains(newState)) {
                        exploredStates.add(newState);
                        frontier.add(new Node(node, action, newState));
                    }
                }
            }
        }
        return null;
    }
}
