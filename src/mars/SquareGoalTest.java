package mars;

import search.GoalTest;
import search.State;

public class SquareGoalTest implements GoalTest {
  public boolean isGoal(State state) {
    return true;
  }
}
