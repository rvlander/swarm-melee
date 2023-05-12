package eu.rvlander.swarm_melee.core.engine;

import java.awt.Point;
import com.sun.tools.javac.util.List;

public class PositionPicker {
  private List<Point> availablePositions = ArrayList<>();

  public PositionPicker(int width, int height) {
    populateAvailablePositions(width, height);
  }

  private void populateAvailablePositions(int width, int height) {
    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        availablePositions.add(new Point(x, y));
      }
    }
  }

  private Point pick() {
    int randIndex = (int) ((Math.random() * availablePositions.size()));
    return availablePositions.remove(randIndex);
  }
}
