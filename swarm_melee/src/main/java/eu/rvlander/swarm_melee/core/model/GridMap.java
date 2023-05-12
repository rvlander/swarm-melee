package eu.rvlander.swarm_melee.core.model;

import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Grid;
import eu.rvlander.swarm_melee.utils.Pair;
import eu.rvlander.swarm_melee.utils.Point;

public class GridMap implements Map {
  private final int width;
  private final int height;
  private Grid<NeighborhoodType> map;

  public GridMap(int width, int height) {
    this.width = width;
    this.height = height;
    this.map = new Grid<>(width, height);
  }

  @Override
  public NeighborhoodType get(Point point) {
    if (!this.map.isInBounds(point)) {
      return NeighborhoodType.OUTSIDE;
    } else {
      return this.map.get(point);
    }
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
    return this.map.iterator();
  }

  @Override
  public int getWidth() {
    return width;
  }

  @Override
  public int getHeight() {
    return height;
  }
}
