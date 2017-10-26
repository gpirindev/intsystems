package search;

public interface Search {
  Node findSolution(Node root, GoalTest goalTest);
  int nodesGenerated();
  int maxNumberOfNodes();
}
