package eu.rvlander.swarm_melee.core.model;

import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Pair;

public interface Map {
    public Point getBottomLeft();
    public Point getTopRight();
    public NeighborhoodType get(Point point);
    Iterator<Pair<Point, NeighborhoodType>> iterator();
}
