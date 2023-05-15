package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;
import java.util.HashMap;
import java.util.List;


public class SimpleWorld implements World {
  private Map map;
  private List<Cursor> cursors;
  private List<Fighter> fighters;
  private HashMap<Point, Fighter> fighterLookup = new HashMap<>();



  public SimpleWorld(Map map, List<Cursor> cursors, List<Fighter> fighters) {
    this.map = map;
    this.cursors = cursors;
    this.fighters = fighters;
    this.initializeLookup();
  }

  private void initializeLookup() {
    for (Fighter f : fighters) {
      fighterLookup.put(f.getPosition(), f);
    }
  }

  @Override
  public Map getMap() {
    return map;
  }

  @Override
  public List<Cursor> getCursors() {
    return cursors;
  }

  @Override
  public List<Fighter> getFighters() {
    return fighters;
  }

  @Override
  public PositionLookup lookupPosition(Point position) {
    NeighborhoodType type = map.get(position);
    if (type == NeighborhoodType.NONE) {
      Fighter f = fighterLookup.get(position);
      if (f != null) {
        return PositionLookup.Fighter(f);
      }
      return PositionLookup.Empty();
    } else {
      return PositionLookup.Forbidden();
    }
  }

  public Cursor getCursor(Team team) {
    return cursors.stream().filter(cursor -> cursor.getTeam().equals(team)).findAny().orElseThrow();
  }

  @Override
  public void moveFighterTo(Fighter f, Point newPosition) {
    if (fighterLookup.containsKey(newPosition)) {
      throw new Error("Fatal Error");
    }
    fighterLookup.remove(f.getPosition());
    f.moveTo(newPosition);
    fighterLookup.put(newPosition, f);
  }
}
