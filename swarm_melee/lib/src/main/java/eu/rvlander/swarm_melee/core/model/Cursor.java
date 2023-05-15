package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public interface Cursor {
  public Point getPosition();

  public void moveTo(Point p);

  public Team getTeam();
}
