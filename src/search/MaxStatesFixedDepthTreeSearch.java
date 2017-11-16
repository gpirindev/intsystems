package search;

import mars.ExplorationState;

public class MaxStatesFixedDepthTreeSearch implements Search {
  private DepthFirstFrontier frontier = new DepthFirstFrontier();
  private int nodesGenerated = 0;
  private int maxDepth;
  private int maxStates = 1;
  private Node optimal;
  public MaxStatesFixedDepthTreeSearch(int maxDepth) {
    this.maxDepth = maxDepth;
  }
  public Node findSolution(Node root, GoalTest goalTest) {
    nodesGenerated = 1;
    optimal = root;    
    frontier.add(root);
    while (!frontier.isEmpty()) {
      Node node = frontier.remove();
      ExplorationState state = (ExplorationState)(node.state);
      if(state.size() > maxStates) {
        maxStates = state.size();
        optimal = node;
      }
      else if(node.pathCost < maxDepth){
        for (Action action : state.getApplicableActions()) {
          nodesGenerated += 1;
          frontier.add(new Node(node, action, node.state.getActionResult(action)));
        }
      }
    }
    return optimal;
  }
  public int nodesGenerated() {
    return nodesGenerated;
  }
  public int maxNumberOfNodes() {
    return frontier.maxNumberOfNodes();
  }
}
