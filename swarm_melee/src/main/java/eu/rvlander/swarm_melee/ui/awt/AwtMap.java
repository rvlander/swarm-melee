package eu.rvlander.swarm_melee.ui.awt;

import java.util.Iterator;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.NeighborhoodType;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.utils.Pair;

public class AwtMap implements Map {

    private final int widht;
    private final int height;

    public AwtMap(final int w, final int h) {
        this.widht = w;
        this.height = h;
    }

    @Override
    public Point getBottomLeft() {
        return new Point(0, this.height);
    }

    @Override
    public Point getTopRight() {
        return new Point(this.widht, 0);
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
