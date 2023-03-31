package eu.rvlander.swarm_melee.core.model;

public interface Movement {
    public Movement createMovement(int x, int y);

    public int getDeltaX(); 
    public int getDeltaY();
    public Point applyTo(Point point);
}
