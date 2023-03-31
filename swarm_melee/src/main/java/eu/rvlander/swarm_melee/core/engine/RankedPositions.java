package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.utils.Point;

public class RankedPositions {
    private Point mainPosition;
    private PositionsList goodPositions = new PositionsList();
    private PositionsList acceptablePositions = new PositionsList();
    private PositionsList mediocrePositions = new PositionsList();
}
