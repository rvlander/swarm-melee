package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.Point;

public interface ShortestPathCalculator {
    public Movement computeMovement(Point origin, Point target);
}
