package mars;

import search.*;

public class MarsDemo {
  public static void main(String[] args) {
    Planet planet = new Planet();
    GoalTest goalTest = new SquareGoalTest();
    State initialState = new ExplorationState(new Square(4, 4), planet);
    Node root = new Node(null, null, initialState);
    Search search = new MaxStatesFixedDepthTreeSearch(20);
    Node solution = search.findSolution(root, goalTest);
    int numOfSquares = ((ExplorationState)(solution.state)).size();
    System.out.println("The max number of squares is " + numOfSquares);
    System.out.println("The maximum number of nodes stored in ASTS is " + search.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in ASTS is " + search.nodesGenerated());
    System.out.println("");
  }
}
