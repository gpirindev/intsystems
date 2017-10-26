package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search{
    private Frontier frontier;
    private int maxFrontierSize = 0;
    public GraphSearch(Frontier fr) {
        frontier = fr;
    }
    public Node findSolution(Node root, GoalTest goalTest) {
        maxFrontierSize = 0;
        Set<State> exploredStates = new HashSet<State>();
        frontier.add(root);
        int currentFrontierSize = 1;
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            currentFrontierSize -= 1;
            if(goalTest.isGoal(node.state)) return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!exploredStates.contains(newState)) {
                        exploredStates.add(newState);
                        currentFrontierSize += 1;
                        frontier.add(new Node(node, action, newState));
                    }
                }
                if (currentFrontierSize > maxFrontierSize) maxFrontierSize = currentFrontierSize;
            }
        }
        return null;
    }
    public int maxFrontierSize() {
        return maxFrontierSize;
    }
}
