package eu.rvlander.swarm_melee.core.engine;

import java.util.HashMap;
import java.util.Map;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.utils.Point;

public class Simulation {
    private final SimulationFactory factory;
    private World world;
    private Map<Cursor, PositionsRanker> positionsRankers;
    private PositionsGenerator positionsGenerator;

    public Simulation(SimulationFactory simulationFactory) {
        this.factory = simulationFactory;
        reinitialize();
    }

    public void reinitialize() {
        world = factory.createWorld();
        positionsGenerator = factory.createPositionsGenerator();
        initializePositionsRankers();
    }

    private void initializePositionsRankers() {
        positionsRankers = new HashMap<>();
        for(Cursor cursor: world.getCursors()){
            PositionsRanker positionRanker = factory.createPositionsRanker(
                world.getMap(), cursor.getPosition());
            positionsRankers.put(cursor, positionRanker);
        }
    }

    public void runStep() {
        for(Fighter fighter: world.getFighters()) {
            Team team = fighter.getTeam();
            Cursor cursor = world.getCursor(team);
            Point fighterPosition = fighter.getPosition();
            Point cursorPosition = cursor.getPosition();
            
            PositionsList possiblePositions = positionsGenerator.generatePossiblePositions(fighterPosition);
            PositionsRanker positionRanker = positionsRankers.get(cursor);
            RankedPositions rankedPositions = positionRanker.rank(fighterPosition, cursorPosition, possiblePositions);
       
            Point pickedPosition = pickMove(fighter, rankedPositions);
            makeMove(fighter, pickedPosition);
        }
        
    }

    private Point pickMove(Fighter f, RankedPositions rankedPositions) {
        // TODO
        throw new UnsupportedOperationException("Unimplemented method 'rank'");
    }

    private void makeMove(Fighter fighter, Point target) {
        PositionLookup lookup = this.world.lookupPosition(target);
        switch (lookup.type) {
            case EMPTY:
                fighter.moveTo(target);
                break;
            case FIGHTER:
                handleFighterInteraction(fighter, lookup.getFighter());
                break;
            default:
                break;
        }
    }

    private void handleFighterInteraction(Fighter movingfighter, Fighter standingFighter) {
    }
}
