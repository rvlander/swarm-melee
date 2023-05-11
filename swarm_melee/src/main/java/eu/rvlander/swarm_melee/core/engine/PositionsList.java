package eu.rvlander.swarm_melee.core.engine;

import java.util.ArrayList;
import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Point;

public class PositionsList {
    private ArrayList<Point> positions = new ArrayList<>();

    public void addPosition(Point point) {
        positions.add(point);
    }

    public Iterator<Point> iterator() {
        return positions.iterator();
    }
}
