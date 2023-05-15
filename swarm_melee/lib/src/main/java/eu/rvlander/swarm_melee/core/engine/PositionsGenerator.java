package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.utils.Point;

public interface PositionsGenerator {
  public PositionsList generatePossiblePositions(Point origin);
}
