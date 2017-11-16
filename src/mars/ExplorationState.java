package mars;
import java.util.LinkedHashSet;
import java.util.Set;

import search.*;

public class ExplorationState implements State {
  private Square currentSquare;
  private Set<Square> visitedSquares;
  private Planet planet;
  
  public ExplorationState(Square currentSquare, Planet planet) {
    this.currentSquare = currentSquare;
    this.visitedSquares = new LinkedHashSet<Square>();
    visitedSquares.add(currentSquare);
    this.planet = planet;
  }
  
  public ExplorationState(Square currentSquare, Set<Square> visitedSquares, Planet planet) {
    this.currentSquare = currentSquare;
    this.visitedSquares = visitedSquares;
    this.planet = planet;
  }
  
  public Set<Action> getApplicableActions() {
    Set<Action> actions = new LinkedHashSet<Action>();
    for (Movement movement : Movement.values()) {
      int newRow = currentSquare.getRow() + movement.deltaRow;
      int newColumn = currentSquare.getColumn() + movement.deltaColumn;
      if (0 <= newRow && newRow < planet.height() && 0 <= newColumn & newColumn < planet.width() && planet.isAccessible(newRow, newColumn))
        actions.add(movement);
    }
    return actions;
  }
  
  public State getActionResult(Action action) {
    Movement movement=(Movement)action;
    int newRow = currentSquare.getRow() + movement.deltaRow;
    int newColumn = currentSquare.getColumn() + movement.deltaColumn;
    Square newSquare = new Square(newRow, newColumn);
    Set<Square> newVisitedSquares = new LinkedHashSet<Square>(visitedSquares);
    newVisitedSquares.add(newSquare);
    return new ExplorationState(newSquare, newVisitedSquares, planet);
  }
  
  public int size() {
    return this.visitedSquares.size();
  }
  
  @Override
  public boolean equals(Object that) {
    if (that instanceof ExplorationState) {
      // Ignore different planets as this will not be the case here
      return (this.currentSquare == ((ExplorationState)that).currentSquare
          && this.visitedSquares == ((ExplorationState)that).visitedSquares);
    }
    else return false;
  }
  public int hashCode() {
    return 31*(31 + this.currentSquare.hashCode()) + this.visitedSquares.hashCode();
  }
}
