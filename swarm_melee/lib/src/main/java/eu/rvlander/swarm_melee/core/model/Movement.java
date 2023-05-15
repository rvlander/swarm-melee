package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public class Movement {
  private int deltaX;
  private int deltaY;

  public Movement(int deltaX, int deltaY) {
    this.deltaX = deltaX;
    this.deltaY = deltaY;
  }

  public int getDeltaX() {
    return deltaX;
  }

  public int getDeltaY() {
    return deltaY;
  }

  public Point applyTo(Point point) {
    return point.move(deltaX, deltaY);
  }
}
