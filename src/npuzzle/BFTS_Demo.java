package npuzzle;

import search.*;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of search on 8-puzzle");
		System.out.println();
		
		Tiles initialConfiguration = new Tiles(new int[][] {
			{ 7, 4, 2 },
			{ 8, 1, 3 },
			{ 5, 0, 6 }
		});
		Node root = new Node(null, null, initialConfiguration);
		GoalTest goalTest = new TilesGoalTest();
		Printing printing = new NPuzzlePrinting();
		Search ASTS = new TreeSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));
    Search ASGS = new GraphSearch(new BestFirstFrontier(new AStarFunction(new MisplacedTilesHeuristicFunction())));
    Node solution = ASTS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in ASTS is " + ASTS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in ASTS is " + ASTS.nodesGenerated());
    System.out.println("");
    solution = ASGS.findSolution(root, goalTest);
    printing.printSolution(solution);
    System.out.println("The maximum number of nodes stored in ASGS is " + ASGS.maxNumberOfNodes());
    System.out.println("The total number of nodes generated in ASGS is " + ASGS.nodesGenerated());
    System.out.println("");
	}
}
