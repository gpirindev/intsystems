package search;

public class Node {
	public final Node parent;
	public final Action action;
	public final State state;
	public int depth;
	public int value;
	public int pathCost;
	
	/*public Node(Node parent, Action action, State state, int depth) {
		this.parent = parent;
		this.action = action;
		this.state = state;
		this.depth = depth;
	}*/
	public Node(Node parent, Action action, State state) {
    this.parent = parent;
    this.action = action;
    this.state = state;
    if (parent == null) this.pathCost = 0;
    else this.pathCost = parent.pathCost + action.cost();
    }
}
