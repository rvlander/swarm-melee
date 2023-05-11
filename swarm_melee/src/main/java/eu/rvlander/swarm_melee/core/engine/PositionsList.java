package eu.rvlander.swarm_melee.core.engine;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import eu.rvlander.swarm_melee.utils.Point;

public class PositionsList {
    private ArrayList<Point> positions = new ArrayList<>();

    public void addPosition(Point point) {
        positions.add(point);
    }

    public Iterator<Point> iterator() {
        return positions.iterator();
    }

    public List<Point> asList() {
        return (List<Point>)positions.clone();
    }

    public static PositionsList from(Iterator<Point> pointsIterator) {
        PositionsList list = new PositionsList();

        while(pointsIterator.hasNext()) {
            list.addPosition(pointsIterator.next());
        ;}

        return list;
    }
}
