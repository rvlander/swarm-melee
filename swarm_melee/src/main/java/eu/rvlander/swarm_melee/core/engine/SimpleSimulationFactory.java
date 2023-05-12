package eu.rvlander.swarm_melee.core.engine;

import eu.rvlander.swarm_melee.core.model.Cursor;
import eu.rvlander.swarm_melee.core.model.Fighter;
import eu.rvlander.swarm_melee.core.model.GridMap;
import eu.rvlander.swarm_melee.core.model.Map;
import eu.rvlander.swarm_melee.core.model.SimpleCursor;
import eu.rvlander.swarm_melee.core.model.SimpleFighter;
import eu.rvlander.swarm_melee.core.model.SimpleWorld;
import eu.rvlander.swarm_melee.core.model.Team;
import eu.rvlander.swarm_melee.core.model.World;
import eu.rvlander.swarm_melee.utils.Point;

import java.util.ArrayList;
import java.util.List;

public class SimpleSimulationFactory implements SimulationFactory {

  @Override
  public World createWorld(WorldConfiguration configuration) {
    Map map = new GridMap(configuration.getWidth(), configuration.getHeight());
    List<Fighter> fighters = new ArrayList<>();
    List<Cursor> cursors = new ArrayList<>();
    PositionPicker picker = new PositionPicker(configuration.getWidth(), configuration.getHeight());

    for (int i = 0; i < configuration.getNbCursors(); i++) {
      Team team = new Team();
      Cursor cursor = new SimpleCursor(picker.pick(), team);
      cursors.add(cursor);

      for (int j = 0; j < configuration.getNbFightersByCursors(); j++) {
        Fighter fighter = new SimpleFighter(team, piecker.pick())   
        fighters.add(fighter);
      }

    }


    return new SimpleWorld(map, cursors, fighters);
  }

  @Override
  public PositionsRanker createPositionsRanker(Map map, Point initialTarget) {
    return new NoObstaclesRanker();
  }

  @Override
  public PositionsGenerator createPositionsGenerator(Map map) {
    return new SimplePositionsGenerator(map);
  }

}
