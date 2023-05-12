package eu.rvlander.swarm_melee.core.model;

import eu.rvlander.swarm_melee.utils.Point;

import java.util.List;


public class SimpleWorld implements World {
  private Map map;
  private List<Cursor> cursors;
  private List<Fighter> fighters;



  public SimpleWorld(Map map, List<Cursor> cursors, List<Fighter> fighters) {
    this.map = map;
    this.cursors = cursors;
    this.fighters = fighters;
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
      for (Fighter f : fighters) {
        if (f.getPosition().equals(position)) {
          return PositionLookup.Fighter(f);
        }
      }
      return PositionLookup.Empty();
    } else {
      return PositionLookup.Forbidden();
    }
  }

  public Cursor getCursor(Team team) {
    return cursors.stream().filter(cursor -> cursor.getTeam().equals(team)).findAny().orElseThrow();
  }
}
