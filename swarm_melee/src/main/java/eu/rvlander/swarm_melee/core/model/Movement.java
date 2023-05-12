package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public interface Movement {
  public Movement createMovement(int x, int y);

  public int getDeltaX();

  public int getDeltaY();

  public Point applyTo(Point point);
}
