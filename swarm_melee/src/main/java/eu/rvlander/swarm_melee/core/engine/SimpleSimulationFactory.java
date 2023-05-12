package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.SimpleWord;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.utils.Point;

public class SimpleSimulationFactory implements SimulationFactory {

  @Override
  public World createWorld() {
    return new SimpleWord();
  }

  @Override
  public PositionsRanker createPositionsRanker(Map map, Point initialTarget) {
    return new NoObstaclesRanker();
  }

  @Override
  public PositionsGenerator createPositionsGenerator(Map map) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'createPositionsGenerator'");
  }

}
