package eu.rvlander.swarm_melee.core.engine;

import java.lang.module.Configuration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.Movement;
import eu.rvlander.swarm_melee.core.model.PositionLookup;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.core.model.PositionLookup.Type;
import eu.rvlander.swarm_melee.utils.Point;

public class Simulation implements SimulationCommandReceiver {
  public static final int GOOD_POSITION_CUT = 3;
  public static final int BAD_POSITION_CUT = 6;


  private final SimulationFactory factory;
  private World world;
  private Map<Cursor, PositionsRanker> positionsRankers;
  private PositionsGenerator positionsGenerator;
  private WorldConfiguration worldConfiguration;

  public Simulation(SimulationFactory simulationFactory, WorldConfiguration worldConfiguration) {
    this.factory = simulationFactory;
    reinitialize(worldConfiguration);
  }

  public void reinitialize(WorldConfiguration configuration) {
    this.worldConfiguration = configuration;
    world = factory.createWorld(configuration);
    positionsGenerator = factory.createPositionsGenerator(world.getMap());
    initializePositionsRankers();
  }

  private void initializePositionsRankers() {
    positionsRankers = new HashMap<>();
    for (Cursor cursor : world.getCursors()) {
      PositionsRanker positionRanker =
          factory.createPositionsRanker(world.getMap(), cursor.getPosition());
      positionsRankers.put(cursor, positionRanker);
    }
  }

  public void runStep() {
    for (Fighter fighter : world.getFighters()) {
      Team team = fighter.getTeam();
      Cursor cursor = world.getCursor(team);
      Point fighterPosition = fighter.getPosition();
      Point cursorPosition = cursor.getPosition();

      PositionsList possiblePositions =
          positionsGenerator.generatePossiblePositions(fighterPosition);
      PositionsRanker positionRanker = positionsRankers.get(cursor);
      RankedPositions rankedPositions =
          positionRanker.rank(fighterPosition, cursorPosition, possiblePositions);

      Optional<Point> pickedPosition = pickMove(fighter, rankedPositions);

      if (pickedPosition.isPresent()) {
        makeMove(fighter, pickedPosition.get());
      }
    }

  }

  private Optional<Point> pickMove(Fighter f, RankedPositions rankedPositions) {
    Iterator<Point> rankedPositionsIterator = rankedPositions.iterator();
    Optional<Point> bestEmptyPoint = Optional.empty();
    Optional<Point> bestOpponentPoint = Optional.empty();
    Optional<Point> bestTeamPoint = Optional.empty();

    int positionRank = 0;
    while (rankedPositionsIterator.hasNext()) {
      positionRank++;
      Point currentPosition = rankedPositionsIterator.next();
      PositionLookup currentLookup = this.world.lookupPosition(currentPosition);
      if (currentLookup.type == Type.EMPTY && bestEmptyPoint.isEmpty()) {
        bestEmptyPoint = Optional.of(currentPosition);
      } else if (currentLookup.type == Type.FIGHTER) {
        if (f.isOpponentOf(currentLookup.getFighter()) && bestEmptyPoint.isEmpty()
            && positionRank < GOOD_POSITION_CUT) {
          bestOpponentPoint = Optional.of(currentPosition);
        } else if (f.isTeammateOf(currentLookup.getFighter()) && bestEmptyPoint.isEmpty()
            && positionRank < BAD_POSITION_CUT) {
          bestTeamPoint = Optional.of(currentPosition);
        }
      }
    }

    Optional<Point> nonEmptyPoint =
        bestOpponentPoint.isPresent() ? bestOpponentPoint : bestTeamPoint;

    return bestEmptyPoint.isPresent() ? bestEmptyPoint : nonEmptyPoint;
  }


  private void makeMove(Fighter fighter, Point target) {
    PositionLookup lookup = this.world.lookupPosition(target);
    switch (lookup.type) {
      case EMPTY:
        this.world.moveFighterTo(fighter, target);
        break;
      case FIGHTER:
        handleFighterInteraction(fighter, lookup.getFighter());
        break;
      default:
        break;
    }
  }

  private void handleFighterInteraction(Fighter movingFighter, Fighter standingFighter) {
    if (movingFighter.isTeammateOf(standingFighter)) {
      standingFighter.increaseHealth();
    } else {
      standingFighter.decreaseHealth(movingFighter.getTeam());
    }
  }

  public World getWorld() {
    return world;
  }


  @Override
  public void teamInputLeft(Team t) {
    moveTeamCursorOf(t, -worldConfiguration.getCursorSpeed(), 0);
  }

  @Override
  public void teamInputUp(Team t) {
    moveTeamCursorOf(t, 0, worldConfiguration.getCursorSpeed());
  }

  @Override
  public void teamInputRight(Team t) {
    moveTeamCursorOf(t, worldConfiguration.getCursorSpeed(), 0);
  }

  @Override
  public void teamInputDown(Team t) {
    moveTeamCursorOf(t, 0, -worldConfiguration.getCursorSpeed());
  }

  private void moveTeamCursorOf(Team t, int deltaX, int deltaY) {
    Cursor cursor = world.getCursor(t);
    Point newPosition = cursor.getPosition().add(new Point(deltaX, deltaY)).clip(0, 0,
        worldConfiguration.getWidth(), worldConfiguration.getHeight());
    cursor.moveTo(newPosition);
  }

}
