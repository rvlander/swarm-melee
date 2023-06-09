package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public class SimpleCursor implements Cursor {
  private Point position;
  private Team team;

  public SimpleCursor(Team team, Point startingPosition) {
    position = startingPosition;
    this.team = team;
  }

  @Override
  public Point getPosition() {
    return position;
  }

  @Override
  public void moveTo(Point p) {
    position = p;
  }

  @Override
  public Team getTeam() {
    return team;
  }

}


