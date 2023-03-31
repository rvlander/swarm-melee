package eu.rvlander.swarm_melee.core.engine;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;

public class PositionsList {
    private ArrayList<Point> positions = new ArrayList<>();

    public void addPosition(Point point) {
        positions.add(point);
    }

    public Iterator<Point> iterator() {
        return positions.iterator();
    }
}
