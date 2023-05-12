package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.utils.Point;

public interface SimulationFactory {
  public World createWorld(WorldConfiguration configuration);

  public PositionsRanker createPositionsRanker(Map map, Point initialTarget);

  public PositionsGenerator createPositionsGenerator(Map map);
}
