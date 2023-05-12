package eu.rvlander.swarm_melee.utils;

import java.util.ArrayList;
import java.util.Iterator;
import javax.management.AttributeList;

public class Grid<T> {
  private final int width;
  private final int height;
  private ArrayList<T> map;

  public Grid(int width, int height, Instantiator<T> instantiator) {
    this.width = width;
    this.height = height;
    initializeGrid(instantiator);
  }

  public void initializeGrid(Instantiator<T> instantiator) {
    map = new ArrayList<>(width * height);
    for (int i = 0; i < width * height; i++) {
      map.add(instantiator.instantiate());
    }
  }

  public T get(Point point) {
    assert isInBounds(point);
    int index = pointToIndex(point);
    return map.get(index);
  }

  public boolean isInBounds(Point point) {
    return !(point.getX() < 0 || point.getX() >= width || point.getY() < 0
        || point.getY() >= height);
  }

  private int pointToIndex(Point p) {
    return p.getY() * width + p.getX();
  }

  private Point indexToPoint(int index) {
    assert index >= 0 && index < map.size();
    return new Point(index % width, index / width);
  }

  public Iterator<Pair<Point, T>> iterator() {
    return new GridIterator();
  }

  private class GridIterator implements Iterator<Pair<Point, T>> {
    private int index = 0;

    @Override
    public boolean hasNext() {
      return index < map.size();
    }

    @Override
    public Pair<Point, T> next() {
      Point p = indexToPoint(index);
      T neighborhoodType = map.get(index);
      index++;
      return new Pair<>(p, neighborhoodType);
    }

  }

}
