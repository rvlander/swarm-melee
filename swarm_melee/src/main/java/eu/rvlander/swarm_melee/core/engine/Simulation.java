package eu.rvlander.swarm_melee.core.engine;

import java.util.HashMap;
import java.util.Map;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.Point;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;

public class Simulation {
    public final SimulationFactory factory;
    public World world;
    public Map<Cursor, ShortestPathCalculator> movementCalculators;

    public Simulation(SimulationFactory simulationFactory) {
        this.factory = simulationFactory;
        reinitialize();
    }

    public void reinitialize() {
        world = factory.createWorld();
        initializeMovementCalculators();
    }

    private void initializeMovementCalculators() {
        movementCalculators = new HashMap<>();
        for(Cursor cursor: world.getCursors()){
            ShortestPathCalculator movementCalculator = factory.createFighterMovementCalculator(
                world.getMap(), cursor.getPosition());
            movementCalculators.put(cursor, movementCalculator);
        }
    }

    public void runStep() {
        for(Fighter fighter: world.getFighters()) {
            Team team = fighter.getTeam();
            Cursor cursor = world.getCursor(team);
            Point fighterPosition = fighter.getPosition();
            ShortestPathCalculator movementCalculator = movementCalculators.get(cursor);
            Movement proposedMovement = movementCalculator.computeMovement(fighterPosition, cursor.getPosition());
            Point prospectivePosition = proposedMovement.applyTo(fighterPosition);

            // CONTINUE HERE
        }
        
    }
}
