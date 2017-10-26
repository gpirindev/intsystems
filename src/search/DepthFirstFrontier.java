package search;

import java.util.*;
public class DepthFirstFrontier implements Frontier {
  private Stack<Node> stack = new Stack<Node>();
  private int maxNumberOfNodes = 0;
  
  public void add(Node node) {
    stack.push(node);
    if(stack.size() > maxNumberOfNodes) maxNumberOfNodes = stack.size();
  }
  
  public void clear() {
    stack.clear();
  }
  
  public boolean isEmpty() {
    return stack.isEmpty();
  }
  
  public Node remove() {
    if(!isEmpty()) {
      return stack.pop();
    }
    else throw new java.lang.Error("The frontier is empty");
  }
  
  public int maxNumberOfNodes() {
    return maxNumberOfNodes;
  }
}
