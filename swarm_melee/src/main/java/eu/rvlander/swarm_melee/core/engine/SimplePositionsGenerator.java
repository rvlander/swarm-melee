package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.NeighborhoodType;
import eu.rvlander.swarm_melee.utils.Point;

public class SimplePositionsGenerator implements PositionsGenerator {
    public Map map;

    public SimplePositionsGenerator(Map map) {
        this.map = map;
    }

    @Override
    public PositionsList generatePossiblePositions(Point origin) {
        PositionsList positions = new PositionsList();

        for(int i=-1; i <2;i++) {
            for(int j=-1; i<2; i++) {
                if(i !=0 || j!=0) {
                    Point p = origin.move(i, j);
                    NeighborhoodType type = map.get(p);
                    if(type == NeighborhoodType.NONE) {
                        positions.addPosition(p);
                    }
                }
            }
        }
        return positions;
    }
    
}
