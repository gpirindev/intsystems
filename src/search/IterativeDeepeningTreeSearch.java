package search;

public class IterativeDeepeningTreeSearch implements Search {
  private DepthFirstFrontier frontier = new DepthFirstFrontier();
  private int nodesGenerated = 0;
  private int depth;
  public IterativeDeepeningTreeSearch(int depth) {
    this.depth = depth;
  }
  public Node findSolution(Node root, GoalTest goalTest) {
    nodesGenerated = 1;
    int maxDepth = depth;
    while(true) {
      frontier.add(root);
      while (!frontier.isEmpty()) {
        Node node = frontier.remove();
        if(goalTest.isGoal(node.state)) return node;
        else if(node.depth < maxDepth){
          for (Action action : node.state.getApplicableActions()) {
            nodesGenerated += 1;
            frontier.add(new Node(node, action, node.state.getActionResult(action), node.depth + 1));
          }
        }
      }
      frontier.clear();
      maxDepth += depth;
    }
  }
  public int nodesGenerated() {
    return nodesGenerated;
  }
  public int maxNumberOfNodes() {
    return frontier.maxNumberOfNodes();
  }
}
