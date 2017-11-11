package tour;

import search.AStarFunction;
import search.BestFirstFrontier;
import search.BreadthFirstFrontier;
import search.GoalTest;
import search.GraphSearch;
import search.Node;
import search.Printing;
import search.Search;
import search.TreeSearch;

public class BFTS_Demo {
	public static void main(String[] args) {
		System.out.println("This is a demonstration of search on Romania tour");
		System.out.println();
		
		Cities romania = SetUpRomania.getRomaniaMap();
		City startCity = romania.getState("Bucharest");
		
		GoalTest goalTest = new TourGoalTest(romania.getAllCities(), startCity);
		
		Node root = new Node(null, null, new TourState(startCity));
    Printing printing = new TourPrinting();
    Search ASGS = new GraphSearch(new BestFirstFrontier(new AStarFunction(new FurthestCityHeuristicFunction(romania, startCity))));
    Search ASTS = new TreeSearch(new BestFirstFrontier(new AStarFunction(new FurthestCityHeuristicFunction(romania, startCity))));
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
