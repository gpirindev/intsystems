package search;

import java.util.*;
public class BreadthFirstFrontier implements Frontier{
  private Queue<Node> queue = new LinkedList<Node>();
  private int maxNumberOfNodes = 0;
  
  public void add(Node node) {
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
