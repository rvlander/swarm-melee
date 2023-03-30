package eu.rvlander.swarm_melee.core.model;

public interface Fighter {
    public Point getPosition();
    public void movePosition(Movement mov);
    public void decreaseHealth();
    public void increaseHealth();
    public Team getTeam();
    public void setTeam(Team team); 
}
