package eu.rvlander.swarm_melee.core.model;

public interface Map {
    public Point getBottomLeft();
    public Point getTopRight();
    public boolean isInside(Point point);
    public ObstacleType get(Point point);
}
