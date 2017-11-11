package tour;

import search.NodeFunction;
import java.util.Set;
import search.Node;

public class FurthestCityHeuristicFunction implements NodeFunction {
  public int evaluate(Node node) {
    TourState state = (TourState)node.state;
    return 0;
  }
  
  /*private City findFurthestCity(City currentCity, Set<City> visitedCities) {
    
  }*/
}
