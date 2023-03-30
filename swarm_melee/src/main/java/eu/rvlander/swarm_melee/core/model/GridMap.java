package eu.rvlander.swarm_melee.core.model;

import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Pair;

public class GridMap implements Map {
    private final int width;
    private final int height;
    private NeighborhoodType[] map;

    public GridMap(int width, int height) {
        this.width = width;
        this.height = height; 
        initializeMap();
    }

    private void initializeMap() {
        map = new NeighborhoodType[width*height];
        for(int i = 0; i < map.length; i++) {
            map[i] = NeighborhoodType.NONE;
        }
    }

    @Override
    public NeighborhoodType get(Point point) {
        if(isInBounds(point)) {
            return NeighborhoodType.OUTSIDE;
        } else {
            int index = pointToIndex(point);
            return map[index];
        }
    }

    private boolean isInBounds(Point point) {
        return point.getX() < 0 || point.getX() >=width || point.getY() < 0 || point.getY()  >= height;
    }

    private int pointToIndex(Point p) {
        return p.getY() * width + p.getX();
    }

    private Point indexToPoint(int index) {
        assert  index >=0 && index < map.length;
        return new Point(index % width, index / width);
    }

    @Override
    public Point getBottomLeft() {
        return new Point(0, 0);
    }

    @Override
    public Point getTopRight() {
        return new Point(width, height);
    }

    @Override
    public Iterator<Pair<Point, NeighborhoodType>> iterator() {
        return new GridMapIterator();
    }

    private class GridMapIterator implements Iterator<Pair<Point, NeighborhoodType>> {
        private int index = 0; 

        @Override
        public boolean hasNext() {
            return index < map.length;
        }

        @Override
        public Pair<Point, NeighborhoodType> next() {
            Point p = indexToPoint(index);
            NeighborhoodType neighborhoodType = map[index];
            index ++;
            return new Pair<>(p, neighborhoodType);             
        }

    }
    
}
