package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public class SimpleFighter extends Fighter {
  private Point position;
  private Team team;
  private int health = MAX_HEALTH;

  private static final int MAX_HEALTH = 100;
  private static final int HEAL_POINTS = 5;
  private static final int HIT_POINTS = 5;

  public SimpleFighter(Team team, Point startingPoint) {
    position = startingPoint;
    this.team = team;
  }

  @Override
  public Point getPosition() {
    return position;
  }

  @Override
  public void move(Movement mov) {
    position = position.move(mov.getDeltaX(), mov.getDeltaY());
  }

  @Override
  public Team getTeam() {
    return team;
  }

  @Override
  public void moveTo(Point target) {
    position = new Point(target);
  }

  @Override
  public void decreaseHealth(Team attackerTeam) {
    health = Math.max(0, health - HIT_POINTS);
    if (health == 0) {
      health = 100;
      setTeam(attackerTeam);
    }
  }

  @Override
  public void increaseHealth() {
    health = Math.min(MAX_HEALTH, health + HEAL_POINTS);
  }

  @Override
  public float getHealthProportion() {
    return (float) health / (float) MAX_HEALTH;
  }

  @Override
  public void setTeam(Team team) {
    this.team = team;
  }
}
