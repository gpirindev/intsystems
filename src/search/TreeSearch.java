package search;

public class TreeSearch implements Search {
  private Frontier frontier;
  private int nodesGenerated = 0;
  public TreeSearch(Frontier fr) {
    frontier = fr;
  }
  public Node findSolution(Node root, GoalTest goalTest) {
    nodesGenerated = 1;
    frontier.add(root);
    while (!frontier.isEmpty()) {
      Node node = frontier.remove();
      if(goalTest.isGoal(node.state)) return node;
      else {
        for (Action action : node.state.getApplicableActions()) {
          nodesGenerated += 1;
          frontier.add(new Node(node, action, node.state.getActionResult(action)));
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
