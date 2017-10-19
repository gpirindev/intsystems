package search;

import java.util.*;
public class DepthFirstFrontier implements Frontier {
  Stack<Node> stack = new Stack<Node>();
  
  public void add(Node node) {
    stack.push(node);
  }
  
  public void clear() {
    stack.clear();
  }
  
  public boolean isEmpty() {
    return stack.isEmpty();
  }
  
  public Node remove() {
    if(isEmpty()) {
      return stack.pop();
    }
    else throw new java.lang.Error("The frontier is empty");
  }
}
