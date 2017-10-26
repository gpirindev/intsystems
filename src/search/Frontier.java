package search;

public interface Frontier {
  void add(Node node);
  void clear();
  boolean isEmpty();
  Node remove();
  int maxNumberOfNodes();
}
