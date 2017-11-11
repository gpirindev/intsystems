package tour;

import search.NodeFunction;
import java.util.Set;
import search.Node;

public class FurthestCityHeuristicFunction implements NodeFunction {
  private Cities cities;
  private City goalCity;
  public FurthestCityHeuristicFunction(Cities cities, City goalCity) {
    this.cities = cities;
    this.goalCity = goalCity;
  }
  public int evaluate(Node node) {
    TourState state = (TourState)node.state;
    City furthest = findFurthestCity(state.currentCity, state.visitedCities);
    return state.currentCity.getShortestDistanceTo(furthest) + furthest.getShortestDistanceTo(goalCity);
  }
  private City findFurthestCity(City currentCity, Set<City> visitedCities) {
    Set<City> allCities = cities.getAllCities();
    for (City city: visitedCities) {
      allCities.remove(city);
    }
    City furthest = currentCity;
    int shortestDist = 0;
    for (City city: allCities) {
      if(currentCity.getShortestDistanceTo(city) > shortestDist) {
        furthest = city;
        shortestDist = currentCity.getShortestDistanceTo(city);
      }
    }
    return furthest;
  }
}
