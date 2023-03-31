package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

public interface Fighter {
    public Point getPosition();
    public void move(Movement mov);
    public void moveTo(Point target);
    public void decreaseHealth();
    public void increaseHealth();
    public Team getTeam();
    public void setTeam(Team team); 
}
