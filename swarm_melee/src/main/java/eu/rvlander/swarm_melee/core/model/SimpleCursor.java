package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public class SimpleCursor implements Cursor {
  private Point position;
  private Team team;

  public SimpleCursor(Point startingPosition, Team team) {
    position = startingPosition;
    this.team = team;
  }

  @Override
  public Point getPosition() {
    return position;
  }

  @Override
  public void movePosition(Movement mov) {
    position.move(mov.getDeltaX(), mov.getDeltaY());
  }

  @Override
  public Team getTeam() {
    return team;
  }

}
