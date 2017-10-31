package npuzzle;

import search.BreadthFirstFrontier;
//import search.BreadthFirstTreeSearch;
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
		System.out.println("This is a demonstration of search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		Node root = new Node(null, null, initialConfiguration, 0);
		GoalTest goalTest = new TilesGoalTest();
		Printing printing = new NPuzzlePrinting();
		Search BFTS = new TreeSearch(new BreadthFirstFrontier());
    Search BFGS = new GraphSearch(new BreadthFirstFrontier());
    Search DFTS = new TreeSearch(new DepthFirstFrontier());
    Search DFGS = new GraphSearch(new DepthFirstFrontier());
    Search IDTS = new IterativeDeepeningTreeSearch(5);
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
    /*solution = DFGS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in DFGS is " + DFGS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in DFGS is " + DFGS.nodesGenerated());
    System.out.println("");*/
    /*solution = DFTS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in DFTS is " + DFTS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in DFTS is " + DFTS.nodesGenerated());*/
	}
}
