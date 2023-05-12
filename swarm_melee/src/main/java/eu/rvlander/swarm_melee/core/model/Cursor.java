package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public interface Cursor {
  public Point getPosition();

  public void movePosition(Movement mov);

  public Team getTeam();
}
