package search;

public class TreeSearch implements Search {
  private Frontier frontier;
  public TreeSearch(Frontier fr) {
    frontier = fr;
  }
  public Node findSolution(Node root, GoalTest goalTest) {
    frontier.add(root);
    while (!frontier.isEmpty()) {
      Node node = frontier.remove();
      if(goalTest.isGoal(node.state)) return node;
      else {
        for (Action action : node.state.getApplicableActions()) {
          frontier.add(new Node(node, action, node.state.getActionResult(action)));
        }
      }
    }
    return null;
  }
}
