package eu.rvlander.swarm_melee.core.model;

public interface Fighter {
    public Point getPosition();
    public void move(Movement mov);
    public void decreaseHealth();
    public void increaseHealth();
    public Team getTeam();
    public void setTeam(Team team); 
}
