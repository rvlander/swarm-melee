package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.utils.Point;

public class LiquidWarShortestPathRanker implements PositionsRanker {
    private Map map;
    private Point target;
    private GridMap gradientGrid;

    public LiquidWarShortestPathRanker(Map map, Point initialTarget) {
        this.map = map;
        this.target = initialTarget;
        this.computeGradients();
    }

    private void computeGradientsForTarget(Point target) {
        if(!this.target.equals(target)) {
            this.target = target;
            computeGradients();
        }
    }

    private void computeGradients() {
    
    }


    @Override
    public RankedPositions rank(Point origin, Point target, PositionsList possiblePositions) {
        computeGradientsForTarget(target);
        return rankWithGradients(origin, possiblePositions);
    }

    private RankedPositions rankWithGradients(Point origin, PositionsList possiblePositions) {
        
    }
    
}
