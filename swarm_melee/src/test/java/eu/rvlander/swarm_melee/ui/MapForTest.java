package eu.rvlander.swarm_melee.ui;

import java.util.Iterator;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.NeighborhoodType;
import eu.rvlander.swarm_melee.utils.Pair;
import eu.rvlander.swarm_melee.utils.Point;

public class MapForTest implements Map {

    @Override
    public Point getBottomLeft() {
        return new Point(0, 600);
    }

    @Override
    public Point getTopRight() {
        return new Point(800, 0);
    }

    @Override
    public NeighborhoodType get(Point point) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public Iterator<Pair<Point, NeighborhoodType>> iterator() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'iterator'");
    }
    
}
