package search;

import java.util.PriorityQueue;
import java.util.Queue;

public class BestFirstFrontier implements Frontier{
    private Queue<Node> queue = new PriorityQueue<>((Node n1, Node n2) -> (n1.value - n2.value));
    private int maxNumberOfNodes = 0;
    private NodeFunction evaluator;
    public BestFirstFrontier(NodeFunction evaluator) {
        this.evaluator = evaluator;
    }

    public void add(Node node) {
        node.value = evaluator.evaluate(node);
        queue.add(node);
        if(queue.size() > maxNumberOfNodes) maxNumberOfNodes = queue.size();
    }

    public void clear() {
        queue.clear();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public Node remove() {
        if(!isEmpty()) {
            return queue.remove();
        }
        else throw new java.lang.Error("The frontier is empty");
    }

    public int maxNumberOfNodes() {
        return maxNumberOfNodes;
    }
}
