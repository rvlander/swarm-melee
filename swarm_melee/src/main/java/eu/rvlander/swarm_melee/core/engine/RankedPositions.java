package eu.rvlander.swarm_melee.core.engine;

import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Point;

public class RankedPositions {
    private PositionsList rankedPossiblePositions = new PositionsList();
    
    public Iterator<Point> iterator() {
        return rankedPossiblePositions.iterator();
    }
}
