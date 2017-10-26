package search;

import java.util.HashSet;
import java.util.Set;

public class GraphSearch implements Search{
    private Frontier frontier;
    private int nodesGenerated = 0;
    public GraphSearch(Frontier fr) {
        frontier = fr;
    }
    public Node findSolution(Node root, GoalTest goalTest) {
        nodesGenerated = 1;
        Set<State> exploredStates = new HashSet<State>();
        frontier.add(root);
        exploredStates.add(root.state);
        while (!frontier.isEmpty()) {
            Node node = frontier.remove();
            if(goalTest.isGoal(node.state)) return node;
            else {
                for (Action action : node.state.getApplicableActions()) {
                    State newState = node.state.getActionResult(action);
                    if (!exploredStates.contains(newState)) {
                        exploredStates.add(newState);
                        nodesGenerated += 1;
                        frontier.add(new Node(node, action, newState));
                    }
                }
            }
        }
        return null;
    }
    public int nodesGenerated() {
        return nodesGenerated;
    }
    public int maxNumberOfNodes() {
      return frontier.maxNumberOfNodes();
    }
}
