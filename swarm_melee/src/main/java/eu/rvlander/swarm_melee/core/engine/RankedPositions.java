package eu.rvlander.swarm_melee.core.engine;

import java.util.Iterator;

import eu.rvlander.swarm_melee.utils.Point;

public class RankedPositions {
    private PositionsList rankedPossiblePositions = new PositionsList();

    private RankedPositions(PositionsList list) {
        rankedPossiblePositions = list;
    }
    
    public Iterator<Point> iterator() {
        return rankedPossiblePositions.iterator();
    }

    public static RankedPositions from(Iterator<Point> sortedPointIterator) {
        return new RankedPositions(PositionsList.from(sortedPointIterator));
    }
}
