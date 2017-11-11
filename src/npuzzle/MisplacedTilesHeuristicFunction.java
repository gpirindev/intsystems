package npuzzle;

import search.Node;
import search.NodeFunction;

public class MisplacedTilesHeuristicFunction implements NodeFunction {
    public int evaluate(Node node) {
        int[] tiles = ((Tiles)node.state).tiles;
        int width = ((Tiles)node.state).width;
        int diff = 0;
        for (int row = 0; row < width; row++)
            for (int column = 0; column < width; column++) {
                if ( tiles[row*width + column] != row*width + column + 1) diff++;
            }
        return diff;
    }
}
