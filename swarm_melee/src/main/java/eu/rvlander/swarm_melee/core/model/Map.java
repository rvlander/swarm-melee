package eu.rvlander.swarm_melee.core.model;

public interface Map {
    public Point getBottomLeft();
    public Point getTopRight();
    public NeighborhoodType get(Point point);
    Iterator<NeighborhoodType> iterator();
}
