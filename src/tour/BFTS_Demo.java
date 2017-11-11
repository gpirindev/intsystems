package tour;

import search.BreadthFirstFrontier;
import search.DepthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.IterativeDeepeningTreeSearch;
import search.Node;
import search.Printing;
import search.Search;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of breadth-first tree search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Node root = new Node(null, null, new TourState(startCity), 0);
    Printing printing = new TourPrinting();
    Search BFTS = new TreeSearch(new BreadthFirstFrontier());
    Search BFGS = new GraphSearch(new BreadthFirstFrontier());
    Search DFTS = new TreeSearch(new DepthFirstFrontier());
    Search DFGS = new GraphSearch(new DepthFirstFrontier());
    Search IDTS = new IterativeDeepeningTreeSearch(1);
    Node solution = BFTS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in BFTS is " + BFTS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in BFTS is " + BFTS.nodesGenerated());
    System.out.println("");
    solution = BFGS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in BFGS is " + BFGS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in BFGS is " + BFGS.nodesGenerated());
    System.out.println("");
    solution = IDTS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in IDTS is " + IDTS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in IDTS is " + IDTS.nodesGenerated());
    System.out.println("");
    solution = DFGS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in DFGS is " + DFGS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in DFGS is " + DFGS.nodesGenerated());
    System.out.println("");
    solution = DFTS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in DFTS is " + DFTS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in DFTS is " + DFTS.nodesGenerated());
	}
}
