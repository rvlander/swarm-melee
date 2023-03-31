package eu.rvlander.swarm_melee.utils;

import java.util.Iterator;

public class Grid<T> {
    private final int width;
    private final int height;
    private T[] map;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height; 
        // initializeGrid();
    }

    // public void initializeGrid(()->T creator) {
    //     map = (T[])new Object[width*height];
    //     for(int i = 0; i < map.length; i++) {
    //         map[i] = creator();
    //     }
    // }

    public T get(Point point) {
        assert isInBounds(point);
        int index = pointToIndex(point);
        return map[index];
    }

    public boolean isInBounds(Point point) {
        return point.getX() < 0 || point.getX() >=width || point.getY() < 0 || point.getY()  >= height;
    }

    private int pointToIndex(Point p) {
        return p.getY() * width + p.getX();
    }

    private Point indexToPoint(int index) {
        assert  index >=0 && index < map.length;
        return new Point(index % width, index / width);
    }

    public Iterator<Pair<Point, T>> iterator() {
        return new GridIterator();
    }

    private class GridIterator implements Iterator<Pair<Point, T>> {
        private int index = 0; 

        @Override
        public boolean hasNext() {
            return index < map.length;
        }

        @Override
        public Pair<Point, T> next() {
            Point p = indexToPoint(index);
            T neighborhoodType = map[index];
            index ++;
            return new Pair<>(p, neighborhoodType);             
        }

    }
    
}