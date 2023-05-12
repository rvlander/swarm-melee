package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public abstract class Fighter {
  public abstract Point getPosition();

  public abstract void move(Movement mov);

  public abstract void moveTo(Point target);

  public abstract void decreaseHealth();

  public abstract void increaseHealth();

  public abstract Team getTeam();

  public abstract void setTeam(Team team);

  public boolean isOpponentOf(Fighter f) {
    return this.getTeam() != f.getTeam();
  }

  public boolean isTeammateOf(Fighter f) {
    return this.getTeam() == f.getTeam();
  }
}
