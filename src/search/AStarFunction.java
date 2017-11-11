package search;

public class AStarFunction implements NodeFunction{
    private NodeFunction heuristicFunction;
    public AStarFunction(NodeFunction heuristicFunction){
        this.heuristicFunction = heuristicFunction;
    }
    public int evaluate(Node node) {
        return node.pathCost = heuristicFunction.evaluate(node);
    }
}
