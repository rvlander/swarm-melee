package eu.rvlander.swarm_melee.core.model;

public interface Cursor {
    public Point getPosition();
    public void movePosition(Movement mov);
}
