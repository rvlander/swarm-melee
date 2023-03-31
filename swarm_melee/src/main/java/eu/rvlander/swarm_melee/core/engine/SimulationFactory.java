package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.core.model.World;

public interface SimulationFactory {
    public World createWorld();
    public ShortestPathCalculator createFighterMovementCalculator(Map map, Point initialTarget);
}
