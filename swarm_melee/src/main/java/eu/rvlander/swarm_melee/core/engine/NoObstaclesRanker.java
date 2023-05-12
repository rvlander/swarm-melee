package eu.rvlander.swarm_melee.core.engine;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import eu.rvlander.swarm_melee.utils.Point;

public class NoObstaclesRanker implements PositionsRanker {
  private class PointComparator implements Comparator<Point> {
    Point origin;

    public PointComparator(Point origin) {
      this.origin = origin;
    }

    public int compare(Point p1, Point p2) {
      float d1 = origin.distance(p1);
      float d2 = origin.distance(p2);

      return (int) (d1 - d2);
    }
  }


  @Override
  public RankedPositions rank(Point origin, Point target, PositionsList possiblePositions) {
    List<Point> list = possiblePositions.asList();
    Collections.sort(list, new PointComparator(target));

    return RankedPositions.from(list.iterator());
  }
}
