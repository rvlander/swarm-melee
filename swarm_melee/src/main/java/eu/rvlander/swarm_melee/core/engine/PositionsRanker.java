package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.utils.Point;

public interface PositionsRanker {
  public RankedPositions rank(Point origin, Point target, PositionsList possiblePositions);
}
