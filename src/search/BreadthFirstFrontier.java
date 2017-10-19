package search;

import java.util.*;
public class BreadthFirstFrontier implements Frontier{
  Queue<Node> queue = new LinkedList<Node>();
  
  public void add(Node node) {
	  queue.add(node);
  }
  
  public void clear() {
    queue.clear();
  }
  
  public boolean isEmpty() {
    return queue.isEmpty();
  }
  
  public Node remove() {
    if(isEmpty()) {
      return queue.remove();
    }
    else throw new java.lang.Error("The frontier is empty");
  }
}
