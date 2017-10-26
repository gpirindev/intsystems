package search;

public class TreeSearch implements Search {
  private Frontier frontier;
  private int maxFrontierSize = 0;
  public TreeSearch(Frontier fr) {
    frontier = fr;
  }
  public Node findSolution(Node root, GoalTest goalTest) {
    maxFrontierSize = 0;
    frontier.add(root);
    int currentFrontierSize = 1;
    while (!frontier.isEmpty()) {
      Node node = frontier.remove();
      currentFrontierSize -= 1;
      if(goalTest.isGoal(node.state)) return node;
      else {
        for (Action action : node.state.getApplicableActions()) {
          currentFrontierSize += 1;
          frontier.add(new Node(node, action, node.state.getActionResult(action)));
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
